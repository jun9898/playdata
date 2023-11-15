package com.example.jwttest;

import com.example.jwttest.jwt.dao.SampleDAOImpl;
import com.example.jwttest.jwt.model.SampleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class JwttestApplicationTests {

    @Autowired
    SampleDAOImpl sampleDAO;

    @Test
    @Rollback(value = false)
    void contextLoads() {
        SampleEntity member = new SampleEntity();
        member.setPass("jun");
        member.setName("jun");
        member.setUsername("전병준");
        sampleDAO.write(member);

    }

}
