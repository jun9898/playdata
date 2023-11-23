package com.example.streamsorce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final KafkaProducerService service;

    @KafkaListener(topics = "topica", groupId = "testgroup",
                   containerFactory = "getKafkaListenerContainer")
    public void getTopicA(String message) {
        if (message.length() >= 5) {
//            service.sendB(message);
        }
    }
}
