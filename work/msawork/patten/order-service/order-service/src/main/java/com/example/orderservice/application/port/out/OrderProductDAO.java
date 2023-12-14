package com.example.orderservice.application.port.out;

import com.example.orderservice.domain.entity.OrderProductEntity;

import java.util.List;

public interface OrderProductDAO {
    //주문상품등록
    void save(List<OrderProductEntity> orderproductlist);
}
