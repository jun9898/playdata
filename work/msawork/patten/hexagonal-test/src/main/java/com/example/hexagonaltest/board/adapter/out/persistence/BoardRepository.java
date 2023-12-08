package com.example.hexagonaltest.board.adapter.out.persistence;

import com.example.hexagonaltest.board.adapter.in.web.dto.BoardResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    BoardEntity findByBoardNo(Long boardNo);
}
