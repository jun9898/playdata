package com.example.hexagonaltest.Cart.application.port.in;

import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartResponseDTO;
import com.example.hexagonaltest.Cart.application.port.out.CartSelectOutputPort;
import com.example.hexagonaltest.Cart.application.usecase.CartSelectUseCase;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import com.example.hexagonaltest.board.application.port.out.BoardSelectOutputPort;
import com.example.hexagonaltest.board.application.usecase.BoardSelectUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartSelectInport implements CartSelectUseCase {

    private final CartSelectOutputPort outputPort;

    @Override
    public CartResponseDTO getCartData(Long cartNo) {
        return outputPort.getCartData(cartNo);
    }

    @Override
    public List<CartResponseDTO> getAllCartData() {
        return outputPort.getCartlist();
    }
}
