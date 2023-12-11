package com.example.hexagonaltest.cart.adapter.in.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class CartResponseDTO {
    private Long cartNo;
    private String cartName;
    private Long productNo;
    private Long memberNo;
}
