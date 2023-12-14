package com.example.productservice.application.service;

import com.example.productservice.application.port.in.CategoryServiceInPort;
import com.example.productservice.adapter.in.web.dto.CategoryRequest;
import com.example.productservice.adapter.out.persistence.Category;
import com.example.productservice.application.port.out.CategoryDAOOutputPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryServiceInPort {
    private final CategoryDAOOutputPort categoryDAOOutputPort;
    @Override
    public void write(CategoryRequest category) {
        //CategoryRequest -> Entity
        ModelMapper mapper = new ModelMapper();
        Category categoryEntity = mapper.map(category,Category.class);
        categoryDAOOutputPort.write(categoryEntity);
    }
}
