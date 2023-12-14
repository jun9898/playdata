package com.example.productservice.application.port.out;

import com.example.productservice.adapter.out.persistence.Category;

public interface CategoryDAOOutputPort {
    void write(Category category);
    Category findByCategoryId(Long categoryId);
}
