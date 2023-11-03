package com.example.jpaRestExam.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;
    private String info;
    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    List<Product> productList;

    public Category(String categoryName, String info) {
        this.categoryName = categoryName;
        this.info = info;
    }
}










