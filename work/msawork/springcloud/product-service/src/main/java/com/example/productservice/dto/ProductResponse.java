package com.example.productservice.dto;

import com.example.productservice.entity.Category;
import com.example.productservice.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProductResponse {

    private Long productNo;
    private String productName;
    private String info;
    private int price;
    private String image;
    private LocalDateTime insertTime;
    private Category category;

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
                .productNo(product.getProductNo())
                .productName(product.getProductName())
                .info(product.getInfo())
                .price(product.getPrice())
                .image(product.getImage())
                .insertTime(product.getInsertTime())
                .category(product.getCategory())
                .build();
    }
}
