package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformSaasProvisionResponseMapper;
import com.csb.core.model.PlatformSaasProvisionResponse;

@Service("platformSaasProvisionResponseService")
public class PlatformSaasProvisionResponseServiceImpl extends BaseServiceImpl<PlatformSaasProvisionResponse> implements PlatformSaasProvisionResponseService {
    
    public PlatformSaasProvisionResponseMapper getMapper() {
        return (PlatformSaasProvisionResponseMapper)mapper;
    }
    
    
}