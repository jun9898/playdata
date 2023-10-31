package com.example.jpaRestExam.jpatest.category;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;
    private String info;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private List<ProductEntity> productList = new ArrayList<>();

    public CategoryEntity(String categoryName, String info) {
        this.categoryName = categoryName;
        this.info = info;
    }
}
