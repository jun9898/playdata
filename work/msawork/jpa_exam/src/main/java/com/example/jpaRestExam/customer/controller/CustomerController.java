package com.example.jpaRestExam.customer.controller;

import com.example.jpaRestExam.customer.model.RequestCustomerDTO;
import com.example.jpaRestExam.customer.model.ResponseCustomerDTO;
import com.example.jpaRestExam.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody RequestCustomerDTO reuqest) {
        service.insert(reuqest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        List<ResponseCustomerDTO> allData = service.findAll();
        return ResponseEntity.ok(allData);
    }

    @GetMapping("/read/{customerId}")
    public ResponseEntity<?> read(@PathVariable Long customerId) {
        return ResponseEntity.ok(service.findById(customerId));
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<?> update(@PathVariable Long customerId, @RequestBody RequestCustomerDTO request){
        return ResponseEntity.ok(service.update(customerId, request));
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> delete(@PathVariable Long customerId){
        return ResponseEntity.ok(service.delete(customerId));
    }

    @GetMapping("/between")
    public ResponseEntity<?> delete(@RequestParam Long point1,
                                    @RequestParam Long point2){
        return ResponseEntity.ok(service.findByPoint(point1, point2));
    }




}
