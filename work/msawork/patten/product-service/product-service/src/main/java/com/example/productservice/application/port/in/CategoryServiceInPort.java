package com.example.productservice.application.port.in;

import com.example.productservice.adapter.in.web.dto.CategoryRequest;

public interface CategoryServiceInPort {
    void write(CategoryRequest category);
}
