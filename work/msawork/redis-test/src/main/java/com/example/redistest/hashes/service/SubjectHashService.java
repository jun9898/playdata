package com.example.redistest.hashes.service;

import com.example.redistest.hashes.dto.Subject;

public interface SubjectHashService {
    Subject save(Subject subject);

    Subject findById(String id);
}
