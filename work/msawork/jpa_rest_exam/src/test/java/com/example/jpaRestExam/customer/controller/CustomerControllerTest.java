package com.example.jpaRestExam.customer.controller;

import com.example.jpaRestExam.customer.model.RequestCustomerDTO;
import com.example.jpaRestExam.customer.model.ResponseCustomerDTO;
import com.example.jpaRestExam.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CustomerControllerTest {

    @Autowired
    CustomerService service;

    @Test
    @Rollback(value = false)
    void insert() {
        RequestCustomerDTO test = new RequestCustomerDTO().builder()
                .password("123")
                .name("1234")
                .addr("1234")
                .tel("1234")
                .point(100)
                .info("info")
                .build();
        service.insert(test);
        // insert 테스트 성공
    }

    @Test
    void list() {
        List<ResponseCustomerDTO> all = service.findAll();
        for (ResponseCustomerDTO responseCustomerDTO : all) {
            System.out.println("responseCustomerDTO.toString() = " + responseCustomerDTO.toString());
        }
    }
    // id값이 이상하게 들어간다 왜지?

    @Test
    @Rollback(value = false)
    void read() {
        ResponseCustomerDTO byId = service.findById(102L);
        System.out.println("byId.toString() = " + byId.toString());
    }
    // read 성공

    @Test
    @Rollback(value = false)
    void delete() {
        service.delete(102L);
    }
    // delete 성공

    @Test
    @Rollback(value = false)
    void update() {
        RequestCustomerDTO test = new RequestCustomerDTO().builder()
                .password("update")
                .name("test")
                .addr("succ")
                .tel("ess")
                .point(1000)
                .info("plz")
                .build();
        service.update(2L,test);
    }
    // update test 성공

    @Test
    void between() {
        List<ResponseCustomerDTO> byPoint = service.findByPoint(50L, 150L);
        for (ResponseCustomerDTO responseCustomerDTO : byPoint) {
            System.out.println("responseCustomerDTO.toString() = " + responseCustomerDTO.toString());
        }
    }

}