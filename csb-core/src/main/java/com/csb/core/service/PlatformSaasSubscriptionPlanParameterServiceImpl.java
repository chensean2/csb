package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformSaasSubscriptionPlanParameterMapper;
import com.csb.core.model.PlatformSaasSubscriptionPlanParameter;

@Service("platformSaasSubscriptionPlanParameter")
public class PlatformSaasSubscriptionPlanParameterServiceImpl extends BaseServiceImpl<PlatformSaasSubscriptionPlanParameter> implements PlatformSaasSubscriptionPlanParameterService {
    
    public PlatformSaasSubscriptionPlanParameterMapper getMapper() {
        return (PlatformSaasSubscriptionPlanParameterMapper)mapper;
    }
    
    
}