package com.example.jpaRestExam.customer.service;

import com.example.jpaRestExam.customer.dao.CustomerDAO;
import com.example.jpaRestExam.customer.model.CustomerEntity;
import com.example.jpaRestExam.customer.model.RequestCustomerDTO;
import com.example.jpaRestExam.customer.model.ResponseCustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private final CustomerDAO dao;

    @Override
    public void insert(RequestCustomerDTO customer) {
        dao.insert(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResponseCustomerDTO> findAll() {
        return dao.findAll().stream()
                .map(ResponseCustomerDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseCustomerDTO> findByPoint(Long point1, Long point2) {
        return dao.findByPoint(point1,point2).stream()
                .map(ResponseCustomerDTO::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseCustomerDTO findById(Long customerId) {
        return ResponseCustomerDTO.from(dao.findByCustomerId(customerId));
    }

    @Override
    public ResponseCustomerDTO update(Long customerId, RequestCustomerDTO customer) {
        CustomerEntity update = dao.update(customerId, customer);/* 기존 엔티티 */
        update.setPassword(customer.getPassword());
        update.setName(customer.getName());
        update.setAddr(customer.getAddr());
        update.setTel(customer.getTel());
        update.setPoint(customer.getPoint());
        update.setInfo(customer.getInfo());
        return ResponseCustomerDTO.from(update);
    }

    @Override
    public String delete(Long customerId) {
        return dao.delete(customerId);
    }
}
