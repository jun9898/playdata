package com.example.hexagonaltest.cart.adapter.in.web.dto;

import com.example.hexagonaltest.cart.adapter.out.persistence.CartEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartInputDTO {
    private String cartName;
    private Long productNo;
    private Long memberNo;

    public CartEntity toEntity(){
        return CartEntity.builder()
                .cartName(cartName)
                .productNo(productNo)
                .memberNo(memberNo)
                .build();
    }
}
