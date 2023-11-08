package com.example.customerservice.service.security;

import com.example.customerservice.dao.CustomerDAO;
import com.example.customerservice.model.CustomerEntity;
import com.example.customerservice.model.CustomerResponseDTO;
import com.example.customerservice.model.CustomerUserDetail;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 인메모리 방식에서 인증하던 작업을 DB기반으로 변경하기 위해서 커스트마이징
@Service
@RequiredArgsConstructor
public class CustomerSecurityDetailService implements UserDetailsService {

    // 아이디 정보로 유저를 조회하기
    private final CustomerDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerEntity entity = dao.login(username);

        if (entity == null) {
            throw new UsernameNotFoundException("사용자가 없습니다");
        }

//         기존에 사용하던 팩토리 메소드 패턴
//        CustomerResponseDTO customerResponseDTO = CustomerResponseDTO.entityToDto(entity);
//        외부 라이브러러인 ModelMapper
        ModelMapper mapper = new ModelMapper();
        CustomerResponseDTO responseDTO = mapper.map(entity, CustomerResponseDTO.class);

//        권한 정보와 조회한 사용자 객체를 이요여해서 UserDetails 객체를 생성해서 리턴
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(entity.getRole()));
//        스프링시큐리티 내부에서 인증처리를 할 수 있도록 하기 위해서 요구되는 DTO타입으로 한번 더 감싸준다
        CustomerUserDetail customerUserDetail = new CustomerUserDetail(roles, responseDTO);
        return customerUserDetail;
    }
}
