package com.example.springsecuritytest.service.security;

import com.example.springsecuritytest.DAO.SampleDAOImpl;
import com.example.springsecuritytest.model.SampleEntity;
import com.example.springsecuritytest.service.security.CustomerUserDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
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

//    ProviderManager a;

    private final SampleDAOImpl dao;
    // 기본적으로 AuthenticationProvider에 의해 호출되는 메소드로 유저아이디를 이용해서 DB에서 조회한 결과를 UserDetails타입으로 리턴
    // 조회한 Entity를 UserDetails로 변환해서 리턴
    // UserDetails - security프레임워크 내부에서 인식하는 인증값을 담고 있는 특별한 dto
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 사용자 아이디로 사용자 정보를 조회
        SampleEntity entity = dao.login(username);
        // 사용자가 없으면 Exception을 throw
        if ( entity == null ) {
            throw new UsernameNotFoundException("사용자가 없습니다");
        }
        // 2. loadUserByUsername 매소드는 조회한 사용자의 정보를 UserDetails의 하위로 만들어서 리턴
        // => 인증이 완료되면 Authentication객체 내부에 저장될 객체
        // => UserDetails가 갖고 있는 값들을 채워서 리턴
        // spring security 내부에서 인증된 객체는 권한이 중요
        // 인증객체에 자체적으로 권한 정보를 List형태로 갖고 있다.
        // 권한 정보를 모델링한 객체가 GrantedAuthority
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        CustomerUserDetail userDetail = new CustomerUserDetail(entity,roles);
        return userDetail;
    }
}
