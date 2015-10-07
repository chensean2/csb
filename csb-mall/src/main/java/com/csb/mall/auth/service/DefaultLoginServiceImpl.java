package com.csb.mall.auth.service;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csb.common.constant.PlatformConstant;
import com.csb.core.model.Permission;
import com.csb.core.model.Role;
import com.csb.core.model.User;
import com.csb.core.service.PermissionService;
import com.csb.core.service.RoleService;
import com.csb.core.service.UserService;

@Service("loginService")
public class DefaultLoginServiceImpl implements LoginService{
    
    @Autowired
    protected UserService userService;
    
    @Autowired
    protected RoleService roleService;
    
    @Autowired
    protected PermissionService permissionService;

    @Value("${identity.role.prefix:ROLE_}")
    protected String rolePrefix;

    @Value("${identity.permission.prefix:PERM_}")
    protected String permissionPrefix;

    @Value("${identity.group.prefix:GROUP_}")
    protected String groupPrefix;
    
    


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username){
        User user = new User();
        user.setEmail(username);
        user = userService.findByUniqueKey(user);
        if (user == null) {
            throw new UsernameNotFoundException("notFound");
        }
        if(user.getAccountstatus().equalsIgnoreCase(PlatformConstant.ACCOUNT_STATUS_NEW)){
                throw new DisabledException("new");
        }
        if(user.getAccountstatus().equalsIgnoreCase(PlatformConstant.ACCOUNT_STATUS_LOCKED)){
                throw new LockedException("locked");
        }
        //TODO other login errors
        
        
        AuthenticatedUser au = new AuthenticatedUser(user, getAuthorities(user));
        return au;
    }


    protected Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        
        processRoles(roleService.findByUserId(user.getId()), authorities);
//        for (Group group : user.getGroups()) {
//            authorities.add(new SimpleGrantedAuthority(groupPrefix + group.getName().toUpperCase()));
//            processRoles(group.getRoles(), authorities);
//            processPermissions(group.getPermissions(), authorities);
//        }
        return authorities;
    }


    protected void processRoles(Set<Role> roles, Set<GrantedAuthority> authorities) {
        if (roles != null && !roles.isEmpty()) {
            for (Role role : roles) {
                authorities.add(new SimpleGrantedAuthority(rolePrefix + role.getName()));
                processPermissions(permissionService.findByRoleId(role.getId()), authorities);
            }
        }
    }


    protected void processPermissions(Set<Permission> permissions, Set<GrantedAuthority> authorities) {
        if (permissions != null && !permissions.isEmpty()) {
            for (Permission permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permissionPrefix + permission.getName()));
            }
        }
    }


    @Override
    public Long updateLoginInfo(String id, String remoteAddress) {
        User user = userService.get(Long.parseLong(id));
        //force load tenant
//        user.setLastLoginIp(remoteAddress);
//        user.setLastLoginDate(new Date());
        return userService.save(user);
    }

}
