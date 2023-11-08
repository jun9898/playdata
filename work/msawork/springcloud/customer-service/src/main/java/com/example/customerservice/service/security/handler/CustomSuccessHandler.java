package com.example.customerservice.service.security.handler;

import com.example.customerservice.model.CustomerResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // 인증이 성공하면 토큰에서 공유되나 객체를 꺼내서 세션에 저장하
        CustomerResponseDTO principal = (CustomerResponseDTO) authentication.getPrincipal();
        request.getSession().setAttribute("user", principal);

        SavedRequest saveRequest = requestCache.getRequest(request, response);
        // 인증후에 사용자가 인증전에 방문한 사이트로 바로 이동하거나 첫 페이지로 이동
        if (saveRequest != null) {
            String url = saveRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, url);
        } else {
            redirectStrategy.sendRedirect(request, response, "/");
        }

        response.sendRedirect("/");
        log.info(authentication.getPrincipal().toString());
        log.info("==============================로그인 성공 필터=================================");
    }
}
