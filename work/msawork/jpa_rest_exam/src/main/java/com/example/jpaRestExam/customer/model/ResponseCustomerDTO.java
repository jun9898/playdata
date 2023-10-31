package com.example.jpaRestExam.customer.model;

import com.example.jpaRestExam.customer.service.CustomerService;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseCustomerDTO {

    private Long id;
    @Column(name = "pass")
    private String password;
    private String name;
    private String addr;
    private String tel;
    private Date createDate;
    private Date modifyDate;
    private int point;
    private String info;

    public static ResponseCustomerDTO from(CustomerEntity entity) {
        return ResponseCustomerDTO.builder()
                .id(entity.getId())
                .password(entity.getPassword())
                .name(entity.getName())
                .addr(entity.getAddr())
                .tel(entity.getTel())
                .createDate(entity.getCreateDate())
                .modifyDate(entity.getModifyDate())
                .point(entity.getPoint())
                .info(entity.getInfo())
                .build();
    }

}
