package com.example.hexagonaltest.cart.application.usecase;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartResponseDTO;

import java.util.List;

public interface CartSelectUsecase {
    CartResponseDTO selectCart(Long id);
    List<CartResponseDTO> selectAllCart();
}
