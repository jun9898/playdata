package com.example.hexagonaltest.jpa.inheritance;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Teacher extends Person{
    private String teacherId;
    private String subject;
}
