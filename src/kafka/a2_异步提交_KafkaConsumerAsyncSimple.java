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
 * 异步提交方式。手动提交有一个缺点，就是当发起提交时调用应用会阻塞。
 * 当然我们可以减少手动提交的频率，但这个会增加消息重复的概率（和自动提交一样）。
 * 另外一个解决方法是，使用异步提交。
 * 但是异步提交也有一个缺点，那就是如果服务器返回提交失败，异步提交不会进行重试。
 * 相比较起来，同步提交会进行重试知道成功或者最后抛出异常给应用。
 * 异步提交没有实现重试是因为，如果同时存在多个异步提交，进行重试可能会导致位移覆盖。
 * 比如，我们发起一个异步提交commitA，此时提交位移是2000，随后又发起了一个异步提交commitB且位移为3000，commitA提交失败但commitB提交失败，此时commitA进行重试并成功的话，会将实际上已经提交的位移从3000回滚到2000，导致消息重复消费。
 */
public class a2_异步提交_KafkaConsumerAsyncSimple {
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
        properties.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer.client.id.demo");

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
            if (consumer != null) {
                //同步提交最后消费记录
                consumer.commitSync();
                consumer.close();
            }
        }
    }
}