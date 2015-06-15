/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.UserAssignmentService
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
package com.saas.product.service;

import java.util.List;

import com.saas.product.to.UserAssignmentTO;
import com.saas.product.to.UserProductTO;

public interface UserAssignmentService {

    /**
     * this method is used to create UserAssignment
     * version: 1.3.0
     */
    public void createUserAssignment(String transactionId, UserProductTO userProduct );

    /**
     * this method is used to update UserAssignment
     * version: 1.3.0
     */
    public void updateUserAssignment(UserAssignmentTO userAssignment);

    /**
     * this method is used to delete UserAssignment
     * version: 1.3.0
     */
    public void deleteUserAssignment(UserAssignmentTO userAssignment);

    /**
     * this method is used to search UserAssignment
     * version: 1.3.0
     */
    public UserAssignmentTO getUserAssignment(UserAssignmentTO userAssignment);

    /**
     * this method is used to get UserAssignment List
     * version: 1.3.0
     */
    public List<UserAssignmentTO> getUserAssignmentList(UserAssignmentTO userAssignment);

    /**
     * this method is used to search UserAssignment
     * version: 1.3.0
     */
    public List<UserAssignmentTO> searchUserAssignmentList(UserAssignmentTO userAssignment);

}