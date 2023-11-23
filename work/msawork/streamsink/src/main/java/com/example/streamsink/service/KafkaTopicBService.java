package com.example.streamsink.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableKafka
@RequiredArgsConstructor
public class KafkaTopicBService {

    @KafkaListener(topics = "topicb", groupId = "testgroup",
                   containerFactory = "getKafkaListenerContainer")
    public void getTopicA(String message) {
        log.info("TopicB Service message  => {}", message);
    }
}
