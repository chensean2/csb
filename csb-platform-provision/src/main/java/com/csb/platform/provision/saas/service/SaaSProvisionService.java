package com.csb.platform.provision.saas.service;

import java.util.Map;

import com.csb.core.model.PlatformPlan;


public interface SaaSProvisionService {

    public Map<String, String> createSubscripiton(PlatformPlan plan);
    
    public Map<String, String> updateSubscripiton(String eventId);
    
    public Map<String, String> cancelSubscripiton(String eventId);
    
    public Map<String, String> notify(String eventId);
    
    public Map<String, String> assign(String eventId);
    
    public Map<String, String> unAssign(String eventId);
    
    public Map<String, String> validate(String eventId);
}
