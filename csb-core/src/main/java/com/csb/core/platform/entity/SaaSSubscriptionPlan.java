package com.csb.core.platform.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;

@Entity
@Table(name = "tbl_csb_platform_saas_subscription_plan")
public class SaaSSubscriptionPlan extends BaseEntity<Long> {



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
	
	//DEACTIVATED
	@Column(name = "NOTIFICATION_TYPE")
	private String notificationType;
	
	
	
	@OneToMany(mappedBy = "saaSSubscriptionPlan")
	private List<SaaSSubscriptionPlanItem>  saaSSubscriptionPlanItemList;
	
	@OneToMany(mappedBy = "saaSSubscriptionPlan")
	private List<SaaSSubscriptionPlanParameter>  saaSSubscriptionPlanParameterList;
	
}