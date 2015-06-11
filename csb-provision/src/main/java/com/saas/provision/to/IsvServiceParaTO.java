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

public class IsvServiceParaTO extends SCBaseTO {

    private static final long serialVersionUID = -2109153776158330698L;

    private String isvServiceParaId;
    private String isvServiceId;
    private String serviceParaName;
    private String serviceParaNewValue;
    private String serviceParaOldValue;

    public String getIsvServiceParaId() {
        return isvServiceParaId;
    }

    public void setIsvServiceParaId(String isvServiceParaId) {
        this.isvServiceParaId = isvServiceParaId;
    }

    public String getIsvServiceId() {
        return isvServiceId;
    }

    public void setIsvServiceId(String isvServiceId) {
        this.isvServiceId = isvServiceId;
    }

    public String getServiceParaName() {
        return serviceParaName;
    }

    public void setServiceParaName(String serviceParaName) {
        this.serviceParaName = serviceParaName;
    }

    public String getServiceParaNewValue() {
        return serviceParaNewValue;
    }

    public void setServiceParaNewValue(String serviceParaNewValue) {
        this.serviceParaNewValue = serviceParaNewValue;
    }

    public String getServiceParaOldValue() {
        return serviceParaOldValue;
    }

    public void setServiceParaOldValue(String serviceParaOldValue) {
        this.serviceParaOldValue = serviceParaOldValue;
    }
}
