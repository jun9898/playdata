package com.example.orderservice.controller;

import com.example.orderservice.domain.OrderRequestDTO;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService service;
    @PostMapping("/create")
    public void create(@RequestBody OrderRequestDTO order) {
        log.info("주문내역 ===================> {}" ,order);
        service.save(order);
    }

}
