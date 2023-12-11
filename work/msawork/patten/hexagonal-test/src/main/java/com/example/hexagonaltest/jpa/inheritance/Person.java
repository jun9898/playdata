package com.example.hexagonaltest.jpa.inheritance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Table(name = "person")

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String addr;
    private String password;
}
