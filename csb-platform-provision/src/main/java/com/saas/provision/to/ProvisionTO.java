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

import org.apache.commons.lang3.time.DateFormatUtils;

import com.saas.common.to.SCBaseTO;

public class ProvisionTO extends SCBaseTO {

    private static final long serialVersionUID = 7086420213633469418L;

    private String reqId;
    private String reqNo;
    private String customerId;
    private java.sql.Timestamp reqRecTime;
    private java.sql.Timestamp reqEffTime;
    private java.sql.Timestamp provStartTime;
    private java.sql.Timestamp provEndTime;
    private Integer provSendTimes;
    private String provStatus;
    private java.sql.Timestamp rollbackStartTime;
    private java.sql.Timestamp rollbackEndTime;
    private int rollbackSendTimes;
    private String rollbackStatus;
    private String notifRecipient;
    private List<IsvServiceTO> isvServiceList;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public java.sql.Timestamp getReqRecTime() {
        return reqRecTime;
    }

    public void setReqRecTime(java.sql.Timestamp reqRecTime) {
        this.reqRecTime = reqRecTime;

    }

    public java.sql.Timestamp getReqEffTime() {
        return reqEffTime;
    }

    public void setReqEffTime(java.sql.Timestamp reqEffTime) {
        this.reqEffTime = reqEffTime;
    }

    public java.sql.Timestamp getProvStartTime() {
        return provStartTime;
    }

    public void setProvStartTime(java.sql.Timestamp provStartTime) {
        this.provStartTime = provStartTime;
    }

    public java.sql.Timestamp getProvEndTime() {
        return provEndTime;
    }

    public void setProvEndTime(java.sql.Timestamp provEndTime) {
        this.provEndTime = provEndTime;
    }

    public Integer getProvSendTimes() {
        return provSendTimes;
    }

    public void setProvSendTimes(Integer provSendTimes) {
        this.provSendTimes = provSendTimes;
    }

    public String getProvStatus() {
        return provStatus;
    }

    public void setProvStatus(String provStatus) {
        this.provStatus = provStatus;
    }

    public java.sql.Timestamp getRollbackStartTime() {
        return rollbackStartTime;
    }

    public void setRollbackStartTime(java.sql.Timestamp rollbackStartTime) {
        this.rollbackStartTime = rollbackStartTime;
    }

    public java.sql.Timestamp getRollbackEndTime() {
        return rollbackEndTime;
    }

    public void setRollbackEndTime(java.sql.Timestamp rollbackEndTime) {
        this.rollbackEndTime = rollbackEndTime;
    }

    public int getRollbackSendTimes() {
        return rollbackSendTimes;
    }

    public void setRollbackSendTimes(int rollbackSendTimes) {
        this.rollbackSendTimes = rollbackSendTimes;
    }

    public String getRollbackStatus() {
        return rollbackStatus;
    }

    public void setRollbackStatus(String rollbackStatus) {
        this.rollbackStatus = rollbackStatus;
    }

    public String getNotifRecipient() {
        return notifRecipient;
    }

    public void setNotifRecipient(String notifRecipient) {
        this.notifRecipient = notifRecipient;
    }

    public List<IsvServiceTO> getIsvServiceList() {
        return isvServiceList;
    }

    public void setIsvServiceList(List<IsvServiceTO> isvServiceList) {
        this.isvServiceList = isvServiceList;
    }

    public String getReqRecTimeAsStr() {
        return DateFormatUtils.format(this.reqRecTime, "dd/MM/yyyy HH:mm:ss");
    }

    public String getReqEffTimeAsStr() {
        return DateFormatUtils.format(this.reqEffTime, "dd/MM/yyyy hh:MM:ss");
    }

    public String getProvEndTimeAsStr() {
        return DateFormatUtils.format(this.provEndTime, "dd/MM/yyyy hh:MM:ss");
    }

    public String getRollbackStartTimeAsStr() {
        return DateFormatUtils.format(this.rollbackStartTime, "dd/MM/yyyy hh:MM:ss");
    }

    public String getRollbackEndTimeAsStr() {
        return DateFormatUtils.format(this.rollbackEndTime, "dd/MM/yyyy hh:MM:ss");
    }

    public String getProvStartTimeAsStr() {
        return DateFormatUtils.format(this.provStartTime, "dd/MM/yyyy hh:MM:ss");
    }

}
