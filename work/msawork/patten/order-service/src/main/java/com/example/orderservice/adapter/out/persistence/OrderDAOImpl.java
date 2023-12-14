package com.example.orderservice.adapter.out.persistence;

import com.example.orderservice.application.port.out.OrderDAO;
import com.example.orderservice.domain.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
@Slf4j
public class OrderDAOImpl implements OrderDAO {
    private final OrderRepository repository;
    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        //repository의 save메소드는 저장된 엔티티가 반환
        //저장이 되지 않는 경우 예외 처리를 해야 한다.
        return repository.save(orderEntity);
    }

    @Override
    public OrderEntity findById(Long orderId) {
        return null;
    }

    @Override
    public List<OrderEntity> getOrders(Long customerId) {
        List<OrderEntity> orderlist =  repository.findByCustomerId(customerId);
        log.info("조회결과=>{}",orderlist);
        log.info("상세조회결과=>{}",orderlist.get(0).getOrderproductlist());
        return orderlist;
    }
}
