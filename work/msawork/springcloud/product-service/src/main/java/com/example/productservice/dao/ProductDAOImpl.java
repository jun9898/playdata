package com.example.productservice.dao;

import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO{

    private final ProductRepository repository;
    @Override
    public void write(Product product) {

    }

    @Override
    public void insertAll(List<Product> productList) {
        repository.saveAll(productList);
    }

    @Override
    public Product findByProductNo(Long productNo) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
