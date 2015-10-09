package com.csb.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csb.common.constant.DevelopConstant;
import com.csb.common.constant.PlatformConstant;
import com.csb.core.mapper.UserMapper;
import com.csb.core.model.User;
import com.csb.core.model.UserRoles;

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
        Long userId = this.save(user);
        
        String userType = user.getUserType();
        List<UserRoles> userRolesList = null;
        UserRoles userRoles = null;
        if(userType.equals(PlatformConstant.USER_TYPE_PERSON))
        {
            //TODO default role should be configurable
            userRolesList = new ArrayList<UserRoles>();
            userRoles = new UserRoles();
            userRoles.setUserId(userId);
            userRoles.setRoleId(DevelopConstant.ROLE_PERSON_DEFAULT_1);
            userRolesList.add(userRoles);
            userRoles = new UserRoles();
            userRoles.setUserId(userId);
            userRoles.setRoleId(DevelopConstant.ROLE_PERSON_DEFAULT_2);
            userRolesList.add(userRoles);
            
        }else if(userType.equals(PlatformConstant.USER_TYPE_PROVIDER))
        {
          //TODO default role should be configurable
            userRolesList = new ArrayList<UserRoles>();
            userRoles = new UserRoles();
            userRoles.setUserId(userId);
            userRoles.setRoleId(DevelopConstant.ROLE_PROVIDER_DEFAULT_1);
            userRolesList.add(userRoles);
            userRoles = new UserRoles();
            userRoles.setUserId(userId);
            userRoles.setRoleId(DevelopConstant.ROLE_PROVIDER_DEFAULT_2);
            userRolesList.add(userRoles);
            
        }
        
        userRolesService.batchInsert(userRolesList);
        
    }
    
    /**
     * Active User to set Status Active
     * @param userId
     */
    @Transactional
    @Override
    public void active(User user)
    {
        user.setAccountStatus(PlatformConstant.ACCOUNT_STATUS_ACTIVE);
        this.update(user);
    }
    
    
}