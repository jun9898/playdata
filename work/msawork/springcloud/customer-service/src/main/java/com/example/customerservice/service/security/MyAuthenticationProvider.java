package com.example.customerservice.service.security;

import com.example.customerservice.model.CustomerResponseDTO;
import com.example.customerservice.model.CustomerUserDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String) authentication.getCredentials();
        log.info("===================================================================================================================");
        log.info("===========================================customProvider 작동중=====================================================");
        CustomerUserDetail customerUserDetail = (CustomerUserDetail) userDetailsService.loadUserByUsername(name);

        UsernamePasswordAuthenticationToken token = null;
        boolean state = false;

        if (customerUserDetail != null) {
            state = passwordEncoder.matches(password, customerUserDetail.getPassword());
            if (state) {
                token = new UsernamePasswordAuthenticationToken(customerUserDetail.getCustomerResponseDTO(), null, customerUserDetail.getAuthorities());
            }
        }
        return token;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
