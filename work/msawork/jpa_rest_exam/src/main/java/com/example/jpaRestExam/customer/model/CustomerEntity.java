package com.example.jpaRestExam.customer.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Builder
public class CustomerEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "pass")
    private String password;
    private String name;
    private String addr;
    private String tel;
    @CreationTimestamp
    private Date createDate;
    @UpdateTimestamp
    private Date modifyDate;
    private int point;
    private String info;

    public CustomerEntity(String password, String name, String addr, String tel, int point, String info) {
        this.password = password;
        this.name = name;
        this.addr = addr;
        this.tel = tel;
        this.point = point;
        this.info = info;
    }

    public static CustomerEntity dtoToEntity(RequestCustomerDTO dto) {
        return CustomerEntity.builder()
                .password(dto.getPassword())
                .name(dto.getName())
                .addr(dto.getAddr())
                .tel(dto.getTel())
                .point(dto.getPoint())
                .info(dto.getInfo())
                .build();
    }
}
