package com.csb.mall.auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.csb.core.entity.User;

/**
 * @author 
 * @since 03/02/2013 8:16 PM
 */
public interface UserService extends UserDetailsService {

    @Transactional
    User updateLoginInfo(String id, String remoteAddress);


}
