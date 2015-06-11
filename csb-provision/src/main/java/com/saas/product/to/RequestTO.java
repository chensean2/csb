/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.RequestTO
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

public class RequestTO extends SCBaseTO {
    private static final long serialVersionUID = 2690325759386004237L;

    private String requestId;
    private String requestRefNum;
    private String domainId;
    private String requestStatus;
    private String requestCurrentFollowedBy;
    private Timestamp requestCurrentFollowedDt;
    private String requestLastFollowedBy;
    private Timestamp requestLastFollowedDt;
    private String orderId;
    private String orderRefNum;
    private String tenantName;
    private String requestDesc;
    private String requestCustomerRemarks;
    private String requestProvisionRemarks;
    private Timestamp requestedDt;
    private String requestedBy;
    //Task List
    private String saasId;
    private String requestStartDate;
    private String requestEndDate;
    
    

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestRefNum() {
        return requestRefNum;
    }

    public void setRequestRefNum(String requestRefNum) {
        this.requestRefNum = requestRefNum;
    }

    public String getDomainId() {
        return domainId == null ? "" : domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestDesc() {
        return requestDesc;
    }

    public void setRequestDesc(String requestDesc) {
        this.requestDesc = requestDesc;
    }

    public String getRequestCustomerRemarks() {
        return requestCustomerRemarks;
    }

    public void setRequestCustomerRemarks(String requestCustomerRemarks) {
        this.requestCustomerRemarks = requestCustomerRemarks;
    }

    public String getRequestProvisionRemarks() {
        return requestProvisionRemarks;
    }

    public void setRequestProvisionRemarks(String requestProvisionRemarks) {
        this.requestProvisionRemarks = requestProvisionRemarks;
    }

    public Timestamp getRequestedDt() {
        return requestedDt;
    }

    public void setRequestedDt(Timestamp requestedDt) {
        this.requestedDt = requestedDt;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getRequestCurrentFollowedBy() {
        return requestCurrentFollowedBy;
    }

    public void setRequestCurrentFollowedBy(String requestCurrentFollowedBy) {
        this.requestCurrentFollowedBy = requestCurrentFollowedBy;
    }

    public Timestamp getRequestCurrentFollowedDt() {
        return requestCurrentFollowedDt;
    }

    public void setRequestCurrentFollowedDt(Timestamp requestCurrentFollowedDt) {
        this.requestCurrentFollowedDt = requestCurrentFollowedDt;
    }

    public String getRequestLastFollowedBy() {
        return requestLastFollowedBy;
    }

    public void setRequestLastFollowedBy(String requestLastFollowedBy) {
        this.requestLastFollowedBy = requestLastFollowedBy;
    }

    public Timestamp getRequestLastFollowedDt() {
        return requestLastFollowedDt;
    }

    public void setRequestLastFollowedDt(Timestamp requestLastFollowedDt) {
        this.requestLastFollowedDt = requestLastFollowedDt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderRefNum() {
        return orderRefNum;
    }

    public void setOrderRefNum(String orderRefNum) {
        this.orderRefNum = orderRefNum;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
    public String getRequestCurrentFollowedDtAsStr() {
    	return DateFormatUtils.format(this.requestCurrentFollowedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }
    public String getRequestLastFollowedDtAsStr() {
    	return DateFormatUtils.format(this.requestLastFollowedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }
    public String getRequestedDtAsStr() {
    	return DateFormatUtils.format(this.requestedDt, IAppsConstants.DATEFORMAT_D_M_Y_H_M_S);
    }

	public String getSaasId() {
		return saasId;
	}

	public void setSaasId(String saasId) {
		this.saasId = saasId;
	}

	public String getRequestStartDate() {
		return requestStartDate;
	}

	public void setRequestStartDate(String requestStartDate) {
		this.requestStartDate = requestStartDate;
	}

	public String getRequestEndDate() {
		return requestEndDate;
	}

	public void setRequestEndDate(String requestEndDate) {
		this.requestEndDate = requestEndDate;
	}


}
