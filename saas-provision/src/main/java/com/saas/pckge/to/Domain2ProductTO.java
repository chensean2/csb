/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.Domain2ProductTO
 *
 * Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 * This software is confidential and proprietary to saas Pte. Ltd. You shall
 * use this software only in accordance with the terms of the license
 * agreement you entered into with saas.  No aspect or part or all of this
 * software may be reproduced, modified or disclosed without full and
 * direct written authorisation from saas.
 *
 * saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 * REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 * SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 * FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.0     - Initial Release         samyang                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.to;

import com.saas.common.to.SCBaseTO;

public class Domain2ProductTO extends SCBaseTO {
    private static final long serialVersionUID = -3852582052476208783L;

    private String domainProductId;
    private String domainProductStatus;
    private String domainPackageId;
    private String domainId;
    private String packageId;
    private String productId;
    private String serviceId;
    private String domainServiceRefId;
    private String domainServiceRefKey;
    private String productName;
    private String productDesc;
    private String usageType;
    private Integer usageQuantity;
    private String unlimitIndicator;
    private String usageUnit;
    private String multiLicenseIndicator;
    private String autoAssiginIndicator;

    private String totalLicensePurchased;
    private String totalLicenseAssigned;
    private String productConfiguration;
    private boolean assigned;
    private String assiginConfigUrl;
    private String[] serviceParameters;

    private String userProductStatus;
    private String userProductLock;
    private String statusType;

    private String serviceCategory;

    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private Domain2PackageTO domainPackageTO;

    public Domain2PackageTO getDomainPackageTO() {
		return domainPackageTO;
	}

	public void setDomainPackageTO(Domain2PackageTO domainPackageTO) {
		this.domainPackageTO = domainPackageTO;
	}

	public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getUserProductLock() {
        return userProductLock;
    }

    public void setUserProductLock(String userProductLock) {
        this.userProductLock = userProductLock;
    }

    public String getUserProductStatus() {
        return userProductStatus;
    }

    public void setUserProductStatus(String userProductStatus) {
        this.userProductStatus = userProductStatus;
    }

    public String[] getServiceParameters() {
        return serviceParameters;
    }

    public void setServiceParameters(String[] serviceParameters) {
        this.serviceParameters = serviceParameters;
    }

    public String getAssiginConfigUrl() {
        return assiginConfigUrl;
    }

    public void setAssiginConfigUrl(String assiginConfigUrl) {
        this.assiginConfigUrl = assiginConfigUrl;
    }

    public String getDomainProductId() {
        return domainProductId;
    }

    public void setDomainProductId(String domainProductId) {
        this.domainProductId = domainProductId;
    }

    public String getDomainProductStatus() {
        return domainProductStatus;
    }

    public void setDomainProductStatus(String domainProductStatus) {
        this.domainProductStatus = domainProductStatus;
    }

    public String getDomainPackageId() {
        return domainPackageId;
    }

    public void setDomainPackageId(String domainPackageId) {
        this.domainPackageId = domainPackageId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public Integer getUsageQuantity() {
        return usageQuantity;
    }

    public void setUsageQuantity(Integer usageQuantity) {
        this.usageQuantity = usageQuantity;
    }

    public String getUnlimitIndicator() {
        return unlimitIndicator;
    }

    public void setUnlimitIndicator(String unlimitIndicator) {
        this.unlimitIndicator = unlimitIndicator;
    }

    public String getUsageUnit() {
        return usageUnit;
    }

    public void setUsageUnit(String usageUnit) {
        this.usageUnit = usageUnit;
    }

    public String getMultiLicenseIndicator() {
        return multiLicenseIndicator;
    }

    public void setMultiLicenseIndicator(String multiLicenseIndicator) {
        this.multiLicenseIndicator = multiLicenseIndicator;
    }

    public String getTotalLicensePurchased() {
        return totalLicensePurchased;
    }

    public void setTotalLicensePurchased(String totalLicensePurchased) {
        this.totalLicensePurchased = totalLicensePurchased;
    }

    public String getTotalLicenseLeft() {
        if (null == totalLicenseAssigned || null == totalLicensePurchased) {
            return "0";
        }

        try {
            int result = Integer.valueOf(totalLicensePurchased.trim()) - Integer.valueOf(totalLicenseAssigned.trim());
            return String.valueOf(result);
        } catch (Exception e) {
            return "0";
        }
    }

    public String getTotalLicenseAssigned() {
        return totalLicenseAssigned;
    }

    public void setTotalLicenseAssigned(String totalLicenseAssigned) {
        this.totalLicenseAssigned = totalLicenseAssigned;
    }

    public String getProductConfiguration() {
        return productConfiguration;
    }

    public void setProductConfiguration(String productConfiguration) {
        this.productConfiguration = productConfiguration;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public String getAutoAssiginIndicator() {
        return autoAssiginIndicator;
    }

    public void setAutoAssiginIndicator(String autoAssiginIndicator) {
        this.autoAssiginIndicator = autoAssiginIndicator;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }
    
}
