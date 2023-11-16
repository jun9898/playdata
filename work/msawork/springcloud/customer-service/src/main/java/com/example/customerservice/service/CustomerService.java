package com.example.customerservice.service;



import com.example.customerservice.model.CustomerOrderResponseDTO;
import com.example.customerservice.model.CustomerRequestDTO;
import com.example.customerservice.model.OrderDetailResqonseDTO;
import com.example.customerservice.model.OrderResponseDTO;

import java.util.List;

public interface CustomerService {
    void write(CustomerRequestDTO comment);
    //
    CustomerOrderResponseDTO getOrdersByCustomerId(Long customerId);
}

