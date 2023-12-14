package com.example.productservice.application.port.in;

import com.example.productservice.adapter.in.web.dto.ProductRequest;

import java.util.List;

public interface CommunicationServiceInPort {
    List<ProductRequest> getProductList();
}
