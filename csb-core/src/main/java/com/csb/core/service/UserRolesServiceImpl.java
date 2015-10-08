package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.UserRolesMapper;
import com.csb.core.model.UserRoles;

@Service("userRolesService")
public class UserRolesServiceImpl extends BaseServiceImpl<UserRoles> implements UserRolesService{
    
    public UserRolesMapper getMapper() {
        return (UserRolesMapper)mapper;
    }
}
