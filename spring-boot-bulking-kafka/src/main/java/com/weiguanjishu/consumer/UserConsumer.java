package com.weiguanjishu.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class UserConsumer {

    @KafkaListener(topics = "add_user")
    public void receiveMesage(String content) {
        System.out.println("消费消息：" + content);
    }
}
