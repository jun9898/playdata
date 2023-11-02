package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;

import java.util.Date;

// 다대다 관계에서 중간역할을 하는 엔티티
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentSubject {

    @Id @GeneratedValue
    private Long id;

    // 수강신청한 학생의 정보 - 과목을 신청하는 학생이 여러 명
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    // 과목의 정보
    @ManyToOne
    @JoinColumn(name = "sub_id")
    private SubjectEntity subject;

    @CreationTimestamp
    private Date orderDateTime;

    private int price;

    public StudentSubject(StudentEntity student, SubjectEntity subject, int price) {
        this.student = student;
        this.subject = subject;
        this.price = price;
    }
}
