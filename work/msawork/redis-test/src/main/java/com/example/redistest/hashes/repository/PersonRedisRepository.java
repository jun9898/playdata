package com.example.redistest.hashes.repository;

import com.example.redistest.hashes.dto.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person, String> {
}
