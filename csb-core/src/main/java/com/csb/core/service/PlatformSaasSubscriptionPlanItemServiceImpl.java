package com.csb.core.service;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformSaasSubscriptionPlanItemMapper;
import com.csb.core.model.PlatformSaasSubscriptionPlanItem;

@Service("platformSaasSubscriptionPlanItemService")
public class PlatformSaasSubscriptionPlanItemServiceImpl extends BaseServiceImpl<PlatformSaasSubscriptionPlanItem> implements PlatformSaasSubscriptionPlanItemService {
    
    public PlatformSaasSubscriptionPlanItemMapper getMapper() {
        return (PlatformSaasSubscriptionPlanItemMapper)mapper;
    }
    
    
}