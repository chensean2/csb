/*
 *  =========================================================================
 * Program Name: package com.saas.product.to.UserProductHistoryTO
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
 * v1.3.0    - Initial Release         jixiaowei                  Mar 2, 2011
 * =====================================================================================
 */
package com.saas.product.to;

public class UserAssignmentTO extends UserProductTO {
    private static final long serialVersionUID = 8902548280931544779L;

    private String assignmentId;
    
    private String proResCodeId;

    public String getProResCodeId() {
        return proResCodeId;
    }

    public void setProResCodeId(String proResCodeId) {
        this.proResCodeId = proResCodeId;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

}
