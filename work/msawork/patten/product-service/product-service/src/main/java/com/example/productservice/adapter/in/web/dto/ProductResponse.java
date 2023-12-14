package com.example.productservice.adapter.in.web.dto;

import com.example.productservice.adapter.out.persistence.Category;
import com.example.productservice.adapter.out.persistence.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long productNo;
    private String productName;
    private String info;
    private int price;
    private String image;
    private LocalDateTime insertTime;
    private Category category;

    public ProductResponse(Product entity){
        this.productNo = entity.getProductNo();
        this.productName = entity.getProductName();
        this.info = entity.getInfo();
        this.price = entity.getPrice();
        this.image = entity.getImage();
        this.insertTime = entity.getInsertTime();
        this.category = entity.getCategory();
    }
}
