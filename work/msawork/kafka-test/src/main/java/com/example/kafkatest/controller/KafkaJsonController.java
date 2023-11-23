package com.example.kafkatest.controller;

import com.example.kafkatest.model.ChatMessage;
import com.example.kafkatest.service.producer.KafkaJsonProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KafkaJsonController {

    private final KafkaJsonProducer producerService;

    @PostMapping("/chat/send")
    public String sendMessage(@RequestBody ChatMessage message) {
        log.info("message => {}", message);
        producerService.sendMessage(message);
        return "ok";
    }
}
