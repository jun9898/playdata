package com.example.customerservice.dao;

import com.example.customerservice.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<CustomerEntity,Long> {

    CustomerEntity findByUsername(String username);
}
