package com.example.hexagonaltest.Cart.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartInputDTO {
    private String title;
    private String content;
    private String writer;
}
