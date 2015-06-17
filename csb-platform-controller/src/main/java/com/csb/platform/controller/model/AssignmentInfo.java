package com.csb.platform.controller.model;

public class AssignmentInfo {

	/**
	 * IAAS,PAAS,SAAS
	 */
	private String type;
	
	/**
	 * ASSIGN,UNASSIGN
	 */
	private String action;
		
	private IaaSInfo iaasInfo;
	
	private PaaSInfo paasInfo;
	
	private SaaSInfo saasInfo;
}
