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
 * v1.1     - Initial Release         mingshan                       Apr 7, 2010
 * =====================================================================================
 */
package com.saas.otp.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import com.saas.core.entity.audit.support.AuditableEntitySupport;

@Entity
@DynamicInsert
@DynamicUpdate
@Cacheable
@Table(name = "otp")
public class Otp extends AuditableEntitySupport<String> {

    private static final long serialVersionUID = -440155986661071660L;

    @NotEmpty
    @Length(max = 32)
    @Column(length = 32)
    protected String otp;
    
    @NotEmpty
    @Length(max = 32)
    @Column(length = 32)
    protected String application;
    
    @NotEmpty
    @Length(max = 100)
    @Column(length = 100)
    protected String loginId;
    
    @NotEmpty
    @Length(max = 1)
    @Column(length = 1)
    protected String deleteIndicator;

    public String getDeleteIndicator() {
        return deleteIndicator;
    }

    public void setDeleteIndicator(String deleteIndicator) {
        this.deleteIndicator = deleteIndicator;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

}
