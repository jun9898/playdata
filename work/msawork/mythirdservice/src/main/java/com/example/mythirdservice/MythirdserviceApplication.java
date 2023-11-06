package com.example.mythirdservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MythirdserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MythirdserviceApplication.class, args);
    }

}
