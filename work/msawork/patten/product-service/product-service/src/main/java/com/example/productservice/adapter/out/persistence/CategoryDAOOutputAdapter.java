package com.example.productservice.adapter.out.persistence;

import com.example.productservice.application.port.out.CategoryDAOOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryDAOOutputAdapter implements CategoryDAOOutputPort {
    private final CategoryRepository repository;
    @Override
    public void write(Category category) {
        repository.save(category);
    }

    @Override
    public Category findByCategoryId(Long categoryId) {
        return repository.findById(categoryId).get();
    }
}
