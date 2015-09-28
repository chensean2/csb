package com.csb.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.csb.core.common.BaseEntity;


@Entity
@Table(name="csb_app_product_integration_definition")
public class AppProductIntegrationDefinition extends BaseEntity<Long>  {

	@OneToOne(mappedBy="appProductIntegrationDefinition")
	private AppProduct appProduct;
	
	@Column(name="sso_url")
	private String ssoUrl;
	
	@Column(name="subscription_create_url")
	private String subscriptionCreateUrl;
	
	@Column(name="subscription_update_url")
	private String subscriptionUpdateUrl;
	
	@Column(name="subscription_cancel_url")
	private String subscriptionCancelUrl;

	@Column(name="subscription_validate_url")
	private String subscriptionValidateUrl;
	
	@Column(name="subscription_notify_url")
	private String subscriptionNotifyUrl;

	
	@Column(name="assignment_url")
	private String assignmentURL;

	@Column(name="un_assignment_url")
	private String unAssignmentURL;
	
	@Column(name="oauth_consumer_key")
	private String oauthConsumerKey;

	
	@Column(name="oauth_consumer_secret")
	private String oauthConsumerSecret;


}