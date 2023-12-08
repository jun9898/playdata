package com.example.hexagonaltest.Cart.application.port.out;

import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartResponseDTO;

import java.util.List;

//아웃바운드포트 - dao단의 dao인터페이스
public interface CartSelectOutputPort {
    CartResponseDTO getCartData(Long cartNo);
    List<CartResponseDTO> getCartlist();
}

