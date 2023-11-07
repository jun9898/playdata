package com.example.customerservice.service.security;

import com.example.customerservice.model.CustomerEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomerUserDetail extends User {
    private final CustomerEntity entity;

    public CustomerUserDetail(Collection<? extends GrantedAuthority> authorities, CustomerEntity entity) {
        super(entity.getUsername(), entity.getPassword(), authorities);
        this.entity = entity;
    }

    public CustomerEntity getEntity() {
        return entity;
    }
}
