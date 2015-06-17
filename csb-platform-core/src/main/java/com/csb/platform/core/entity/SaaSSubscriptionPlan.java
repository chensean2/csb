package com.csb.platform.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_csb_platform_saas_subscription_plan")
public class SaaSSubscriptionPlan extends BaseEntity<Long> {

	@Column(name = "TRACE_ID")
	private String traceId;

	@Column(name = "APP_PROVIDER_ID")
	private String appProviderId;

	// for the provider query subscription information
	@Column(name = "UNIQUE_ID")
	private String uniqueId;

	// CREATE,UPDATE,CANCEL,NOTICE
	@Column(name = "ACTION")
	private String action;
	
	@Column(name = "PLAN_CODE")
	private String planCode;

	@Column(name = "COMPANY_UUID")
	private String companyUUID;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "COMPANY_PHONENUMBER")
	private String companyPhoneNumber;

	@Column(name = "CREATOR_OPENID")
	private String creatorOpenId;

	@Column(name = "CREATOR_EMAIL")
	private String creatorEmail;

	@Column(name = "CREATOR_FIRSTNAME")
	private String creatorFirstName;
	
	@Column(name = "CREATOR_LASTNAME")
	private String creatorLastName;
	
	@Column(name = "EXTERNAL_ACCOUT_ID")
	private String externalAccoutId;
	
	//this is for notification case, which is current status of the subscription 
	//FREE_TRIAL,FREE_TRIAL_EXPIRED,ACTIVE,SUSPENDED,CANCELLED
	@Column(name = "PREVIOUS_SUBSCRIPTION_STATUS")
	private String previousSubscriptionStatus;
	
	@Column(name = "NOTIFICATION_TYPE")
	private String notificationType;
	
	//status of the provision, INPROGRESS,SUCCESS,FAILED
	@Column(name = "STATUS")
	private String status;
	
	@OneToMany(mappedBy = "saaSSubscriptionPlan")
	private List<SaaSSubscriptionPlanItem>  saaSSubscriptionPlanItemList;
	
	@OneToMany(mappedBy = "saaSSubscriptionPlan")
	private List<SaaSSubscriptionPlanParameter>  saaSSubscriptionPlanParameterList;
	
}