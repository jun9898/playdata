package com.example.jpaRestExam.product.dao;

import com.example.jpaRestExam.product.model.Category;
import com.example.jpaRestExam.product.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Category> getCategory();
    void insert(Product request) ;
    List<Product> findAll();

}
