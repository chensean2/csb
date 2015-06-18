package com.csb.platform.provision.service;

import java.util.Map;


public interface SaaSProvisonService {

    public Map<String, String> createSubscripiton(String eventId);
    
    public Map<String, String> updateSubscripiton(String eventId);
    
    public Map<String, String> cancelSubscripiton(String eventId);
    
    public Map<String, String> notify(String eventId);
    
    public Map<String, String> assign(String eventId);
    
    public Map<String, String> unAssign(String eventId);
    
    public Map<String, String> validate(String eventId);
}
