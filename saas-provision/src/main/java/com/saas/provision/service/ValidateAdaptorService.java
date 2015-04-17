package com.saas.provision.service;

import java.util.Map;

public interface ValidateAdaptorService {
	public String[] execute(Map<String,String> sysParamMap,String[] paramArray);
	public String getReferenceId(Map<String,String> sysParamMap, String[] paramArray);
}
