package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "userInfo")
public class PrivateInfoEmpEntity {

    @Id
    @GeneratedValue
    private Long userId;
    private String info1;
    private String info2;
    @OneToOne(mappedBy = "infoEmpEntity")
    private EmpEntity emp;
}
