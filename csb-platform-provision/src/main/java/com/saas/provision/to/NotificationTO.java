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

public class NotificationTO extends SCBaseTO {

    private static final long serialVersionUID = 5461522513631791464L;

    private String notifId;
    private String reqId;
    private String notifStatus;
    private int notifSendTimes;
    private String errorMessage;
    private String notifRecipient;

    public String getNotifId() {
        return notifId;
    }

    public void setNotifId(String notifId) {
        this.notifId = notifId;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getNotifStatus() {
        return notifStatus;
    }

    public void setNotifStatus(String notifStatus) {
        this.notifStatus = notifStatus;
    }

    public int getNotifSendTimes() {
        return notifSendTimes;
    }

    public void setNotifSendTimes(int notifSendTimes) {
        this.notifSendTimes = notifSendTimes;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getNotifRecipient() {
        return notifRecipient;
    }

    public void setNotifRecipient(String notifRecipient) {
        this.notifRecipient = notifRecipient;
    }
}