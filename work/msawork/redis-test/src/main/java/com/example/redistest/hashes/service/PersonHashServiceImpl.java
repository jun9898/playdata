package com.example.redistest.hashes.service;

import com.example.redistest.hashes.dto.Person;
import com.example.redistest.hashes.dto.Subject;
import com.example.redistest.hashes.repository.PersonRedisRepository;
import io.netty.handler.logging.LogLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonHashServiceImpl implements PersonHashService{

    private final PersonRedisRepository repository;

    @Override
    public Person save(Person subject) {
        return repository.save(subject);
    }

    @Override
    public Person findById(String id) {
        return repository.findById(id).get();
    }

    @Override
    public String update(Person person) {
        Person from = repository.findById(person.getId())
                .get()
                .from(person);
        repository.save(from);
        return "ok";
    }

    @Override
    public String delete(Person person) {
        repository.delete(person);
        return "ok";
    }

    @Override
    public List<Person> findAll() {
        Iterable<Person> all = repository.findAll();
        List<Person> personList = new ArrayList<>();
        for (Person person : all) {
            personList.add(person);
        }
        return personList;
    }
}
