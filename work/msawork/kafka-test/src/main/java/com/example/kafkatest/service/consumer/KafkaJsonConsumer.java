package com.example.kafkatest.service.consumer;

import com.example.kafkatest.model.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaJsonConsumer {

    @KafkaListener(topics = "springjsonexam", groupId = "jsontestgroup",
            containerFactory = "getKafkaListenerContainer" )
    public void getMessage(ChatMessage message) {
        log.info("=============================================");
        log.info("{} : {} =============> {}", message.getRoomId(), message.getSender(), message.getMessage());
        log.info("=============================================");
    }
}
