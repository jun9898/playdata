package com.example.redisjwt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CustomUserDetailServiceTest {
    @Autowired
    CustomUserDetailService service;
    @Test
    void test(){
        System.out.println(service.loadUserByUsername("2"));
    }
}