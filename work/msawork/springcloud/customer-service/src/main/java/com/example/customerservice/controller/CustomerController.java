package com.example.customerservice.controller;

import com.example.customerservice.model.CustomerRequestDTO;
import com.example.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> createComment(CustomerRequestDTO request){
        System.out.println(request+"==============================");
        customerService.write(request);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
