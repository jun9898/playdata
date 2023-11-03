package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
    private List<HistoryEntity> historyList = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id") // EmpEntity의 user_id와 join
    private PrivateInfoEmpEntity infoEmpEntity;

    public EmpEntity(String name, String addr, DeptEntity dept) {
        this.name = name;
        this.addr = addr;
        this.dept = dept;
    }

    public EmpEntity(String name, String addr, DeptEntity dept, List<HistoryEntity> historyList) {
        this.name = name;
        this.addr = addr;
        this.dept = dept;
        this.historyList = historyList;
    }

    // 연관관계가 있는 엔티티를 수정
    public void changeHistoryList(HistoryEntity history){
        historyList.add(history);
        history.setEmp(this);
    }

    public static EmpEntity buildEmpEntity(String name, String addr, DeptEntity dept, List<HistoryEntity> list) {
        EmpEntity entity = new EmpEntity(name, addr, dept);
        for (HistoryEntity historyEntity : list) {
            // EmpEntity 객체를 먼저 초기화한 후 changeHistoryList 메서드 호출
            entity.changeHistoryList(historyEntity);
        }
        return entity;
    }
}
