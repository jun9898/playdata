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
@Table(name = "student1")
public class Student1 {
    @Id
    @GeneratedValue
    private Long stdId;
    private String name;
    private String addr;
    @ManyToMany(mappedBy = "student1List")
    private List<Subject1> subject1List = new ArrayList<>();
}
