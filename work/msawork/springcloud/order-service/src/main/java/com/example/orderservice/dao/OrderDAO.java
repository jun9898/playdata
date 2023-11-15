package com.example.orderservice.dao;

import com.example.orderservice.domain.OrderEntity;

import java.util.List;

public interface OrderDAO {


    void save(OrderEntity order);
    OrderEntity findById(Long orderId);
    List<OrderEntity> findAllByCustomerId(Long customerId);

}
