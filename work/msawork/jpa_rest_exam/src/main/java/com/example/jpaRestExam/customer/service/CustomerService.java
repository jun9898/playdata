package com.example.jpaRestExam.customer.service;

import com.example.jpaRestExam.customer.model.RequestCustomerDTO;
import com.example.jpaRestExam.customer.model.ResponseCustomerDTO;

import java.util.List;

public interface CustomerService {

    void insert(RequestCustomerDTO customer);
    List<ResponseCustomerDTO> findAll();
    List<ResponseCustomerDTO> findByPoint(Long point1, Long point2);
    ResponseCustomerDTO findById(Long customerId);
    ResponseCustomerDTO update(Long customerId, RequestCustomerDTO customer);
    String delete(Long customerId);

}
