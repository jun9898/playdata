package com.example.discoveryserverexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryserverexamApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryserverexamApplication.class, args);
	}

}
