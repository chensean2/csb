package com.csb.mall.auth.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.csb.core.model.User;


/**
 * @author 
 * @since 03/02/2013 8:16 PM
 */
public interface LoginService extends UserDetailsService {

    @Transactional
    Long updateLoginInfo(String id, String remoteAddress);


}
