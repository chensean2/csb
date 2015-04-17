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

public class ServiceResDetailTO extends SCBaseTO {

    /**
     * 
     */
    private static final long serialVersionUID = 229577849633285957L;

    private String servResDetailId;
    private String servResId;
    private String servResFieldName;
    private String servResFieldValue;

    public String getServResDetailId() {
        return servResDetailId;
    }

    public void setServResDetailId(String servResDetailId) {
        this.servResDetailId = servResDetailId;
    }

    public String getServResId() {
        return servResId;
    }

    public void setServResId(String servResId) {
        this.servResId = servResId;
    }

    public String getServResFieldName() {
        return servResFieldName;
    }

    public void setServResFieldName(String servResFieldName) {
        this.servResFieldName = servResFieldName;
    }

    public String getServResFieldValue() {
        return servResFieldValue;
    }

    public void setServResFieldValue(String servResFieldValue) {
        this.servResFieldValue = servResFieldValue;
    }
}
