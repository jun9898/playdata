package com.example.productservice.application.port.in;

import com.example.productservice.adapter.in.web.dto.ProductRequest;
import com.example.productservice.adapter.in.web.dto.ProductResponse;

import java.util.List;

public interface ProductServiceInPort {
    void write(ProductRequest product);
    ProductResponse findByProductNo(Long productNo );
    List<ProductResponse> findAll();
    void insertAll(List<ProductRequest> prdlist);
}
