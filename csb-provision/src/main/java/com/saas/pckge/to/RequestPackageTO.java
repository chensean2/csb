/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.to.RequestPackageTO
 *
 * Copyright 2009 saas Pte. Ltd. All Rights Reserved
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
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.3.0     - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.pckge.to;

import com.saas.common.to.SCBaseTO;

public class RequestPackageTO extends SCBaseTO {
    private String requestID;
    private String status;
    private String orderDesc;
    private String orderRemarks;
    private String processedDt;
    private String processedBy;
    
    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
    
    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }
    
    public String getProcessedDt() {
        return processedDt;
    }

    public void setProcessedDt(String processedDt) {
        this.processedDt = processedDt;
    }
    
    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }
}
