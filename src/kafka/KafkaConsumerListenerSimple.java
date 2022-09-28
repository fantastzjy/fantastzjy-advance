package kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;

/**
 * @Package: kafka
 * @ClassName: KafkaConsumerListenerSimple
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-9-28 14:48
 * @Description:
 */
public class KafkaConsumerListenerSimple {

    // 设置服务器地址
    private static final String bootstrapServer = "192.168.110.142:9092";

    // 设置主题
    private static final String topic = "topic-demo";

    // 设置消费者组
    private static final String groupId = "group.demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        // 设置反序列化key参数信息
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // 设置反序列化value参数信息
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // 设置服务器列表信息，必填参数，该参数和生产者相同，，制定链接kafka集群所需的broker地址清单，可以设置一个或者多个
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);

        // 设置消费者组信息，消费者隶属的消费组，默认为空，如果设置为空，则会抛出异常，这个参数要设置成具有一定业务含义的名称
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        // 制定kafka消费者对应的客户端id，默认为空，如果不设置kafka消费者会自动生成一个非空字符串。
        properties.put("client.id", "consumer.client.id.demo");

        // 设置每次从最早的offset开始消费
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // 手动提交开启
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        // 将参数设置到消费者参数中
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        // 消息订阅
        // consumer.subscribe(Collections.singletonList(topic));

        // 如果发生消息重复消费或者消息丢失的情况，当一个分区的消费者发生变更的时候，kafka会出现再均衡
        // kafka提供了再均衡监听器，可以处理自己的行为，发生再均衡期间，消费者无法拉取消息的。
        Map<TopicPartition, OffsetAndMetadata> currentOffsets = new HashMap<TopicPartition, OffsetAndMetadata>();
        consumer.subscribe(Collections.singletonList(topic), new ConsumerRebalanceListener() {

            //
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
                // 尽量避免重复消费
                consumer.commitSync(currentOffsets);// 同步位移的提交
            }

            //
            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

            }

        });

        while (true) {
            // 每隔一秒监听一次，拉去指定主题分区的消息
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            if (records.isEmpty()) {
                break;
            }
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.toString());

                // 异步提交消息位移，在发生再均衡动作之前通过再均衡监听器的onPartitionsRevoked回调执行commitSync方法同步提交位移
                currentOffsets.put(new TopicPartition(record.topic(), record.partition()),
                        new OffsetAndMetadata(record.offset() + 1));
            }
            // 消费者的消费异步提交很有可能出现消息丢失的情况，所以在拉取完消息之后可以将消息的offset位移进行记录
            consumer.commitAsync(currentOffsets, new OffsetCommitCallback() {

                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> offsets, Exception exception) {
                    if (exception == null) {
                        System.out.println("异步回调成功了,offset : " + offsets);
                    } else {
                        System.err.println("fail to commit offsets " + offsets + " , " + exception);
                    }
                }
            });
        }

        // 关闭客户端
        consumer.close();

    }
}
