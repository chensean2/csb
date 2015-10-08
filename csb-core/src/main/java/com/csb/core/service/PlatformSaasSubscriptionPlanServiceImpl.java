package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformSaasSubscriptionPlanMapper;
import com.csb.core.model.PlatformSaasSubscriptionPlan;

@Service("platformSaasSubscriptionPlanService")
public class PlatformSaasSubscriptionPlanServiceImpl extends BaseServiceImpl<PlatformSaasSubscriptionPlan> implements PlatformSaasSubscriptionPlanService {
    
    public PlatformSaasSubscriptionPlanMapper getMapper() {
        return (PlatformSaasSubscriptionPlanMapper)mapper;
    }
    
    
}