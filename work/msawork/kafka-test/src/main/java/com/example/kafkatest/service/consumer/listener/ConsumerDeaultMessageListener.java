package com.example.kafkatest.service.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

public class ConsumerDeaultMessageListener implements MessageListener<String, String> {
    // 메시지가 전송되면 onMessage가 호출되고 데이터가 ConsumerRecord로 전달된다.
    // record로 전달되는 방식은 데이터가 각각 한 건씩 전달되는 방식
    @Override
    public void onMessage(ConsumerRecord<String, String> data) {
        System.out.println("data = " + data);
        System.out.println("data.key() = " + data.key());
        System.out.println("data.value() = " + data.value());
    }
}
