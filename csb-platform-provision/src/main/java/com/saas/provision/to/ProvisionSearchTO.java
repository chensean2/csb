/*
 * =========================================================================
 *Program Name:com.saas.provision.to.ProvisionSearchTO
 *
 *Copyright 2010 saas Pte. Ltd. All Rights Reserved
 *
 *This software is confidential and proprietary to saas Pte. Ltd. You shall
 *use this software only in accordance with the terms of the license
 *agreement you entered into with saas.  No aspect or part or all of this
 *software may be reproduced, modified or disclosed without full and
 *direct written authorisation from saas.
 *
 *saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 *REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 *SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 *FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 *MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 *Change Revision
 *----------------------------------------------------------------------------
 *Version    Remarks	              Author	    Editor          Date
 *v1.0     - Initial Release	      xinWu	                   April 15, 2010
 *=====================================================================================
 */
package com.saas.provision.to;

import com.saas.common.to.SCBaseTO;

public class ProvisionSearchTO extends SCBaseTO {

    private static final long serialVersionUID = 1718645220361097393L;
    private String reqNo;
    private String customerId;
    private String domainName;
    private String proviStatus;

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

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getProviStatus() {
        return proviStatus;
    }

    public void setProviStatus(String proviStatus) {
        this.proviStatus = proviStatus;
    }

}
