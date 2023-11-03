package com.example.jpaRestExam.product.repository;

import com.example.jpaRestExam.product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
