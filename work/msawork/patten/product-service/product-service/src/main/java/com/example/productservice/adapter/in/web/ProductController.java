package com.example.productservice.adapter.in.web;

import com.example.productservice.application.port.in.CommunicationServiceInPort;
import com.example.productservice.application.port.in.ProductServiceInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceInPort service;
    private final CommunicationServiceInPort comm_service;
    @GetMapping("/getdata")
    public String getData(){

        service.insertAll(comm_service.getProductList());
        return  "ok";

    }
}
