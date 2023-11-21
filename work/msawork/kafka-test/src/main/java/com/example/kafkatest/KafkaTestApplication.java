package com.example.kafkatest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

@SpringBootApplication
@Slf4j
public class KafkaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaTestApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate,
                                    KafkaMessageListenerContainer<String, String> container) {
        return args -> {
//            kafkaTemplate.send("springexam", "spring for kafka");
            container.start();
            Thread.sleep(1000);
            log.info("=================pause==================");
            container.pause();

            log.info("=================resume==================");
            Thread.sleep(1000);
            container.resume();
        };
    }
}
