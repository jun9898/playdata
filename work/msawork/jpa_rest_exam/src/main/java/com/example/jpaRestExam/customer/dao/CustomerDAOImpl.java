package com.example.jpaRestExam.customer.dao;

import com.example.jpaRestExam.customer.model.CustomerEntity;
import com.example.jpaRestExam.customer.model.RequestCustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerDAOImpl implements CustomerDAO{

    private final CustomerRepository repository;

    @Override
    public void insert(RequestCustomerDTO customer) {
        repository.save(CustomerEntity.dtoToEntity(customer));
    }

    @Override
    public List<CustomerEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CustomerEntity findByCustomerId(Long customerId) {
        return repository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("번호를 확인하세요"));
    }

    @Override
    public List<CustomerEntity> findByPoint(Long point1, Long point2) {
        return repository.findByPointBetween(point1, point2);
    }

    @Override
    public CustomerEntity update(Long customerId, RequestCustomerDTO customer) {
        return repository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("번호를 확인하세요"));
    }

    @Override
    public String delete(Long customerId) {
        repository.deleteById(customerId);
        return "ok";
    }
}
