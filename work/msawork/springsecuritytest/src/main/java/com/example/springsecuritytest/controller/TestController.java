package com.example.springsecuritytest.controller;

import com.example.springsecuritytest.DAO.SampleDAOImpl;
import com.example.springsecuritytest.model.SampleEntity;
import com.example.springsecuritytest.model.UserInfo;
import com.example.springsecuritytest.model.SampleDTO1;
import com.example.springsecuritytest.model.SampleDTO2;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final PasswordEncoder passwordEncoder;
    private final SampleDAOImpl dao; // 테스트용이므로 실제 작업을 서비스 매핑

    AuthenticationFilter a;
    @GetMapping("/write")
    public String write() {
        // 테스트를 위해서 Entity를 생성해서 바로 작업
//        dao.write(new SampleEntity("playdata", passwordEncoder.encode("playdata"), "플레이데이터"));
        dao.write(new SampleEntity("jun", passwordEncoder.encode("jun"), "jun"));
        return "OK";
    }


    @RequestMapping("/")
    public String index() {
        return "스프링 시큐리티 테스트";
    }

    @RequestMapping("/showauth")
    public Authentication showauth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/userpage")
    public UserInfo userpage() {
        return UserInfo.builder()
                .authentication(SecurityContextHolder.getContext().getAuthentication())
                .msg("사용자가 막 접근할 수 있는 페이지")
                .build();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/adminpage")
    public UserInfo adminpage() {
        return UserInfo.builder()
                .authentication(SecurityContextHolder.getContext().getAuthentication())
                .msg("관리자가 막 접근할 수 있는 페이지")
                .build();
    }

    @GetMapping("/test")
    public String test() {
        SampleDTO1 dto = new SampleDTO1("jun",
                passwordEncoder.encode("1234"),
                "전병준"
                );
        System.out.println("------------------------------------");
        System.out.println("dto.toString() = " + dto.toString());
        ModelMapper mapper = new ModelMapper();
        SampleDTO2 dto2 = mapper.map(dto, SampleDTO2.class);
        System.out.println("dto2.toString() = " + dto2.toString());
        System.out.println("------------------------------------");
        return "ok";
    }





}
