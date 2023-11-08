package com.example.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customer")
// insert할때 null인 경우에 제외시키고 insert한다. @ColumnDefault("10000")를 사용하는 경우 컬럼값이 null이여서
// insert에 제외가 되어야 기본값이 적용
@DynamicInsert
public class CustomerEntity {
    @Id
    @GeneratedValue
    private Long customerGenerateId;
    @Column(name = "userId")
    private String username;
    @Column(name="pass", nullable = false, length = 100, unique = true)
    private String password;
    @Column(nullable = false, length = 50)
    private String name;
    private String addr;
    private String tel;
    @CreationTimestamp
    private Date writeDate;
    @UpdateTimestamp
    private Date modifyDate;
    @ColumnDefault("10000")
    private Integer point;
    private String info;
    // role 은 테이블로 분리하는게 사실상 맞다
    private String role;
    public CustomerEntity(String password, String name, String addr, String tel, String info) {
        this.password = password;
        this.name = name;
        this.addr = addr;
        this.tel = tel;
        this.info = info;
    }
}
