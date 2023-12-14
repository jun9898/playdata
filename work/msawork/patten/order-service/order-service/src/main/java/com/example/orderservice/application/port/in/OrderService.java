package com.example.orderservice.application.port.in;

import com.example.orderservice.adapter.in.web.dto.OrderRequestDTO;
import com.example.orderservice.adapter.in.web.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    void save(OrderRequestDTO orderEntity);
    OrderResponseDTO findById(Long orderId);

    List<OrderResponseDTO> findAllByCustomerId(Long customerId);
}
