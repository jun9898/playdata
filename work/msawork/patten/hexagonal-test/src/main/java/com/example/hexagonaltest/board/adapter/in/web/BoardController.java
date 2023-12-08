package com.example.hexagonaltest.board.adapter.in.web;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import com.example.hexagonaltest.board.application.usecase.BoardCreateUseCase;
import com.example.hexagonaltest.board.application.usecase.BoardSelectUseCase;
import com.example.hexagonaltest.common.WebInAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//인바운드 어댑터
@WebInAdapter
@RestController
@RequiredArgsConstructor
public class BoardController {
    //서비스 상위 정의하고 작업 - port in의 usecase
    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardSelectUseCase boardSelectUseCase;
    @PostMapping("/boardcreate")
    public ResponseEntity<String> createBoard(@RequestBody BoardInputDTO board){
        String result = boardCreateUseCase.createBoardData(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/getBoard/{boardNo}")
    public ResponseEntity<BoardResponseDTO> getBoardData(@PathVariable Long boardNo) {
        BoardResponseDTO boardResponseDTO = boardSelectUseCase.getBoardData(boardNo);
        return ResponseEntity.ok(boardResponseDTO);
    }

    @GetMapping("/getBoard")
    public ResponseEntity<List<BoardResponseDTO>> getAllBoardData() {
        List<BoardResponseDTO> boardResponseDTO = boardSelectUseCase.getAllBoardData();
        return ResponseEntity.ok(boardResponseDTO);
    }


}

