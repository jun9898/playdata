package com.example.customerservice.model;

import com.example.customerservice.model.CustomerEntity;
import com.example.customerservice.model.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

// UserDetails의 구현체읜 User를 상속
// 스프링 시큐리티의 인증처리 과정에서 요구되는 객체
// 디비에서 조회한 객체를 user타입으로 변환하기 위해 커스트마이징
// UserDetailService에서 리턴할 타입으로 AuthenticationProvider로 리턴
public class CustomerUserDetail extends User {
    private final CustomerResponseDTO customerResponseDTO;

    public CustomerUserDetail(Collection<? extends GrantedAuthority> authorities, CustomerResponseDTO customerResponseDTO) {
        super(customerResponseDTO.getUsername(), customerResponseDTO.getPassword(), authorities);
        this.customerResponseDTO = customerResponseDTO;
    }

    public CustomerResponseDTO getCustomerResponseDTO() {
        return customerResponseDTO;
    }
}
