package com.example.hexagonaltest.board.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue
    private Long boardNo;
    private String title;
    private String content;
    private String writer;

}
