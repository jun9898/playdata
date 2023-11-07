package com.example.customerservice.dao;

import com.example.customerservice.model.CustomerEntity;

public interface CustomerDAO {
    void write(CustomerEntity customerRequest);

    CustomerEntity login(String username);
}
