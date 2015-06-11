/*
 * =========================================================================
 *  Program Name: com.saas.common.to.AuditTrailTO
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

import java.sql.Timestamp;

public class Domain2ServiceTO extends SCBaseTO {

    private static final long serialVersionUID = -7600905199589310252L;
    private String domainId;
    private String serviceId;
    private Integer serviceQuantity;
    private Timestamp trialEffectiveStartDt;
    private Timestamp trialEffectiveEndDt;
    private Integer trialQuantity;
    private Integer consumeQuantity;
    private String serviceUnit;
    private String serviceType;
    private Timestamp effectiveStartDt;
    private Timestamp effectiveEndDt;

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

    public Integer getServiceQuantity() {
        return serviceQuantity;
    }

    public void setServiceQuantity(Integer serviceQuantity) {
        this.serviceQuantity = serviceQuantity;
    }

    public Timestamp getTrialEffectiveStartDt() {
        return trialEffectiveStartDt;
    }

    public void setTrialEffectiveStartDt(Timestamp trialEffectiveStartDt) {
        this.trialEffectiveStartDt = trialEffectiveStartDt;
    }

    public Timestamp getTrialEffectiveEndDt() {
        return trialEffectiveEndDt;
    }

    public void setTrialEffectiveEndDt(Timestamp trialEffectiveEndDt) {
        this.trialEffectiveEndDt = trialEffectiveEndDt;
    }

    public Integer getTrialQuantity() {
        return trialQuantity;
    }

    public void setTrialQuantity(Integer trialQuantity) {
        this.trialQuantity = trialQuantity;
    }

    public Integer getConsumeQuantity() {
        return consumeQuantity;
    }

    public void setConsumeQuantity(Integer consumeQuantity) {
        this.consumeQuantity = consumeQuantity;
    }

    public String getServiceUnit() {
        return serviceUnit;
    }

    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Timestamp getEffectiveStartDt() {
        return effectiveStartDt;
    }

    public void setEffectiveStartDt(Timestamp effectiveStartDt) {
        this.effectiveStartDt = effectiveStartDt;
    }

    public Timestamp getEffectiveEndDt() {
        return effectiveEndDt;
    }

    public void setEffectiveEndDt(Timestamp effectiveEndDt) {
        this.effectiveEndDt = effectiveEndDt;
    }
    
}
