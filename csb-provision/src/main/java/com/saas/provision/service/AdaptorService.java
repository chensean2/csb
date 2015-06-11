package com.saas.provision.service;

import java.util.Map;

public interface AdaptorService {
	public Map<String,Object> execute(Map<String,String> paraMap,Map<String,String> serviceMap);
	
}
