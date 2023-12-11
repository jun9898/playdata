package com.example.hexagonaltest.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// 비즈니스 로직 내부에서 접근해서 처리할 데이터를 담은 클래스로 오염이 되면 안됨
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Long boardNo;
    private String title;
    private String content;
    private String writer;
}
