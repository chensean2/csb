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

import org.apache.commons.lang3.time.DateFormatUtils;

import com.saas.common.to.SCBaseTO;

public class ServiceResTO extends SCBaseTO {

    /**
     * 
     */
    private static final long serialVersionUID = -2995008600215837455L;

    private String servResId;
    private String isvServiceId;
    private java.sql.Timestamp servResReceiveTime;
    private String servResType;
    private String provResCode;
    private String provResMessage;
    private String rollbackResCode;
    private String rollbackResMessage;
    private String serviceResMessage;

    public String getServResId() {
        return servResId;
    }

    public void setServResId(String servResId) {
        this.servResId = servResId;
    }

    public String getIsvServiceId() {
        return isvServiceId;
    }

    public void setIsvServiceId(String isvServiceId) {
        this.isvServiceId = isvServiceId;
    }

    public java.sql.Timestamp getServResReceiveTime() {
        return servResReceiveTime;
    }

    public void setServResReceiveTime(java.sql.Timestamp servResReceiveTime) {
        this.servResReceiveTime = servResReceiveTime;

    }

    public String getServResType() {
        return servResType;
    }

    public void setServResType(String servResType) {
        this.servResType = servResType;
    }

    public String getProvResCode() {
        return provResCode;
    }

    public void setProvResCode(String provResCode) {
        this.provResCode = provResCode;
    }

    public String getProvResMessage() {
        return provResMessage;
    }

    public void setProvResMessage(String provResMessage) {
        this.provResMessage = provResMessage;
    }

    public String getRollbackResCode() {
        return rollbackResCode;
    }

    public void setRollbackResCode(String rollbackResCode) {
        this.rollbackResCode = rollbackResCode;
    }

    public String getRollbackResMessage() {
        return rollbackResMessage;
    }

    public void setRollbackResMessage(String rollbackResMessage) {
        this.rollbackResMessage = rollbackResMessage;
    }

    public String getServResReceiveTimeAsStr() {
        return DateFormatUtils.format(this.servResReceiveTime, "dd/MM/yyyy HH:mm:ss");
    }

    public String getServiceResMessage() {
        return serviceResMessage;
    }

    public void setServiceResMessage(String serviceResMessage) {
        this.serviceResMessage = serviceResMessage;
    }
    
}
