package com.example.springsecuritytest.DAO;

import com.example.springsecuritytest.model.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {

    // 사용자가 입력한 아이디로 조회
    SampleEntity findByUsername(String username);
}
