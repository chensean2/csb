package com.csb.core.service;

import com.csb.core.model.PlatformPlan;


public interface PlatformPlanService extends BaseService<PlatformPlan>{
    public PlatformPlan getPlanByEventId(String eventId);
}
