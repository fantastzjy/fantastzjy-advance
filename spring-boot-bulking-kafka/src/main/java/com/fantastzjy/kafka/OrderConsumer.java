package com.fantastzjy.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

@Component
public class OrderConsumer {
    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @Value("${kafka.order.bootstrap.servers}")
    private String bootstrapServers;

    @Value("${kafka.order.topic}")
    private String topic;

    @Value("${kafka.order.groupId}")
    private String groupId;


    private KafkaConsumer<String, String> consumer;

    @PostConstruct
    public void init() {
        try {

            Properties props = buildProperties();
            consumer = new KafkaConsumer<>(props);
            consumer.subscribe(Arrays.asList(topic));

            logger.info(getClass().getSimpleName() + " init start..." + new Date());

            SingeThreadUtil.getKafkaConsumer().submit(this::run);
            //解决异步线程还未开始消费，主线程将平台实现类bean对象销毁
            //Thread.sleep(60_000);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        logger.info(getClass().getSimpleName() + " init end..." + new Date());
    }

    private void run() {
        ConsumerRecords<String, String> records;
        while (true) {
            try {
                System.out.println(111);
                records = consumer.poll(Duration.ofSeconds(5));
                consumer.commitAsync();
                if (null == records || records.count() <= 0) {
                    continue;
                }
                logger.info(getClass().getSimpleName() + "kafka consume counts:{}", records.count());
                records.forEach(record -> {
                    System.out.println("test消费:" + record.value());
                });

                Thread.sleep(1000);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private Properties buildProperties() {
        Properties props = new Properties();

        // 设置集群信息
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        // 设置消费组名
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        // 设置消费组名
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, groupId);
        // 是否自动提交（一般会关闭自动提交，然后在确认消息消费成功后手动提交offset，这样可以避免自动提交了offset，但是消费的时候宕机引发的消费丢失问题）
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        // 若没有指定offset，默认从最后的offset（latest）开始；earliest表示从最早的offset开始
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // consumer给broker发送心跳的间隔时间
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 3000);
        // 服务端broker多久感知不到一个consumer心跳就认为他故障了，会将其踢出消费组，对应的Partition也会被重新分配给其他consumer
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30 * 1000);
        // 一次性拉取的条数，这个参数用来配置 Consumer 在一次拉取请求中拉取的最大消息数，默认值为500（条）
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 2000);
        // 如果两次poll操作间隔超过了这个时间，broker就会认为这个consumer处理能力太弱，会将其踢出消费组，将分区分配给别的consumer消费
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 30 * 1000);
        // 指定在多久之后关闭闲置的连接
        props.put(ConsumerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, 180 * 1000L);
        // key的反序列化
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        // value的反序列化
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return props;
    }

    @PreDestroy
    public void close() {
        logger.info(getClass().getSimpleName() + " destroy start..." + new Date());
        if (null != consumer) {
            consumer.commitSync();
            consumer.close();
            SingeThreadUtil.getKafkaConsumer().shutdown();
        }
        logger.info(getClass().getSimpleName() + " destroy end..." + new Date());
    }
}
