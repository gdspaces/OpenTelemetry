package com.example.delivery.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

@Slf4j
@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UUID requestId = UUID.randomUUID();
        request.setAttribute("start",System.currentTimeMillis());
        request.setAttribute("request-id",requestId);
        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
        if (ipAddress == null) {  
            ipAddress = request.getRemoteAddr();  
        }
        log.info("Request ID {} - URI {} - Method {} - IpAddress {}" ,requestId,request.getRequestURI(),request.getMethod(),ipAddress);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("{} - response in {} ms" , request.getAttribute("request-id"),System.currentTimeMillis() - (long) request.getAttribute("start"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("{} - completed in {} ms" , request.getAttribute("request-id"),System.currentTimeMillis() - (long) request.getAttribute("start"));

    }
}