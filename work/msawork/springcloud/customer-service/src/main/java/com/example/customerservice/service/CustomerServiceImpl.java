package com.example.customerservice.service;

import com.example.customerservice.dao.CustomerDAO;
import com.example.customerservice.model.CustomerEntity;
import com.example.customerservice.model.CustomerRequestDTO;
import lombok.RequiredArgsConstructor;

//import org.modelmapper.ModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final PasswordEncoder passwordEncoder;
    private final CustomerDAO dao;
    @Transactional
    @Override
    public void write(CustomerRequestDTO customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        CustomerEntity entity = modelMapper.map(customer, CustomerEntity.class);
        System.out.println("entity.toString() = " + entity.toString());
        dao.write(entity);
    }
}
