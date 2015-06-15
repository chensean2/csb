/*
 * =========================================================================
 * Program Name: com.saas.sso.to.OtpTO
 *
 * Copyright 2010 saas Pte. Ltd. All Rights Reserved
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
 *
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.1     - Initial Release          luzhen                       Apr 12, 2010
 * =====================================================================================
 */
package com.saas.provision.to;

import java.util.List;

import com.saas.common.to.SCBaseTO;

public class IsvServiceTO extends SCBaseTO {

    private static final long serialVersionUID = -422281848328584902L;

    private String isvServiceId;
    private String reqId;
    private String serviceName;
    private String serviceCategory;
    private String serviceOperation;
    private String provisionServStatus;
    private String rollbackServStatus;
    private Integer serviceSeq;
    private String isvServiceDefId;
    private List<IsvServiceParaTO> isvServiceParaList;
    private String serviceDefVersion;
    private String requestNum;
    

    public String getIsvServiceId() {
        return isvServiceId;
    }

    public void setIsvServiceId(String isvServiceId) {
        this.isvServiceId = isvServiceId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceOperation() {
        return serviceOperation;
    }

    public void setServiceOperation(String serviceOperation) {
        this.serviceOperation = serviceOperation;
    }

    public String getProvisionServStatus() {
        return provisionServStatus;
    }

    public void setProvisionServStatus(String provisionServStatus) {
        this.provisionServStatus = provisionServStatus;
    }

    public String getRollbackServStatus() {
        return rollbackServStatus;
    }

    public void setRollbackServStatus(String rollbackServStatus) {
        this.rollbackServStatus = rollbackServStatus;
    }

    public Integer getServiceSeq() {
        return serviceSeq;
    }

    public void setServiceSeq(Integer serviceSeq) {
        this.serviceSeq = serviceSeq;
    }

    public String getIsvServiceDefId() {
        return isvServiceDefId;
    }

    public void setIsvServiceDefId(String isvServiceDefId) {
        this.isvServiceDefId = isvServiceDefId;
    }

    public List<IsvServiceParaTO> getIsvServiceParaList() {
        return isvServiceParaList;
    }

    public void setIsvServiceParaList(List<IsvServiceParaTO> isvServiceParaList) {
        this.isvServiceParaList = isvServiceParaList;
    }

	public String getServiceDefVersion() {
		return serviceDefVersion;
	}

	public void setServiceDefVersion(String serviceDefVersion) {
		this.serviceDefVersion = serviceDefVersion;
	}

	public String getRequestNum() {
		return requestNum;
	}

	public void setRequestNum(String requestNum) {
		this.requestNum = requestNum;
	}

}
