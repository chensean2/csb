/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.ProductOrderTO
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
 * v1.0     - Initial Release         jixiaowei                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.product.to;

import java.sql.Timestamp;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.csb.common.IAppsConstants;
import com.saas.common.to.SCBaseTO;

public class ProductOrderTO extends SCBaseTO {
    private static final long serialVersionUID = 3462307676278710682L;

    private String productOrderId;
    private String packageOrderId;
    private String orderId;
    private String packageId;
    private String productId;
    private String productOrderStatus;
    private String reason;
    private String provisionedBy;
    private Timestamp provisionedDt;
    private String serviceId;
    private String productName;
    private String productDesc;
    private String usageType;
    private Integer usageQuantity;
    private String unlimitIndicator;
    private String usageUnit;
    private String multiLicenseIndicator;
    private String autoAssignIndicator;
    private String proTxId;
    private Integer proRetryCount;

    private Integer productOrderListNum;
    private String provisionStatus;
    private String provisionConfigUrl;
    private String assignConfigUrl;
    private String provisionConfigUpdateUrl;
    private String[] serviceParameters;
    private String domainServiceRefKey;
    private String domainServiceRefId;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;

    public String getProvisionConfigUpdateUrl() {
        return provisionConfigUpdateUrl;
    }

    public void setProvisionConfigUpdateUrl(String provisionConfigUpdateUrl) {
        this.provisionConfigUpdateUrl = provisionConfigUpdateUrl;
    }

    public String getDomainServiceRefKey() {
        return domainServiceRefKey;
    }

    public void setDomainServiceRefKey(String domainServiceRefKey) {
        this.domainServiceRefKey = domainServiceRefKey;
    }

    public String[] getServiceParameters() {
        return serviceParameters;
    }

    public void setServiceParameters(String[] serviceParameters) {
        this.serviceParameters = serviceParameters;
    }

    public String getProvisionConfigUrl() {
        return provisionConfigUrl;
    }

    public void setProvisionConfigUrl(String provisionConfigUrl) {
        this.provisionConfigUrl = provisionConfigUrl;
    }

    public String getAssignConfigUrl() {
        return assignConfigUrl;
    }

    public void setAssignConfigUrl(String assignConfigUrl) {
        this.assignConfigUrl = assignConfigUrl;
    }

    public String getProvisionStatus() {
        return provisionStatus;
    }

    public void setProvisionStatus(String provisionStatus) {
        this.provisionStatus = provisionStatus;
    }

    public String getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(String productOrderId) {
        this.productOrderId = productOrderId;
    }

    public String getPackageOrderId() {
        return packageOrderId;
    }

    public void setPackageOrderId(String packageOrderId) {
        this.packageOrderId = packageOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getProductOrderStatus() {
        return productOrderStatus;
    }

    public void setProductOrderStatus(String productOrderStatus) {
        this.productOrderStatus = productOrderStatus;
    }

    public String getProvisionedBy() {
        return provisionedBy;
    }

    public void setProvisionedBy(String provisionedBy) {
        this.provisionedBy = provisionedBy;
    }

    public Timestamp getProvisionedDt() {
        return provisionedDt;
    }

    public void setProvisionedDt(Timestamp provisionedDt) {
        this.provisionedDt = provisionedDt;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
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

    public String getProvisionedDtAsStr() {
        return DateFormatUtils.format(this.provisionedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAutoAssignIndicator() {
        return autoAssignIndicator;
    }

    public void setAutoAssignIndicator(String autoAssignIndicator) {
        this.autoAssignIndicator = autoAssignIndicator;
    }

    public Integer getProductOrderListNum() {
        return productOrderListNum;
    }

    public void setProductOrderListNum(Integer productOrderListNum) {
        this.productOrderListNum = productOrderListNum;
    }

    public String getProTxId() {
        return proTxId;
    }

    public void setProTxId(String proTxId) {
        this.proTxId = proTxId;
    }

    public Integer getProRetryCount() {
        return proRetryCount;
    }

    public void setProRetryCount(Integer proRetryCount) {
        this.proRetryCount = proRetryCount;
    }

    public String getDomainServiceRefId() {
        return domainServiceRefId;
    }

    public void setDomainServiceRefId(String domainServiceRefId) {
        this.domainServiceRefId = domainServiceRefId;
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
    
    
}
