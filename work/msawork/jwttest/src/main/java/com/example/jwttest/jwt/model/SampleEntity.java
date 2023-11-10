package com.example.jwttest.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sample")
public class SampleEntity {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private String pass;
    private String name;

    public SampleEntity(String username, String pass, String name) {
        this.username = username;
        this.pass = pass;
        this.name = name;
    }
}
