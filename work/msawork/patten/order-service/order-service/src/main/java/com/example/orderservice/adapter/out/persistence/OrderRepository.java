package com.example.orderservice.adapter.out.persistence;

import com.example.orderservice.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findByCustomerId(Long customerId);
}
