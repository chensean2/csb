package com.csb.mall.auth.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Service;

import com.csb.core.model.Resource;
import com.csb.core.model.Role;
import com.csb.core.service.ResourceService;
import com.csb.core.service.RoleService;


@Service("customSecurityMetadataSource")
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    private static Map<RequestMatcher, Collection<ConfigAttribute>> resourceMap;
    @Autowired
    protected RoleService roleService;
    
    @Autowired
    protected ResourceService resourceService;
    
    @Value("${identity.role.prefix:ROLE_}")
    protected String rolePrefix;
    
    public CustomInvocationSecurityMetadataSourceService() {
    }

    @PostConstruct
    public void init() {
        loadResourceDefine();
    }
    
    public void loadResourceDefine() {
        resourceMap = new HashMap<RequestMatcher, Collection<ConfigAttribute>>();

        List<Role> roleList = roleService.findAll();
        Set<Resource> resourceList = null;
        for (Role role : roleList) {
            ConfigAttribute ca = new SecurityConfig(rolePrefix + role.getName());
            
            resourceList = resourceService.findByRoleId(role.getId());
            for (Resource res : resourceList) {
                String url = res.getUrl();
                RequestMatcher requestMatcher = new AntPathRequestMatcher(url);
                if (resourceMap.containsKey(requestMatcher)) {
                    Collection<ConfigAttribute> value = resourceMap.get(requestMatcher);
                    value.add(ca);
                    resourceMap.put(requestMatcher, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(requestMatcher, atts);
                }

            }

        }

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        if(resourceMap == null){
            return null;
        }
        Set allAttributes = new HashSet();

        for (Map.Entry entry : this.resourceMap.entrySet()) {
            allAttributes.addAll((Collection) entry.getValue());
        }

        return allAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        if(resourceMap == null || resourceMap.isEmpty()){
            //if the record haven't prepared, just load from DB directly. This case maybe occurred when clear Cache in Statistic Feature. 
            Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
            List<Role> roleList = roleService.findAll();
            Set<Resource> resourceList = null;
            for (Role role : roleList) {
                ConfigAttribute ca = new SecurityConfig(rolePrefix + role.getName());
                resourceList = resourceService.findByRoleId(role.getId());
                for (Resource res : resourceList) {
                    String url = res.getUrl();
                    RequestMatcher requestMatcher = new AntPathRequestMatcher(url);
                    if (requestMatcher.matches(request)) {
                        atts.add(ca);
                    }
                }
            }
            return atts;
        }else{
            for (Map.Entry entry : this.resourceMap.entrySet()) {
                if (((RequestMatcher) entry.getKey()).matches(request)) {
                    return ((Collection) entry.getValue());
                }
            } 
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
