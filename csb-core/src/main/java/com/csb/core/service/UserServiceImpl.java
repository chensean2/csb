package com.csb.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.mapper.UserMapper;
import com.csb.core.model.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    
    @Autowired
    UserRolesService userRolesService;
    
    public UserMapper getMapper() {
        return (UserMapper)mapper;
    }
    
    @Transactional
    @Override
    public void register(User user)
    {
        //Save user with New status
        this.save(user);
        
        //TODO default role should be configurable
        String userType = user.getUserType();
        if(userType.equals(PlatformConstant.USER_TYPE_PERSON))
        {
            userRolesService.save()
        }else if(userType.equals(PlatformConstant.USER_TYPE_PROVIDER))
        {
            
        }
        
        
    }
    
    /**
     * Active User to set Status Active
     * @param userId
     */
    @Transactional
    @Override
    public void active(User user)
    {
        user.setAccountstatus(PlatformConstant.ACCOUNT_STATUS_ACTIVE);
        this.update(user);
    }
    
    
}