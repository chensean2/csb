package com.csb.platform.provision.iaas.service;

import java.util.Map;


public interface IaaSProvisionService {

    public Map<String, String> createServer(String eventId);
    
    public Map<String, String> cancelServer(String eventId);
    
    public Map<String, String> assign(String eventId);
    
    public Map<String, String> unAssign(String eventId);
    
    public Map<String, String> startServer(String serverId);
    
    public Map<String, String> stopServer(String serverId);
}
