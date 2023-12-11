package com.example.hexagonaltest.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

// 시리얼라이저블을 implement 하면 MyNotiData가 네트워크를 통해서 전송될수 있는 타입
public class MyNotiData implements Serializable {
    private Long id;
    private String msg;
}
