package com.saas.provision.service;


public class CustomerInfoTO{

	private static final long serialVersionUID = 1869685039259064610L;
	protected String saasId;
	protected String companyName;
	protected String resellerId;
	protected String regNo;
	protected String domainName;
	private String domainId;
	protected byte[] tenantLogo;
	protected String country;
	protected String tenantStatus;
	protected Integer totalLicense;
	protected String domainServiceRefId;
	protected String domainServiceRefKey;
	protected String serviceId;
	protected String extBillingAccountNum;//EXT_BILLING_ACCOUNT_NUM
        protected String postalCode;// POSTAL_CODE
        protected String streetAdd;// BILLING_ADD_1
        protected String packageId;
        protected String billingCycleStartDate;

	public String getExtBillingAccountNum() {
		return extBillingAccountNum;
	}

	public void setExtBillingAccountNum(String extBillingAccountNum) {
		this.extBillingAccountNum = extBillingAccountNum;
	}

	public byte[] getTenantLogo() {
		return tenantLogo;
	}

	public void setTenantLogo(byte[] tenantLogo) {
		this.tenantLogo = tenantLogo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTenantStatus() {
		return tenantStatus;
	}

	public void setTenantStatus(String tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

	public Integer getTotalLicense() {
		return totalLicense;
	}

	public void setTotalLicense(Integer totalLicense) {
		this.totalLicense = totalLicense;
	}

	public String getSaasId() {
		return saasId;
	}

	public void setSaasId(String saasId) {
		this.saasId = saasId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getResellerId() {
		return resellerId;
	}

	public void setResellerId(String resellerId) {
		this.resellerId = resellerId;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDomainServiceRefId() {
		return domainServiceRefId;
	}

	public void setDomainServiceRefId(String domainServiceRefId) {
		this.domainServiceRefId = domainServiceRefId;
	}

	public String getDomainServiceRefKey() {
		return domainServiceRefKey;
	}

	public void setDomainServiceRefKey(String domainServiceRefKey) {
		this.domainServiceRefKey = domainServiceRefKey;
	}
	
	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetAdd() {
        return streetAdd;
    }

    public void setStreetAdd(String streetAdd) {
        this.streetAdd = streetAdd;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getBillingCycleStartDate() {
        return billingCycleStartDate;
    }

    public void setBillingCycleStartDate(String billingCycleStartDate) {
        this.billingCycleStartDate = billingCycleStartDate;
    } 
    
}
