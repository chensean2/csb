package com.csb.parser.component.model;

public class SaaSInfo {

	// CREATE,UPDATE,CANCEL,NOTICE
	private String action;

	private SaaSExternalAccountInfo saaSExternalAccountInfo;

	// Available when is subscription case
	private SaaSPlanInfo saaSPlanInfo;

	// Available when is notification case
	private SaaSNotificationInfo saaSNotificationInfo;

	// Available when is assignment case
	private SaaSUserInfo saaSUserInfo;

	// Available when is subscription case and assignment case
	private CreatorInfo creatorInfo;
}
