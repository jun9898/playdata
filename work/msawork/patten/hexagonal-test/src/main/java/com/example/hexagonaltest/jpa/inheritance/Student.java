package com.example.hexagonaltest.jpa.inheritance;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Student extends Person{
    private String studentId;

    public Student(Long id, String name, String addr, String password, String studentId) {
        super(id, name, addr, password);
        this.studentId = studentId;
    }
}
