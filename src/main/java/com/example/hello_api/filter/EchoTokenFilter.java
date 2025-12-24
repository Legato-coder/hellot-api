package com.example.hello_api.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class EchoTokenFilter extends OncePerRequestFilter {

    public static final String ECHO_TOKEN = "ECHO_TOKEN";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String echoToken = UUID.randomUUID().toString();

        // store token for this request lifecycle
        request.setAttribute(ECHO_TOKEN, echoToken);

        filterChain.doFilter(request, response);
    }
}
