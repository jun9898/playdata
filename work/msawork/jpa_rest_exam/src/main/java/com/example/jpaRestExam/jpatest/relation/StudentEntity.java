package com.example.jpaRestExam.jpatest.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue
    private Long studentId;
    private String name;
    private String addr;

    @ToString.Exclude
    @OneToMany(mappedBy = "student")
    private List<StudentSubject> studentSubjectList = new ArrayList<>();

    public StudentEntity(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }
}
