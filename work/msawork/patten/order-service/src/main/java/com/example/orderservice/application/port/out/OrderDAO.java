package com.example.orderservice.application.port.out;

import com.example.orderservice.domain.entity.OrderEntity;

import java.util.List;

public interface OrderDAO {
    OrderEntity save(OrderEntity orderEntity);
    OrderEntity findById(Long orderId);

    List<OrderEntity> getOrders(Long customerId);
}
