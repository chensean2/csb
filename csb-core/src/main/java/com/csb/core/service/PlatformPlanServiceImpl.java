package com.csb.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csb.core.mapper.PlatformPlanMapper;
import com.csb.core.model.PlatformPlan;

@Service("platformPlanService")
public class PlatformPlanServiceImpl extends BaseServiceImpl<PlatformPlan> implements PlatformPlanService {
    
    public PlatformPlanMapper getMapper() {
        return (PlatformPlanMapper)mapper;
    }
    
    public PlatformPlan getPlanByEventId(String eventId){
        PlatformPlan paramPlatformPlan = new PlatformPlan();
        paramPlatformPlan.setEventId(eventId);
        List<PlatformPlan> planList = mapper.select(paramPlatformPlan);
        if(planList != null && planList.size() == 1){
            return planList.get(0);
        }else{
            return null;
        }
        
    }
    
    
}