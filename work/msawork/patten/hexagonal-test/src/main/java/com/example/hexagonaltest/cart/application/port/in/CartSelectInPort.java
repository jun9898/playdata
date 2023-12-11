package com.example.hexagonaltest.cart.application.port.in;

import com.example.hexagonaltest.cart.adapter.in.web.dto.CartResponseDTO;
import com.example.hexagonaltest.cart.application.port.out.CartSelectOutPort;
import com.example.hexagonaltest.cart.application.usecase.CartSelectUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartSelectInPort implements CartSelectUsecase {
    private final CartSelectOutPort cartSelectOutPort;
    @Override
    public CartResponseDTO selectCart(Long id) {
        return cartSelectOutPort.selectCart(id);
    }

    @Override
    public List<CartResponseDTO> selectAllCart() {
        return cartSelectOutPort.selectAllCart();
    }
}
