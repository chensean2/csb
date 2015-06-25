package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;


@Entity
@Table(name="tbl_csb_app_product_integration_definition")
public class AppProductIntegrationDefinition extends BaseEntity<Long>  {

	@OneToOne(mappedBy="appProductIntegrationDefinition")
	private AppProduct appProduct;
	
	@Column(name="SSO_URL")
	private String ssoUrl;
	
	@Column(name="SUBSCRIPTION_CREATE_URL")
	private String subscriptionCreateUrl;
	
	@Column(name="SUBSCRIPTION_UPDATE_URL")
	private String subscriptionUpdateUrl;
	
	@Column(name="SUBSCRIPTION_CANCEL_URL")
	private String subscriptionCancelUrl;

	@Column(name="SUBSCRIPTION_VALIDATE_URL")
	private String subscriptionValidateUrl;
	
	@Column(name="SUBSCRIPTION_NOTIFY_URL")
	private String subscriptionNotifyUrl;

	
	@Column(name="ASSIGNMENT_URL")
	private String assignmentURL;

	@Column(name="UN_ASSIGNMENT_URL")
	private String unAssignmentURL;
	
	@Column(name="OAUTH_CONSUMER_KEY")
	private String oauthConsumerKey;

	
	@Column(name="OAUTH_CONSUMER_SECRET")
	private String oauthConsumerSecret;


}