package com.example.hexagonaltest.Cart.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//비지니스 로직 내부에서 접근해서 처리할 데이터를 담은 클래스로 오염이 되면 안되는 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long cartNo;
    private String title;
    private String content;
    private String writer;
}
