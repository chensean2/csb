/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.ProductOrderHistoryTO
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

public class ProductOrderHistoryTO extends SCBaseTO {
    private static final long serialVersionUID = 8801666698638870980L;

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
    private String autoLicenseIndicator;
    private String proTxId;
    private Integer proRetryCount;

    private String historyId;
    private String transactionId;

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

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    public String getAutoLicenseIndicator() {
        return autoLicenseIndicator;
    }

    public void setAutoLicenseIndicator(String autoLicenseIndicator) {
        this.autoLicenseIndicator = autoLicenseIndicator;
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
}
