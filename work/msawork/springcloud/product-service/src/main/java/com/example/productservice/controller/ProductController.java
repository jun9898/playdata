package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.service.CommunicationService;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CommunicationService communicationService;

    @GetMapping("/getdata")
    public String getData() {
        productService.insertAll(communicationService.getProductList());
        return "ok";
    }

}
