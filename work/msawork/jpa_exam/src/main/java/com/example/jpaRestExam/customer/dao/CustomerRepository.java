package com.example.jpaRestExam.customer.dao;

import com.example.jpaRestExam.customer.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> findByPointBetween(long startId, long endId);
}
