package com.example.springsecuritytest.service.security;

import com.example.springsecuritytest.model.SampleDTO2;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class MyAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    // 검증을 위한 구현작업을 해야한다.
    // 매개변수로 전달받은 Authentication은 Authenticationmanager에게 전달받는 값이다.
    // 즉, 검증을 받지 못한 사용자가 입력한 값

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 1. Authenticationmanager가 넘겨준 Authentication객체에서 사용자가 입력한 id와 password 추출
        String username = authentication.getName(); // username
        String password = (String) authentication.getCredentials();
        // 2. UserDetailService의 loadUserByUsername 메소드를 이용해서 사용자 정보를 조회
        CustomerUserDetail userDetail = (CustomerUserDetail) userDetailsService.loadUserByUsername(username);
        // 3. UserDetails에 담긴 패스워드와 사용자가 입력한 패스워드를 암호화해서 비교
        // ====> 만약에 인증을 위해서 체크해야 하는 것이 더 있으면 이 단계에서 체크
        UsernamePasswordAuthenticationToken token = null;
        boolean state = false;
        if (userDetail != null) {
            state = passwordEncoder.matches(password,userDetail.getPassword());
            if (state) { // 인증성공
                ModelMapper mapper = new ModelMapper();
                SampleDTO2 dto = mapper.map(userDetail.getEntity(), SampleDTO2.class);
                token = new UsernamePasswordAuthenticationToken(dto, null,userDetail.getAuthorities());
            }
        }
        // 4. 작업이 완료된 후 AuthenticationManager에 넘길 인증완료 토큰을 만들어서 정보를 저장
        // 사용자 정보를 담고 있는 DTO를 추출 - 엔티티를 DTO로 변환(Service에서 작업)

        // 권한
        return token;
    }

    // 폼로그인을 하는 경우 전달된 파라미터타입이 UsernamePasswordAuthenticationToken 타입과 일치하는 지 검사
    // 우리가 인증한 토큰객체가 인증전에 전달받은 Authentication과 타입이 일치하는지 비교
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
