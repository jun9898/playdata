package com.example.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomerResponseDTO {
    private Long customerGenerateId;
    private String username;
    private String password;
    private String name;
    private String addr;
    private String tel;
    private Date writeDate;
    private Date modifyDate;
    private int point;
    private String info;
    private String role;

  
    public static  CustomerResponseDTO entityToDto(CustomerEntity entity){
        return CustomerResponseDTO.builder()
                .customerGenerateId(entity.getCustomerGenerateId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .name(entity.getName())
                .addr(entity.getAddr())
                .tel(entity.getTel())
                .writeDate(entity.getWriteDate())
                .modifyDate(entity.getModifyDate())
                .point(entity.getPoint()).build();
    }
}
