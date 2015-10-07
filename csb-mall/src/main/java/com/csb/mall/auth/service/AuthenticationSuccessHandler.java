package com.csb.mall.auth.service;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author 
 * @since 03/02/2013 5:38 PM
 */
@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    
    @Autowired
    protected LoginService loginService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        if (authentication.getPrincipal() instanceof AuthenticatedUser) {
            updateLoginInfo(request, (AuthenticatedUser) authentication.getPrincipal());
        }
        
        super.onAuthenticationSuccess(request, response, authentication);
    }


    protected void updateLoginInfo(HttpServletRequest request, AuthenticatedUser authUser) {
        //Tenant defaultTenant = tenantRepository.findOne(authUser.getUser().getTenantId());
     
        //request.getSession().setAttribute(Constants.TENANT, defaultTenant);
        
//        loginService.updateLoginInfo(id, remoteAddress)
    }


}
