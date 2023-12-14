package com.example.orderservice.dao;

import com.example.orderservice.adapter.out.persistence.OrderDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class OrderDAOImplTest {
    @Autowired
    OrderDAOImpl dao;
    @Test
    void test(){
        dao.getOrders(2L);
    }
}