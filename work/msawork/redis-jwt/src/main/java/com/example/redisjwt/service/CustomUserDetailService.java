package com.example.redisjwt.service;

import com.example.redisjwt.entity.MyUser;
import com.example.redisjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

// 스프링 시큐리티의 인증 안에서 자동으로 호출되는 메소드가 정의된 객체
// 꼭 정해진 형식에 맞게 만들어야 한다.

@Service("userDetailService")
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Long userId = Long.parseLong(id);
        // findById 실행 후 리턴받은 MyUser 객체를 스프링 내부에서 인식하는 User로 변환 후 리턴
        return repository.findById(userId)
                .map(userObj -> createUser(userId, userObj))
                .orElseThrow(() ->
                    new UsernameNotFoundException(userId+ "사용자가 데이터베이스에 없습니다.")
                );
    }

    // 인증 성공 후 Authentication 객체에 저장할 User객체가 필요 - User객체를 만들어서 리턴
    // loadUserByUsername메소드의 리턴 결과로 호출
    // 지금은 메소드 내부에서만 사용되므로
    private User createUser(Long id, MyUser user) {
        // 권한
        List<GrantedAuthority> authorityList =
                user.getAuthorityList()
                        .stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                        .collect(Collectors.toList());

        return new User(user.getUserId()+"", user.getPassword(), authorityList);
    }
}
