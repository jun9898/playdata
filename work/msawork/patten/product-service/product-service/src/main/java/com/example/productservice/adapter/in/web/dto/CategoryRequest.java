package com.example.productservice.adapter.in.web.dto;

import com.example.productservice.adapter.out.persistence.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryRequest {
    private Long categoryId;
    private String categoryName;
    private String info;
    public CategoryRequest(Category entity){
        this.categoryId = entity.getCategoryId();
        this.categoryName = entity.getCategoryName();
        this.info = entity.getInfo();
    }

    public CategoryRequest(String categoryName, String info) {
        this.categoryName = categoryName;
        this.info = info;
    }
}
