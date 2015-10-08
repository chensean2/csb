package com.csb.platform.provision.iaas.service;

import java.util.Map;

import com.csb.core.model.PlatformIaasPlan;
import com.csb.core.model.PlatformPlan;


public interface IaaSProvisionService {

    public Map<String, String> createServer(PlatformIaasPlan iaasPlan);
    
    public Map<String, String> cancelServer(String eventId);
    
    public Map<String, String> assign(String eventId);
    
    public Map<String, String> unAssign(String eventId);
    
    public Map<String, String> startServer(String serverId);
    
    public Map<String, String> stopServer(String serverId);
}
