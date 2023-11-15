package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CommunicationService {
    List<ProductRequest> getProductList();
//    void searchAndInsert();
}
