package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "myemp")
public class EmpEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String addr;
    // 작업중인 테이블 기준으로 관계를 명시
    // 다대일 관계
    // 조인할 컬럼을 명시 - 조인할 테이블의 pk명을 명시
    @ManyToOne
    @JoinColumn(name = "dept_no")
    private DeptEntity dept;

    public EmpEntity(String name, String addr, DeptEntity dept) {
        this.name = name;
        this.addr = addr;
        this.dept = dept;
    }
}
