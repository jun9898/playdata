package com.example.kafkasub;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

@SpringBootApplication
public class KafkasubApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkasubApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate,
									KafkaMessageListenerContainer<String, String> container) {
		return args -> {
			container.start();
		};
	}
}
