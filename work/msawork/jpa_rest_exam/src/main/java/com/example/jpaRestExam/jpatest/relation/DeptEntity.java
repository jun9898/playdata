package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// 양방향으로 매핑
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "mydept")
public class DeptEntity {
    @Id
    @GeneratedValue
    private Long deptNo;
    private String name;
    private String mgr;
    // 부서안에 근무하는 emp의 리스트를 가져와야 한다
    // OneToMany에서는 대상테이블의 어떤 컬럼과 매핑이 되어있는지 기준컬럼을 명시
    // 양방향관계에서는 항상 기준이 되는 엔티티의 컬럼명
    @ToString.Exclude
    @OneToMany(mappedBy = "dept")
    private List<EmpEntity> emplist = new ArrayList<>();

    public DeptEntity(String name, String mgr) {
        this.name = name;
        this.mgr = mgr;
    }
}
