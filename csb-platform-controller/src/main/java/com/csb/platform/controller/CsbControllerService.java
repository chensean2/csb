package com.csb.platform.controller;

import java.util.Map;

public interface CsbControllerService {

    public String sendRequest(String requestId);
    
    public Map<String, Object> validateParameter(Map<String, Object> parameterMap);
}
