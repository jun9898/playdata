package com.example.jpaRestExam.product.dao;

import lombok.RequiredArgsConstructor;
import com.example.jpaRestExam.product.model.Category;
import com.example.jpaRestExam.product.model.Product;
import com.example.jpaRestExam.product.repository.CategoryRepository;
import com.example.jpaRestExam.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository
public class ProductDAOImpl implements ProductDAO{
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void insert(Product request) {
        productRepository.save(request);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
