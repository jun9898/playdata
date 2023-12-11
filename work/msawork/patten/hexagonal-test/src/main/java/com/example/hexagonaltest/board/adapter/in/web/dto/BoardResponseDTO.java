package com.example.hexagonaltest.board.adapter.in.web.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDTO {
    private Long boardNo;
    private String title;
    private String content;
    private String writer;
}
