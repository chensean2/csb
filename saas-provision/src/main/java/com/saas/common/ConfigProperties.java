package com.saas.common;

public class ConfigProperties {

	public static ConfigProperties getInstance(){
		return new ConfigProperties();
	}
	
	public String getPropertyAsString(String file, String key, String defaultValue){
		return "";
	}
	
	public int getPropertyAsInt(String file, String key, int defaultValue){
		return 0;
	}
}

