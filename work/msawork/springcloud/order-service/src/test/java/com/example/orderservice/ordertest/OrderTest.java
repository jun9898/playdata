package com.example.orderservice.ordertest;

import com.example.orderservice.domain.OrderProductEntity;
import com.example.orderservice.domain.OrderRequestDTO;
import com.example.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class OrderTest {

    @Autowired
    OrderService service;

    @Test
    @Rollback(value = false)
    void createOrderTest() {
    }
}
