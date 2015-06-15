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

public class IsvAdaptorTO extends SCBaseTO {

    /**
     * 
     */
    private static final long serialVersionUID = -9152690858252028592L;

    private String isvAdaptorId;
    private String isvAdaptorName;
    private String isvAdaptorDesc;
    private String isvAdaptorEndpoint;
    private String isvAdaptorEndpointType;
    private String isvAdaptorAuthMethod;
    private String isvAdaptorAdminId;
    private String isvAdaptorAdminPass;

    public String getIsvAdaptorId() {
        return isvAdaptorId;
    }

    public void setIsvAdaptorId(String isvAdaptorId) {
        this.isvAdaptorId = isvAdaptorId;
    }

    public String getIsvAdaptorName() {
        return isvAdaptorName;
    }

    public void setIsvAdaptorName(String isvAdaptorName) {
        this.isvAdaptorName = isvAdaptorName;
    }

    public String getIsvAdaptorDesc() {
        return isvAdaptorDesc;
    }

    public void setIsvAdaptorDesc(String isvAdaptorDesc) {
        this.isvAdaptorDesc = isvAdaptorDesc;
    }

    public String getIsvAdaptorEndpoint() {
        return isvAdaptorEndpoint;
    }

    public void setIsvAdaptorEndpoint(String isvAdaptorEndpoint) {
        this.isvAdaptorEndpoint = isvAdaptorEndpoint;
    }

    public String getIsvAdaptorEndpointType() {
        return isvAdaptorEndpointType;
    }

    public void setIsvAdaptorEndpointType(String isvAdaptorEndpointType) {
        this.isvAdaptorEndpointType = isvAdaptorEndpointType;
    }

    public String getIsvAdaptorAuthMethod() {
        return isvAdaptorAuthMethod;
    }

    public void setIsvAdaptorAuthMethod(String isvAdaptorAuthMethod) {
        this.isvAdaptorAuthMethod = isvAdaptorAuthMethod;
    }

    public String getIsvAdaptorAdminId() {
        return isvAdaptorAdminId;
    }

    public void setIsvAdaptorAdminId(String isvAdaptorAdminId) {
        this.isvAdaptorAdminId = isvAdaptorAdminId;
    }

    public String getIsvAdaptorAdminPass() {
        return isvAdaptorAdminPass;
    }

    public void setIsvAdaptorAdminPass(String isvAdaptorAdminPass) {
        this.isvAdaptorAdminPass = isvAdaptorAdminPass;
    }
}
