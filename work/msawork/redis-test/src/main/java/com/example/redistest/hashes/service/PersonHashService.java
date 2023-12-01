package com.example.redistest.hashes.service;

import com.example.redistest.hashes.dto.Person;
import com.example.redistest.hashes.dto.Subject;

import java.util.List;

public interface PersonHashService {

    Person save(Person person);

    Person findById(String id);

    String update(Person person);

    String delete(Person person);

    List<Person> findAll();
}
