/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.PackageLicenceOrderTO
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
 * v1.0     - Initial Release         zhanganshou                  Mar 40, 2013
 * =====================================================================================
 */
package com.saas.pckge.to;

import com.saas.common.to.SCBaseTO;

public class PackageLicenceOrderTO extends SCBaseTO {
	private static final long serialVersionUID = -3530837558452387635L;

	private String packageLicenceOrderId;
	private String orderNumber;
	private String packageId;
	private String packageName;
	private String userId;
	private String quotaDesc;
	private String planDesc;
	private String quantity;
	private String licenceDesc;

	public String getPackageLicenceOrderId() {
		return packageLicenceOrderId;
	}

	public void setPackageLicenceOrderId(String packageLicenceOrderId) {
		this.packageLicenceOrderId = packageLicenceOrderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuotaDesc() {
		return quotaDesc;
	}

	public void setQuotaDesc(String quotaDesc) {
		this.quotaDesc = quotaDesc;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLicenceDesc() {
		return licenceDesc;
	}

	public void setLicenceDesc(String licenceDesc) {
		this.licenceDesc = licenceDesc;
	}

}
