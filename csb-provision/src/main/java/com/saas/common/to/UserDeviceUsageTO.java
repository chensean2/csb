package com.saas.common.to;

public class UserDeviceUsageTO extends SCBaseTO {

    private static final long serialVersionUID = 8941079517554661219L;
    private String userId;
    private String firstName;
    private String lastName;
    private String userDeviceMapId;
    private String deviceUsage;
    private String serviceId;
    private String domainProductId;
    private String domainId;
    private String keywords;
    private String loginId;
    private String userProductId;
    private String mobileNum;
    private String mobileNumPrefix;
    private String mobileNumPostfix;

    public String getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(String userProductId) {
        this.userProductId = userProductId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
    
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDomainProductId() {
        return domainProductId;
    }

    public void setDomainProductId(String domainProductId) {
        this.domainProductId = domainProductId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserDeviceMapId() {
        return userDeviceMapId;
    }

    public void setUserDeviceMapId(String userDeviceMapId) {
        this.userDeviceMapId = userDeviceMapId;
    }

    public String getDeviceUsage() {
        return deviceUsage;
    }

    public void setDeviceUsage(String deviceUsage) {
        this.deviceUsage = deviceUsage;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getMobileNumPrefix() {
        return mobileNumPrefix;
    }

    public void setMobileNumPrefix(String mobileNumPrefix) {
        this.mobileNumPrefix = mobileNumPrefix;
    }

    public String getMobileNumPostfix() {
        return mobileNumPostfix;
    }

    public void setMobileNumPostfix(String mobileNumPostfix) {
        this.mobileNumPostfix = mobileNumPostfix;
    }

}
