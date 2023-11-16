package com.example.orderservice.service;

import com.example.orderservice.domain.OrderResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Test
    void findAllByCustomerIdTest() {
        List<OrderResponseDTO> allByCustomerId = orderService.findAllByCustomerId(1L);
        for (OrderResponseDTO orderResponseDTO : allByCustomerId) {
            System.out.println("orderResponseDTO.toString() = " + orderResponseDTO.toString());
        }
    }

}