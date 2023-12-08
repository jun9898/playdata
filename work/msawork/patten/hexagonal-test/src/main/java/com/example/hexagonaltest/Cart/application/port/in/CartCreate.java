package com.example.hexagonaltest.Cart.application.port.in;

import com.example.hexagonaltest.Cart.adapter.in.web.dto.CartInputDTO;
import com.example.hexagonaltest.Cart.application.port.out.CartCreateOutputPort;
import com.example.hexagonaltest.Cart.application.usecase.CartCreateUseCase;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.application.port.out.BoardCreateOutputPort;
import com.example.hexagonaltest.board.application.usecase.BoardCreateUseCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//외부 어댑터에 의해서 호출되는 input port의 구현체
//=> serviceImpl의 역할
@Service
@Transactional
@RequiredArgsConstructor
public class CartCreate implements CartCreateUseCase {
    private final CartCreateOutputPort outputPort;

    @Override
    public String createCartData(CartInputDTO board) {
        return outputPort.createBoard(board);
    }
}
