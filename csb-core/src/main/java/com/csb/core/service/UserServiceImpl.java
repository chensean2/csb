package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.UserMapper;
import com.csb.core.model.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    
    public UserMapper getMapper() {
        return (UserMapper)mapper;
    }
    
    
}