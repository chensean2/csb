/*
 * =========================================================================
 *  Program Name: com.saas.common.to.DomainServiceHistoryTO
 *
 *  Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 *  This software is confidential and proprietary to saas Pte. Ltd. You shall
 *  use this software only in accordance with the terms of the license
 *  agreement you entered into with saas.  No aspect or part or all of this
 *  software may be reproduced, modified or disclosed without full and
 *  direct written authorisation from saas.
 *
 *  saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 *  REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *  SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 *  FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *  MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *  Change Revision
 * -------------------------------------------------------------------------
 *  Version    Remarks
 *  v1.0       - Initial Release
 * =========================================================================
 */
package com.saas.common.to;

public class DomainServiceHistoryTO extends SCBaseTO {
   
    private static final long serialVersionUID = -3497684814099054272L;
    private String historyId;
    private String domainId;
    private String serviceId;
    private int serviceQuantity;
    private String actionType;
    private int trialQuantity;
    private java.util.Date trialEffectiveStartDatetime;
    private java.util.Date trialEffectiveEndDatetime;
    private String transactionId;
    private java.util.Date effectiveStartDatetime;
    private java.util.Date effectiveEndDatetime;
    public String getHistoryId() {
        return historyId;
    }
    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }
    public String getDomainId() {
        return domainId;
    }
    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }
    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
    public int getServiceQuantity() {
        return serviceQuantity;
    }
    public void setServiceQuantity(int serviceQuantity) {
        this.serviceQuantity = serviceQuantity;
    }
    public String getActionType() {
        return actionType;
    }
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
    public int getTrialQuantity() {
        return trialQuantity;
    }
    public void setTrialQuantity(int trialQuantity) {
        this.trialQuantity = trialQuantity;
    }
    public java.util.Date getTrialEffectiveStartDatetime() {
        return trialEffectiveStartDatetime;
    }
    public void setTrialEffectiveStartDatetime(java.util.Date trialEffectiveStartDatetime) {
        this.trialEffectiveStartDatetime = trialEffectiveStartDatetime;
    }
    public java.util.Date getTrialEffectiveEndDatetime() {
        return trialEffectiveEndDatetime;
    }
    public void setTrialEffectiveEndDatetime(java.util.Date trialEffectiveEndDatetime) {
        this.trialEffectiveEndDatetime = trialEffectiveEndDatetime;
    }
    public String getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    public java.util.Date getEffectiveStartDatetime() {
        return effectiveStartDatetime;
    }
    public void setEffectiveStartDatetime(java.util.Date effectiveStartDatetime) {
        this.effectiveStartDatetime = effectiveStartDatetime;
    }
    public java.util.Date getEffectiveEndDatetime() {
        return effectiveEndDatetime;
    }
    public void setEffectiveEndDatetime(java.util.Date effectiveEndDatetime) {
        this.effectiveEndDatetime = effectiveEndDatetime;
    }
    
}
