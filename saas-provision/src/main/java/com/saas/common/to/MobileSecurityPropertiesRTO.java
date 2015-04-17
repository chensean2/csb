package com.saas.common.to;


public class MobileSecurityPropertiesRTO implements Comparable<MobileSecurityPropertiesRTO>{
	
	private String loginId;

	private String multiLicenseKey;

	private String singleLicenseKey;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;
	
	private String deviceName;

	private String imei;

	private String imsi;

	private String operatingSystem;

	private String activationDate;

	private String expirationDate;

	private String numberOfUpdateChecks;

	private String lastUpdateCheck;

	private String lastDBUpdate;

	private String lastSWUpdate;

	private String deviceLang;

	private String applicationLang;

	private String imeiChanges;

	private String applicationVersion;

	private String dbVersion;

	private String isApplicationUpToDate;

	private String isDbUpToDate;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getMultiLicenseKey() {
		return multiLicenseKey;
	}

	public void setMultiLicenseKey(String multiLicenseKey) {
		this.multiLicenseKey = multiLicenseKey;
	}

	public String getSingleLicenseKey() {
		return singleLicenseKey;
	}

	public void setSingleLicenseKey(String singleLicenseKey) {
		this.singleLicenseKey = singleLicenseKey;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getNumberOfUpdateChecks() {
		return numberOfUpdateChecks;
	}

	public void setNumberOfUpdateChecks(String numberOfUpdateChecks) {
		this.numberOfUpdateChecks = numberOfUpdateChecks;
	}

	public String getLastUpdateCheck() {
		return lastUpdateCheck;
	}

	public void setLastUpdateCheck(String lastUpdateCheck) {
		this.lastUpdateCheck = lastUpdateCheck;
	}

	public String getLastDBUpdate() {
		return lastDBUpdate;
	}

	public void setLastDBUpdate(String lastDBUpdate) {
		this.lastDBUpdate = lastDBUpdate;
	}

	public String getLastSWUpdate() {
		return lastSWUpdate;
	}

	public void setLastSWUpdate(String lastSWUpdate) {
		this.lastSWUpdate = lastSWUpdate;
	}

	public String getDeviceLang() {
		return deviceLang;
	}

	public void setDeviceLang(String deviceLang) {
		this.deviceLang = deviceLang;
	}

	public String getApplicationLang() {
		return applicationLang;
	}

	public void setApplicationLang(String applicationLang) {
		this.applicationLang = applicationLang;
	}

	public String getImeiChanges() {
		return imeiChanges;
	}

	public void setImeiChanges(String imeiChanges) {
		this.imeiChanges = imeiChanges;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public String getDbVersion() {
		return dbVersion;
	}

	public void setDbVersion(String dbVersion) {
		this.dbVersion = dbVersion;
	}

	public String getIsApplicationUpToDate() {
		return isApplicationUpToDate;
	}

	public void setIsApplicationUpToDate(String isApplicationUpToDate) {
		this.isApplicationUpToDate = isApplicationUpToDate;
	}

	public String getIsDbUpToDate() {
		return isDbUpToDate;
	}

	public void setIsDbUpToDate(String isDbUpToDate) {
		this.isDbUpToDate = isDbUpToDate;
	}
	
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Override
	public int compareTo(MobileSecurityPropertiesRTO o) {
		return o.getActivationDate().compareTo(this.getActivationDate()); 
	}

}
