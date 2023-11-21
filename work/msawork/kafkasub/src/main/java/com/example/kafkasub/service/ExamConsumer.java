package com.example.kafkasub.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ExamConsumer {

    @KafkaListener(id = "msa-id", topics = "kafkaexam2",
                   containerFactory = "concurrentFactory")
    public void listen(String message) {
        System.out.println("====================================================");
        System.out.println(message);
        System.out.println("====================================================");
    }

}
