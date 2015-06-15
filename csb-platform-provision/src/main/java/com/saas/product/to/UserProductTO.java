/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.UserProductTO
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
 * v1.3.0     - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.product.to;

import com.saas.common.to.SCBaseTO;

public class UserProductTO extends SCBaseTO {
    private static final long serialVersionUID = -7807638370848652699L;

    private String userProductId;
    private String userId;
    private String domainProductId;
    private String packageId;
    private String productId;
    private String serviceId;
    private String statusType;
    private String userProductStatus;
    private String userProductLock;
    private String serviceRefId;
    private String serviceRefKey;
    private String proTxId;
    private String proDescCodeId;

    private String productName;
    private String productDesc;
    // Product Assignment Log
    private String productDetail;
    private String transferRefId;// TRANSFER_REF_ID

    private String hideIndicator;

    private String ignoreCountIndicator;

    private String userDeviceMapId;
    
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    
    private String ext5;
    private String ext6;
    private String ext7;
    private String ext8;
    private String ext9;
    private String ext10;

    private String domainRefId;
    private String domainRefKey;
    
    private String domainId;
    private String packageName;
    private String previousPackageName;
    private boolean combineIndicator;

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
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

    public String getUserProductId() {
        return userProductId;
    }

    public void setUserProductId(String userProductId) {
        this.userProductId = userProductId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDomainProductId() {
        return domainProductId;
    }

    public void setDomainProductId(String domainProductId) {
        this.domainProductId = domainProductId;
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

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getUserProductStatus() {
        return userProductStatus;
    }

    public void setUserProductStatus(String userProductStatus) {
        this.userProductStatus = userProductStatus;
    }

    public String getUserProductLock() {
        return userProductLock;
    }

    public void setUserProductLock(String userProductLock) {
        this.userProductLock = userProductLock;
    }

    public String getServiceRefId() {
        return serviceRefId;
    }

    public void setServiceRefId(String serviceRefId) {
        this.serviceRefId = serviceRefId;
    }

    public String getServiceRefKey() {
        return serviceRefKey;
    }

    public void setServiceRefKey(String serviceRefKey) {
        this.serviceRefKey = serviceRefKey;
    }

    // Product Assignment Log
    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProTxId() {
        return proTxId;
    }

    public void setProTxId(String proTxId) {
        this.proTxId = proTxId;
    }

    public String getProDescCodeId() {
        return proDescCodeId;
    }

    public void setProDescCodeId(String proDescCodeId) {
        this.proDescCodeId = proDescCodeId;
    }

    public String getTransferRefId() {
        return transferRefId;
    }

    public void setTransferRefId(String transferRefId) {
        this.transferRefId = transferRefId;
    }

    public String getDomainRefId() {
        return domainRefId;
    }

    public void setDomainRefId(String domainRefId) {
        this.domainRefId = domainRefId;
    }

    public String getDomainRefKey() {
        return domainRefKey;
    }

    public void setDomainRefKey(String domainRefKey) {
        this.domainRefKey = domainRefKey;
    }

    public String getHideIndicator() {
        return hideIndicator;
    }

    public void setHideIndicator(String hideIndicator) {
        this.hideIndicator = hideIndicator;
    }

    public String getIgnoreCountIndicator() {
        return ignoreCountIndicator;
    }

    public void setIgnoreCountIndicator(String ignoreCountIndicator) {
        this.ignoreCountIndicator = ignoreCountIndicator;
    }
    
    public String getUserDeviceMapId() {
        return userDeviceMapId;
    }

    public void setUserDeviceMapId(String userDeviceMapId) {
        this.userDeviceMapId = userDeviceMapId;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
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

    public String getExt6() {
        return ext6;
    }

    public void setExt6(String ext6) {
        this.ext6 = ext6;
    }

    public String getExt7() {
        return ext7;
    }

    public void setExt7(String ext7) {
        this.ext7 = ext7;
    }

    public String getExt8() {
        return ext8;
    }

    public void setExt8(String ext8) {
        this.ext8 = ext8;
    }

    public String getExt9() {
        return ext9;
    }

    public void setExt9(String ext9) {
        this.ext9 = ext9;
    }

    public String getExt10() {
        return ext10;
    }

    public void setExt10(String ext10) {
        this.ext10 = ext10;
    }

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPreviousPackageName(String previousPackageName) {
		this.previousPackageName = previousPackageName;
	}

	public String getPreviousPackageName() {
		return previousPackageName;
	}

	public void setCombineIndicator(boolean combineIndicator) {
		this.combineIndicator = combineIndicator;
	}

	public boolean isCombineIndicator() {
		return combineIndicator;
	}
}
