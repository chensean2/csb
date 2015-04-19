package com.saas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.saas.common.entity.BaseEntity;


/**
 * The persistent class for the tbl_ss_app_service database table.
 * 
 */
@Entity
@Table(name="tbl_ss_app_service")
@NamedQuery(name="AppService.findAll", query="SELECT a FROM AppService a")
public class AppService extends BaseEntity<Long>  {
	private static final long serialVersionUID = 1L;

	
	@Column(name="ASSIGN_CONFIG_URL")
	private String assignConfigUrl;

	@Column(name="DASHBOARD_DISPLAY_INDICATOR")
	private String dashboardDisplayIndicator;

	@Column(name="EXPAND_SUB_INDICATOR")
	private String expandSubIndicator;

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

	public AppService() {
	}

	public String getAssignConfigUrl() {
		return this.assignConfigUrl;
	}

	public void setAssignConfigUrl(String assignConfigUrl) {
		this.assignConfigUrl = assignConfigUrl;
	}

	public String getDashboardDisplayIndicator() {
		return this.dashboardDisplayIndicator;
	}

	public void setDashboardDisplayIndicator(String dashboardDisplayIndicator) {
		this.dashboardDisplayIndicator = dashboardDisplayIndicator;
	}

	public String getExpandSubIndicator() {
		return this.expandSubIndicator;
	}

	public void setExpandSubIndicator(String expandSubIndicator) {
		this.expandSubIndicator = expandSubIndicator;
	}

	public String getIssuer() {
		return this.issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getMoreAppDescription() {
		return this.moreAppDescription;
	}

	public void setMoreAppDescription(String moreAppDescription) {
		this.moreAppDescription = moreAppDescription;
	}

	public String getMoreAppIconOff() {
		return this.moreAppIconOff;
	}

	public void setMoreAppIconOff(String moreAppIconOff) {
		this.moreAppIconOff = moreAppIconOff;
	}

	public String getMoreAppIconOn() {
		return this.moreAppIconOn;
	}

	public void setMoreAppIconOn(String moreAppIconOn) {
		this.moreAppIconOn = moreAppIconOn;
	}

	public String getMoreAppLaunchUrl() {
		return this.moreAppLaunchUrl;
	}

	public void setMoreAppLaunchUrl(String moreAppLaunchUrl) {
		this.moreAppLaunchUrl = moreAppLaunchUrl;
	}

	public String getMoreAppName() {
		return this.moreAppName;
	}

	public void setMoreAppName(String moreAppName) {
		this.moreAppName = moreAppName;
	}

	public String getProvisionConfigUpdateUrl() {
		return this.provisionConfigUpdateUrl;
	}

	public void setProvisionConfigUpdateUrl(String provisionConfigUpdateUrl) {
		this.provisionConfigUpdateUrl = provisionConfigUpdateUrl;
	}

	public String getProvisionConfigUrl() {
		return this.provisionConfigUrl;
	}

	public void setProvisionConfigUrl(String provisionConfigUrl) {
		this.provisionConfigUrl = provisionConfigUrl;
	}

	public String getServiceCategory() {
		return this.serviceCategory;
	}

	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public String getServiceDefName() {
		return this.serviceDefName;
	}

	public void setServiceDefName(String serviceDefName) {
		this.serviceDefName = serviceDefName;
	}

	public String getServiceDefVersion() {
		return this.serviceDefVersion;
	}

	public void setServiceDefVersion(String serviceDefVersion) {
		this.serviceDefVersion = serviceDefVersion;
	}

	public String getServiceDescription() {
		return this.serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceLaunchUrl() {
		return this.serviceLaunchUrl;
	}

	public void setServiceLaunchUrl(String serviceLaunchUrl) {
		this.serviceLaunchUrl = serviceLaunchUrl;
	}

	public byte[] getServiceLogo() {
		return this.serviceLogo;
	}

	public void setServiceLogo(byte[] serviceLogo) {
		this.serviceLogo = serviceLogo;
	}

	public String getServiceLogoOffPath() {
		return this.serviceLogoOffPath;
	}

	public void setServiceLogoOffPath(String serviceLogoOffPath) {
		this.serviceLogoOffPath = serviceLogoOffPath;
	}

	public String getServiceLogoOnPath() {
		return this.serviceLogoOnPath;
	}

	public void setServiceLogoOnPath(String serviceLogoOnPath) {
		this.serviceLogoOnPath = serviceLogoOnPath;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServicePassword() {
		return this.servicePassword;
	}

	public void setServicePassword(String servicePassword) {
		this.servicePassword = servicePassword;
	}

	public String getServiceProvisionUrl() {
		return this.serviceProvisionUrl;
	}

	public void setServiceProvisionUrl(String serviceProvisionUrl) {
		this.serviceProvisionUrl = serviceProvisionUrl;
	}

	public String getServiceSignOutUrl() {
		return this.serviceSignOutUrl;
	}

	public void setServiceSignOutUrl(String serviceSignOutUrl) {
		this.serviceSignOutUrl = serviceSignOutUrl;
	}

	public String getServiceStatus() {
		return this.serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceUsername() {
		return this.serviceUsername;
	}

	public void setServiceUsername(String serviceUsername) {
		this.serviceUsername = serviceUsername;
	}

	public String getSsoAcsUrl() {
		return this.ssoAcsUrl;
	}

	public void setSsoAcsUrl(String ssoAcsUrl) {
		this.ssoAcsUrl = ssoAcsUrl;
	}

	public String getSsoRelayState() {
		return this.ssoRelayState;
	}

	public void setSsoRelayState(String ssoRelayState) {
		this.ssoRelayState = ssoRelayState;
	}

	public String getSsoUrl() {
		return this.ssoUrl;
	}

	public void setSsoUrl(String ssoUrl) {
		this.ssoUrl = ssoUrl;
	}

	public byte[] getTermConditionContent() {
		return this.termConditionContent;
	}

	public void setTermConditionContent(byte[] termConditionContent) {
		this.termConditionContent = termConditionContent;
	}

	public String getTermConditionIndicator() {
		return this.termConditionIndicator;
	}

	public void setTermConditionIndicator(String termConditionIndicator) {
		this.termConditionIndicator = termConditionIndicator;
	}

}