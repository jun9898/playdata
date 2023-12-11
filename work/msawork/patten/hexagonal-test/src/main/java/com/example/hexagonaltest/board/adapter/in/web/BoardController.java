package com.example.hexagonaltest.board.adapter.in.web;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardInputDTO;
import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import com.example.hexagonaltest.board.application.port.in.BoardCreateUseCase;
import com.example.hexagonaltest.board.application.port.in.BoardSelectUseCase;
import com.example.hexagonaltest.common.WebInAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 인바운드 어댑터

@WebInAdapter
@RestController
@RequiredArgsConstructor

@RequestMapping("/api")
public class BoardController {
    // 서비스 상위 정의하고 작업 - port in의 usecase
    private final BoardCreateUseCase boardCreateUseCase;
    private final BoardSelectUseCase boardSelectUseCase;
    @Operation(summary = "게시판 글 등록",description = "게시글내용입력 -> 게시글등록",tags = {"BoardController"})
    @PostMapping("/boardcreate")
    public ResponseEntity<String> createBoard(@RequestBody BoardInputDTO boardInputDTO){
        String result = boardCreateUseCase.createBoardData(boardInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "게시글 조회",description = "게시글번호(boardNo) -> 게시글상세조회",tags = {"BoardController"})
    @GetMapping("/boards/{id}")
    public ResponseEntity<BoardResponseDTO> selectBoard(
            @Parameter(name = "id", description = "게시글번호", example = "1", required = true)
            @PathVariable("id") Long id){
        // Spring Boot 3.2 버전 이후부터는 @PathVariable과 RequestParam은 변수명을 반드시 명시
        BoardResponseDTO board = boardSelectUseCase.selectBoard(id);
        return ResponseEntity.ok(board);
    }

    @GetMapping("/boards")
    public ResponseEntity<List<BoardResponseDTO>> selectAllBoard(){
        List<BoardResponseDTO> board = boardSelectUseCase.selectAllBoard();
        return ResponseEntity.ok(board);
    }
}
