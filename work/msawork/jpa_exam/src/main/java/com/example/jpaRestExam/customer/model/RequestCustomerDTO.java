package com.example.jpaRestExam.customer.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestCustomerDTO {

    @Column(name = "pass")
    private String password;
    private String name;
    private String addr;
    private String tel;
    private int point;
    private String info;
}
