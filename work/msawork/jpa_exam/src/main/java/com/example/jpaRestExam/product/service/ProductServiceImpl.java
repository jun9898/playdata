package com.example.jpaRestExam.product.service;

import com.example.jpaRestExam.product.dao.ProductDAO;
import com.example.jpaRestExam.product.model.Category;
import com.example.jpaRestExam.product.model.Product;
import com.example.jpaRestExam.product.model.ProductRequest;
import com.example.jpaRestExam.product.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductDAO dao;
    @Override
    public List<Category> getCategory() {
        return dao.getCategory();
    }

    @Override
    @Transactional
    public void insert(ProductRequest request) {
        Product entity =
                new Product(request.getProductName(),
                        request.getInfo(),
                        request.getPrice(),
                        request.getImage(),
                        request.getCategory());
        dao.insert(entity);
    }

    @Override
    public List<ProductResponse> findAll() {
        return dao.findAll().stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }


}
