package com.saas.provision.service;

import java.util.Map;

public interface AdaptorObjectService {
	public Map<String,Object> execute(Map<String,Object> paraMap,Map<String,Object> serviceMap);
	
}
