package com.example.customerservice.service;

import com.example.customerservice.dao.CustomerDAO;
import com.example.customerservice.model.*;
import lombok.RequiredArgsConstructor;

//import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final PasswordEncoder passwordEncoder;
    private final CustomerDAO dao;
    private final RestTemplate restTemplate;

    @Transactional
    @Override
    public void write(CustomerRequestDTO customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        CustomerEntity entity = modelMapper.map(customer, CustomerEntity.class);
        System.out.println("entity.toString() = " + entity.toString());
        dao.write(entity);
    }

    // 로그인한 사용자의 주문정보 order-service에 요청해서 리턴하는 메소드
    @Override
    public CustomerOrderResponseDTO getOrdersByCustomerId(Long customerId) {
        CustomerUserDetail detail = (CustomerUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 커스터머의 기본 정보 조회
        // 커스터머의 주문 내역 조회
        String url = "http://localhost:9500/order/getOrders/" + customerId;
        ResponseEntity<List<OrderResponseDTO>> orderlistResponse =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<OrderResponseDTO>>() {});
        List<OrderResponseDTO> orderlist = orderlistResponse.getBody();
        log.info("=========================================== 주문내역 결과 {} ============================================", orderlist.toString());

        // 고객데이터와 주문데이터를 DTO로 만들어서 리턴
        CustomerOrderResponseDTO customerOrderDTO = new CustomerOrderResponseDTO();
        customerOrderDTO.setCustomerInfo(detail.getCustomerResponseDTO());
        customerOrderDTO.setOrderlist(orderlist);
        return customerOrderDTO;
    }
}
