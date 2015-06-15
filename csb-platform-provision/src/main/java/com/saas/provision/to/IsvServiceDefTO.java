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

import com.saas.common.to.SCBaseTO;

public class IsvServiceDefTO extends SCBaseTO {

    private static final long serialVersionUID = -5404390594541438650L;

    private String isvServiceDefId;
    private String serviceDefName;
    private String serviceDefCategory;
    private String serviceDefOperation;
    private String isvProvAdaptorId;
    private String isvRollbackAdaptorId;
    private String serviceDefVersion;

    public String getIsvProvAdaptorId() {
        return isvProvAdaptorId;
    }

    public void setIsvProvAdaptorId(String isvProvAdaptorId) {
        this.isvProvAdaptorId = isvProvAdaptorId;
    }

    public String getIsvRollbackAdaptorId() {
        return isvRollbackAdaptorId;
    }

    public void setIsvRollbackAdaptorId(String isvRollbackAdaptorId) {
        this.isvRollbackAdaptorId = isvRollbackAdaptorId;
    }

    public String getIsvServiceDefId() {
        return isvServiceDefId;
    }

    public void setIsvServiceDefId(String isvServiceDefId) {
        this.isvServiceDefId = isvServiceDefId;
    }

    public String getServiceDefCategory() {
        return serviceDefCategory;
    }

    public void setServiceDefCategory(String serviceDefCategory) {
        this.serviceDefCategory = serviceDefCategory;
    }

    public String getServiceDefOperation() {
        return serviceDefOperation;
    }

    public void setServiceDefOperation(String serviceDefOperation) {
        this.serviceDefOperation = serviceDefOperation;
    }

    public String getServiceDefName() {
        return serviceDefName;
    }

    public void setServiceDefName(String serviceDefName) {
        this.serviceDefName = serviceDefName;
    }

	public String getServiceDefVersion() {
		return serviceDefVersion;
	}

	public void setServiceDefVersion(String serviceDefVersion) {
		this.serviceDefVersion = serviceDefVersion;
	}

}
