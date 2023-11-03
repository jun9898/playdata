package com.example.jpaRestExam.product.service;

import com.example.jpaRestExam.product.model.Category;
import com.example.jpaRestExam.product.model.Product;
import com.example.jpaRestExam.product.model.ProductRequest;
import com.example.jpaRestExam.product.model.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Category> getCategory();
    void insert(ProductRequest request) ;
    List<ProductResponse> findAll();
}
