package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "myhistory")
public class HistoryEntity { // myemp테이블과 연관관계가 있음
    @Id
    @GeneratedValue
    private Long historyId;
    private String company;
    private String content;

    @ManyToOne
    @JoinColumn(name = "id")
    private EmpEntity emp;


    public HistoryEntity(String company, String content) {
        this.company = company;
        this.content = content;
    }

    public HistoryEntity(String company, String content, EmpEntity emp) {
        this.company = company;
        this.content = content;
        this.emp = emp;
    }


}
