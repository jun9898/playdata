package com.example.jpaRestExam.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long productNo;
    private String productName;
    private String info;
    private int price;
    private String image;
    @CreationTimestamp
    private LocalDateTime insertTime;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String productName, String info, int price, String image, Category category) {
        this.productName = productName;
        this.info = info;
        this.price = price;
        this.image = image;
        this.category = category;
    }
}
