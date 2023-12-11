package com.example.hexagonaltest.cart.adapter.out.persistence;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartResponseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cart")

@Builder
public class CartEntity {
    @Id @GeneratedValue
    private Long cartNo;
    private String cartName;
    private Long productNo;
    private Long memberNo;

    public CartResponseDTO toResponseDTO(){
        CartResponseDTO dto = new CartResponseDTO();
        dto.setCartNo(this.getCartNo());
        dto.setCartName(this.cartName);
        dto.setProductNo(this.productNo);
        dto.setMemberNo(this.getMemberNo());
        return dto;
    }
}
