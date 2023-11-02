package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject1")
public class Subject1 {

    @Id
    @GeneratedValue
    private Long subId;
    private String subject;
    private String info;

    // 과목을 수강신청한 학생들의 정보
    @ManyToMany
    @JoinTable(name = "student_subject_info")
    private List<Student1> student1List = new ArrayList<>();
}
