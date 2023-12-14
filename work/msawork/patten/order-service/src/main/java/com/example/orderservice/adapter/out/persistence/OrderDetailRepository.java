package com.example.orderservice.adapter.out.persistence;

import com.example.orderservice.domain.entity.OrderProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository
                        extends JpaRepository<OrderProductEntity,Long> {
}
