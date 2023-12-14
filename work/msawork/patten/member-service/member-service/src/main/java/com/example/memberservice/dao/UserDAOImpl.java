package com.example.memberservice.dao;

import com.example.memberservice.entity.MyUser;
import com.example.memberservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO{
    private final UserRepository repository;
    @Override
    public void updatePoint(String username,int point) {
        MyUser user = repository.findById(Long.parseLong(username)).get();
        user.setPoint(user.getPoint() + point);
        repository.save(user);
    }
}
