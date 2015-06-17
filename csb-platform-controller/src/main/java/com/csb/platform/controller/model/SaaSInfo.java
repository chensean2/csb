package com.csb.platform.controller.model;


public class SaaSInfo {

	private SaaSExternalAccountInfo saaSExternalAccountInfo;
	
	//Available when is subscription case
	private SaaSPlanInfo saaSPlanInfo;
	
	//Available when is notification case
	private SaaSNotificationInfo saaSNotificationInfo;
	
	//Available when is assignment case
	private SaaSUserInfo saaSUserInfo;
}
