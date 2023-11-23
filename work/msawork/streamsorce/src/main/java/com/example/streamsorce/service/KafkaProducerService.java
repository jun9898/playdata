package com.example.streamsorce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void send(String message) {
        log.info("topic A message = {}", message);
        kafkaTemplate.send("topica", message);
    }

    public void sendB(String message) {
        log.info("topic B message = {}", message);
        kafkaTemplate.send("topicb", message);
    }


}
