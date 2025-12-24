package com.example.hello_api.util;

import jakarta.servlet.http.HttpServletRequest;

import static com.example.hello_api.filter.EchoTokenFilter.ECHO_TOKEN;

public class EchoTokenUtil {

    public static String getEchoToken(HttpServletRequest request) {
        return (String) request.getAttribute(ECHO_TOKEN);
    }
}
