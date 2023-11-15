package com.example.productservice.dao;

import com.example.productservice.entity.Product;

import java.util.List;

public interface ProductDAO {
    void write(Product product); // Product == entity
    void insertAll(List<Product> productList);
    Product findByProductNo(Long productNo);
    List<Product> findAll();
}
