package com.example.hexagonaltest.board.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
}
