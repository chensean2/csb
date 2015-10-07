package com.csb.mall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csb.common.constant.DevelopConstant;
import com.csb.common.constant.PlatformConstant;
import com.csb.core.model.User;
import com.csb.core.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginControl {
    private static Logger logger = LoggerFactory.getLogger(LoginControl.class);

//    @Autowired
//    private LoginService loginService;
//    
//    @RequestMapping(value = "/dologin", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<?> doLogin() {
//        //TODO remove later after 
//        User s = new User();
//        s.setEmail(DevelopConstant.USER_EMAIL);
//        s.setPassword(DevelopConstant.USER_PASSWORD);
//        s.setAccountstatus(PlatformConstant.ACCOUNT_STATUS_ACTIVE);
//        
//        List<User> userList = loginService.find(s);
//        return new ResponseEntity(userList.get(0),HttpStatus.CREATED);
//    }

}
