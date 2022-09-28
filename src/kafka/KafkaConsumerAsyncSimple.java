package kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Package: kafka
 * @ClassName: KafkaConsumerAsyncSimple
 * @Author: jiaying2.zhang
 * @CreateTime: 2022-9-28 14:46
 * @Description:
 */
public class KafkaConsumerAsyncSimple {
    private static AtomicBoolean running = new AtomicBoolean(true);

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

        // 将参数设置到消费者参数中
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        // 订阅主题
        consumer.subscribe(Arrays.asList(topic));

        try {
            while (running.get()) {
                // 每隔一秒监听一次，拉去指定主题分区的消息
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                if (records.isEmpty()) {
                    break;
                }
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("我要开始消费了： " + record.toString());
                }

                // 异步回调，适合消息量非常大，但是允许消息重复的
                consumer.commitAsync(new OffsetCommitCallback() {

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
        } finally {
            // 关闭客户端
            consumer.close();
        }

    }

}
