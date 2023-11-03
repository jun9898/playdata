package com.example.jpaRestExam.product.model;

import com.example.jpaRestExam.customer.model.RequestCustomerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Builder
public class Customer {

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

    public Customer(String password, String name, String addr, String tel, int point, String info) {
        this.password = password;
        this.name = name;
        this.addr = addr;
        this.tel = tel;
        this.point = point;
        this.info = info;
    }

    public static Customer dtoToEntity(RequestCustomerDTO dto) {
        return Customer.builder()
                .password(dto.getPassword())
                .name(dto.getName())
                .addr(dto.getAddr())
                .tel(dto.getTel())
                .point(dto.getPoint())
                .info(dto.getInfo())
                .build();
    }
}
