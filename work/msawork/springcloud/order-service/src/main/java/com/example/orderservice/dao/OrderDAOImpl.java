package com.example.orderservice.dao;

import com.example.orderservice.domain.OrderEntity;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAOImpl implements OrderDAO {

    private final OrderRepository repository;

    @Override
    public void save(OrderEntity order) {
        repository.save(order);
    }

    @Override
    public OrderEntity findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderEntity> findAllByCustomerId(Long customerId) {
        return repository.findAllByCustomerId(customerId);
    }
}
