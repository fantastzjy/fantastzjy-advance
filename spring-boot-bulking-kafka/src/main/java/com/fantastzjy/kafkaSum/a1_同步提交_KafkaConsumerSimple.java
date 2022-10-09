package com.fantastzjy.kafkaSum;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.*;


public class a1_同步提交_KafkaConsumerSimple {
    // 设置服务器地址
    private static final String bootstrapServer = "192.168.110.142:9092";

    // 设置主题
    private static final String topic = "topic-demo";

    // 设置主题
    private static final String topic2 = "topic-demo2";

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

        // 手动提交开启
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        // 将参数设置到消费者参数中
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        //消息订阅： subscribe、assign

        // 一、subscribe 订阅主题
        // 1、public void subscribe(Collection<String> topics) 可以订阅多个主题
        //consumer.subscribe(Arrays.asList(topic));
        // 2、public void subscribe(Pattern pattern)
        //consumer.subscribe(Pattern.compile("topic-demo*"));

        // 3、public void subscribe(Pattern pattern, ConsumerRebalanceListener listener)
        // 4、public void subscribe(Collection<String> topics, ConsumerRebalanceListener listener)

        // 二、assign 指定订阅的分区
        TopicPartition topicPartition = new TopicPartition(topic, 0);
        consumer.assign(Arrays.asList(topicPartition));

        // 初始化offset位移为-1
        long lastConsumeOffset = -1;
        while (true) {
            // 每隔一秒监听一次，拉去指定主题分区的消息
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
            if (records.isEmpty()) {
                break;
            }
            // 获取到消息
            List<ConsumerRecord<String, String>> partitionRecords = records.records(topicPartition);
            // 获取到消息的offset位移信息，最后消费的位移
            lastConsumeOffset = partitionRecords.get(partitionRecords.size() - 1).offset();
            // System.out.println("the last offset is " + lastConsumeOffset);
            // 同步提交消费位移
            consumer.commitSync();
        }

        // 当前消费者最后一个消费的位置
        System.out.println("consumed offset is " + lastConsumeOffset);

        // 提交，下次消费从哪个位置开始
        OffsetAndMetadata committed = consumer.committed(topicPartition);
        System.out.println("committed offset is " + committed.offset());

        // 下次消费从哪个位置开始
        long position = consumer.position(topicPartition);
        System.out.println("the offset of the next record is " + position);
    }
}
