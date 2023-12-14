package com.example.orderservice.adapter.out.persistence;

import com.example.orderservice.application.port.out.OrderProductDAO;
import com.example.orderservice.domain.entity.OrderProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderProductDAOImpl implements OrderProductDAO {
    private final OrderDetailRepository repository;

    @Override
    public void save(List<OrderProductEntity> orderproductlist) {
        repository.saveAll(orderproductlist);
    }
}
