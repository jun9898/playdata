package com.example.productservice;

import com.example.productservice.service.CommunicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchTest {

    @Autowired
    CommunicationService service;

    @Test
    void test() {

    }
}
