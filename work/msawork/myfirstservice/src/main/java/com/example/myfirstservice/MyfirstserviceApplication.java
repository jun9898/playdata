package com.example.myfirstservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyfirstserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfirstserviceApplication.class, args);
	}

}
