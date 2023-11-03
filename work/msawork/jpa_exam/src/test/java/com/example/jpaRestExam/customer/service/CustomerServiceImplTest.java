package com.example.jpaRestExam.customer.service;

import com.example.jpaRestExam.customer.dao.CustomerDAO;
import com.example.jpaRestExam.customer.model.RequestCustomerDTO;
import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.RequiredTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerServiceImplTest {

    @Autowired
    EntityManager em;

    @Autowired
    CustomerDAO dao;

    @Test
    @Rollback(value = false)
    void insert() {
        RequestCustomerDTO test = new RequestCustomerDTO().builder()
                .password("test")
                .name("test name")
                .addr("test addr")
                .tel("test tel")
                .point(100)
                .info("test info")
                .build();
        dao.insert(test);
        // insert 테스트 성공
    }
}