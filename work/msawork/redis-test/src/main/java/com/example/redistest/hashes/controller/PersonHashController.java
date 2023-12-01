package com.example.redistest.hashes.controller;

import com.example.redistest.hashes.dto.Person;
import com.example.redistest.hashes.dto.Subject;
import com.example.redistest.hashes.service.PersonHashService;
import io.netty.handler.logging.LogLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonHashController {

    private final PersonHashService service;

    @PostMapping("/hashexam")
    public Person save(@RequestBody Person person) {
        return service.save(person);
    }

    @GetMapping("/hashexam")
    public Person findById(String id) {
        return service.findById(id);
    }

    @PutMapping("/hashexam")
    public String update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/hashexam")
    public String delete(@RequestBody Person person) {
        log.info("delete => {}", person.toString());
        return service.delete(person);
    }

    @GetMapping("/hashexamAll")
    public List<Person> All() {
        return service.findAll();
    }
}
