package com.example.mysecondservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MysecondserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysecondserviceApplication.class, args);
    }

}
