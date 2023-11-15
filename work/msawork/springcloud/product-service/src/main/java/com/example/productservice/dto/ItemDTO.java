package com.example.productservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String title;
    private String link;
    private String image;
    private int lprice;
    private String mallName;
    private String brand;
}
