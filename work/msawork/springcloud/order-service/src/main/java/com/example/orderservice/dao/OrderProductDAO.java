package com.example.orderservice.dao;

import com.example.orderservice.domain.OrderProductEntity;

import java.util.List;

public interface OrderProductDAO {

    // 주문상품을 등록
    void save(List<OrderProductEntity> orderProductList);
}
