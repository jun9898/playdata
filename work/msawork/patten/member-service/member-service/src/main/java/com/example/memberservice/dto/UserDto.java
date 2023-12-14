package com.example.memberservice.dto;


import com.example.memberservice.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
//엔티티 대신 각 레이어로 전달될 데이터클래스
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String name;
    private String password;
    private String nickname;
    private boolean checkVal;
    private Set<Authority> authoritylist;

}
