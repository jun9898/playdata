package com.example.jpaRestExam.product.repository;

import com.example.jpaRestExam.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
