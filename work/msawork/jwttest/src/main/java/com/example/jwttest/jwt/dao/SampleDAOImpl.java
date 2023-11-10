package com.example.jwttest.jwt.dao;

import com.example.jwttest.jwt.model.SampleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SampleDAOImpl {
    private final SampleRepository sampleRepository;
    public void write(SampleEntity entity){
        sampleRepository.save(entity);
    }

    public SampleEntity login(String username){
        return sampleRepository.findByUsername(username);
    }
}
