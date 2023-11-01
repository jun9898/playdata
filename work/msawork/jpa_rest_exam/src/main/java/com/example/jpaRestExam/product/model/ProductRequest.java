package com.example.jpaRestExam.product.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {

    private String productName;
    private String info;
    private int price;
    private String image;
    private LocalDateTime insertTime;
    private Category category;
}
