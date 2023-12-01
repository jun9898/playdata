package com.example.redistest.hashes.repository;

import com.example.redistest.hashes.dto.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRedisRepository extends CrudRepository<Subject, String> {
}
