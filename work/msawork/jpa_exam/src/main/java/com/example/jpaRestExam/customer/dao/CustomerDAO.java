package com.example.jpaRestExam.customer.dao;

import com.example.jpaRestExam.customer.model.CustomerEntity;
import com.example.jpaRestExam.customer.model.RequestCustomerDTO;

import java.util.List;

public interface CustomerDAO {

    void insert(RequestCustomerDTO customer);
    List<CustomerEntity> findAll();
    CustomerEntity findByCustomerId(Long customerId);
    List<CustomerEntity> findByPoint(Long point1, Long point2);
    CustomerEntity update(Long customerId, RequestCustomerDTO customer);
    String delete(Long customerId);
}
