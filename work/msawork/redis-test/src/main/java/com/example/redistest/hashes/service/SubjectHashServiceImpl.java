package com.example.redistest.hashes.service;

import com.example.redistest.hashes.dto.Subject;
import com.example.redistest.hashes.repository.SubjectRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectHashServiceImpl implements SubjectHashService{
    private  final SubjectRedisRepository repository;
    @Override
    public Subject save(Subject subject) {
        return repository.save(subject);
    }

    @Override
    public Subject findById(String id) {
        return repository.findById(id).get();
    }
}
