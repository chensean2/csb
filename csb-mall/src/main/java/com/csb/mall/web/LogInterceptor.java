package com.csb.mall.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.csb.core.annotation.WebComponent;
import com.csb.mall.auth.service.AuthenticatedUser;


@WebComponent
public class LogInterceptor extends HandlerInterceptorAdapter {

    public static final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = "anonymous";
        AuthenticatedUser user = UserContextHolder.getLoginUser();
        if ( user!= null) {
            userName = user.getUsername();
        }
        logger.info("[CSB] Start >> " + userName + " " + request.getMethod() + " " + request.getRequestURI());
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String userName = "anonymous";
        AuthenticatedUser user = UserContextHolder.getLoginUser();
        if ( user!= null) {
            userName = user.getUsername();
        }
        logger.info("[CSB] Ended >> " + userName  + " " + request.getMethod() + " " + request.getRequestURI());
    }
}
