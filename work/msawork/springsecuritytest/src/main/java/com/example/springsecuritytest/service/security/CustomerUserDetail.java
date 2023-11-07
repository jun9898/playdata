package com.example.springsecuritytest.service.security;

import com.example.springsecuritytest.model.SampleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

// UserDetails의 하위 객체인 User로 만들어서 리턴
public class CustomerUserDetail extends User {
    private final SampleEntity entity;

    public CustomerUserDetail(SampleEntity entity,
                              Collection<? extends GrantedAuthority> authorities) {
        super(entity.getUsername(), entity.getPass(), authorities);
        this.entity = entity;
    }
    public SampleEntity getEntity() {
        return entity;
    }
}
