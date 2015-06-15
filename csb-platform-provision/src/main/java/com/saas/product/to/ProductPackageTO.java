/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.ProductPackageTO
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

import java.sql.Timestamp;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.csb.common.IAppsConstants;
import com.saas.common.to.SCBaseTO;

public class ProductPackageTO extends SCBaseTO {
	private static final long serialVersionUID = -9174806399004870450L;

	private String packageId;
	private String productId;
	private String serviceId;
	private String productName;
	private String productDesc;
	private String usageType;
	private Integer usageQuantity;
	private String unlimitIndicator;
	private String usageUnit;
	private String multiLicenseIndicator;
	private String autoLincenseIndicator;
	private Timestamp productCreatedDt;
	private String productCreatedBy;
	private Timestamp productUpdatedDt;
	private String productUpdatedBy;

	private String serviceCategory;

	public String getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(String serviceCategory) {
		this.serviceCategory = serviceCategory;
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

	public Timestamp getProductCreatedDt() {
		return productCreatedDt;
	}

	public void setProductCreatedDt(Timestamp productCreatedDt) {
		this.productCreatedDt = productCreatedDt;
	}

	public String getProductCreatedBy() {
		return productCreatedBy;
	}

	public void setProductCreatedBy(String productCreatedBy) {
		this.productCreatedBy = productCreatedBy;
	}

	public Timestamp getProductUpdatedDt() {
		return productUpdatedDt;
	}

	public void setProductUpdatedDt(Timestamp productUpdatedDt) {
		this.productUpdatedDt = productUpdatedDt;
	}

	public String getProductUpdatedBy() {
		return productUpdatedBy;
	}

	public void setProductUpdatedBy(String productUpdatedBy) {
		this.productUpdatedBy = productUpdatedBy;
	}

	public String getProductCreatedDtAsStr() {
		return DateFormatUtils.format(this.productCreatedDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getProductUpdatedDtAsStr() {
		return DateFormatUtils.format(this.productUpdatedDt,
				IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
	}

	public String getAutoLincenseIndicator() {
		return autoLincenseIndicator;
	}

	public void setAutoLincenseIndicator(String autoLincenseIndicator) {
		this.autoLincenseIndicator = autoLincenseIndicator;
	}
}
