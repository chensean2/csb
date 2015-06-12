package com.csb.core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.csb.core.common.entity.BaseEntity;


@Entity
@Table(name="tbl_csb_app_product")
public class AppProduct extends BaseEntity<Long>  {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="APP_PROVIDER_ID")
	private AppProvider appProvider;
	
	@OneToMany(mappedBy="appProduct")
	private List<AppPlan> appPlanList;
	
	
	@Column(name="ASSIGN_CONFIG_URL")
	private String assignConfigUrl;


	@Column(name="ISSUER")
	private String issuer;

	@Column(name="MORE_APP_DESCRIPTION")
	private String moreAppDescription;

	@Column(name="MORE_APP_ICON_OFF")
	private String moreAppIconOff;

	@Column(name="MORE_APP_ICON_ON")
	private String moreAppIconOn;

	@Column(name="MORE_APP_LAUNCH_URL")
	private String moreAppLaunchUrl;

	@Column(name="MORE_APP_NAME")
	private String moreAppName;

	@Column(name="PROVISION_CONFIG_UPDATE_URL")
	private String provisionConfigUpdateUrl;

	@Column(name="PROVISION_CONFIG_URL")
	private String provisionConfigUrl;

	@Column(name="SERVICE_CATEGORY")
	private String serviceCategory;

	@Column(name="SERVICE_DEF_NAME")
	private String serviceDefName;

	@Column(name="SERVICE_DEF_VERSION")
	private String serviceDefVersion;

	@Column(name="SERVICE_DESCRIPTION")
	private String serviceDescription;

	@Column(name="SERVICE_ID")
	private String serviceId;

	@Column(name="SERVICE_LAUNCH_URL")
	private String serviceLaunchUrl;

	@Lob
	@Column(name="SERVICE_LOGO")
	private byte[] serviceLogo;

	@Column(name="SERVICE_LOGO_OFF_PATH")
	private String serviceLogoOffPath;

	@Column(name="SERVICE_LOGO_ON_PATH")
	private String serviceLogoOnPath;

	@Column(name="SERVICE_NAME")
	private String serviceName;

	@Column(name="SERVICE_PASSWORD")
	private String servicePassword;

	@Column(name="SERVICE_PROVISION_URL")
	private String serviceProvisionUrl;

	@Column(name="SERVICE_SIGN_OUT_URL")
	private String serviceSignOutUrl;

	@Column(name="SERVICE_STATUS")
	private String serviceStatus;

	@Column(name="SERVICE_TYPE")
	private String serviceType;

	@Column(name="SERVICE_USERNAME")
	private String serviceUsername;

	@Column(name="SSO_ACS_URL")
	private String ssoAcsUrl;

	@Column(name="SSO_RELAY_STATE")
	private String ssoRelayState;

	@Column(name="SSO_URL")
	private String ssoUrl;

	@Lob
	@Column(name="TERM_CONDITION_CONTENT")
	private byte[] termConditionContent;

	@Column(name="TERM_CONDITION_INDICATOR")
	private String termConditionIndicator;

	public AppProduct() {
	}

}