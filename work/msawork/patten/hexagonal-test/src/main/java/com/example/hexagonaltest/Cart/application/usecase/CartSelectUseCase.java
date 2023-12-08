package com.example.hexagonaltest.Cart.application.usecase;

import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartResponseDTO;

import java.util.List;

///인바운드 포트 역할
//어댑터와 통신하기 위한 동작을 정의한 인터페이스
//포트는 구체적으로 작업하기 위한 내용이 정의되지 않은 인터페이스
public interface CartSelectUseCase {
    public CartResponseDTO getCartData(Long cartNo);
    public List<CartResponseDTO> getAllCartData();
}
