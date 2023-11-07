package com.example.customerservice.service.security;

import com.example.customerservice.dao.CustomerDAO;
import com.example.customerservice.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerSecurityDetailService implements UserDetailsService {

    private final CustomerDAO dao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity entity = dao.login(username);
        if (entity == null) {
            throw new UsernameNotFoundException("사용자가 없습니다");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(entity.getRole()));
        CustomerUserDetail customerUserDetail = new CustomerUserDetail(roles, entity);
        return customerUserDetail;
    }
}
