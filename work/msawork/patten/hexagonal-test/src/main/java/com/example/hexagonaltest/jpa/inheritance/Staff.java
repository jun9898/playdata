package com.example.hexagonaltest.jpa.inheritance;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Staff extends Person{
    private String staffId;
    private String dept;
}
