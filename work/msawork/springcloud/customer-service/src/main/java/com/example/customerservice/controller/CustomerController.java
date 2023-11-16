package com.example.customerservice.controller;

import com.example.customerservice.model.CustomerOrderResponseDTO;
import com.example.customerservice.model.CustomerRequestDTO;
import com.example.customerservice.model.CustomerResponseDTO;
import com.example.customerservice.model.CustomerUserDetail;
import com.example.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("my/api/create")
    public ResponseEntity<?> createComment(CustomerRequestDTO request){
        System.out.println(request+"==============================");
        customerService.write(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("my/api/mypage")
    public CustomerOrderResponseDTO userTest(Authentication mydata) {
        //내 정보 조회 - SecurityuContextHolder 안에 SecurityContext 에 Authentication
        //이 저장되어 있으므로 스프링이 자동으로 객체를 컨트롤러에 넘겨준다
        CustomerUserDetail userDetail = (CustomerUserDetail) mydata.getPrincipal();
        log.info("test ================================> {}" ,userDetail.toString());
        ModelMapper mapper = new ModelMapper();
        CustomerResponseDTO dto = mapper.map(userDetail.getCustomerResponseDTO(), CustomerResponseDTO.class);
        CustomerOrderResponseDTO customerdto = customerService.getOrdersByCustomerId(dto.getCustomerGenerateId());
        log.info("customerDTO ===========================================> {} " ,customerdto.toString());
        return customerdto;
    }
}
