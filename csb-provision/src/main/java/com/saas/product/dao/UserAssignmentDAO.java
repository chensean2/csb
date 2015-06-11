/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.UserAssignmentDAO
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
package com.saas.product.dao;

import java.util.List;

import com.csb.common.dao.SCBaseDAO;
import com.saas.product.to.UserAssignmentTO;

public interface UserAssignmentDAO extends SCBaseDAO {
    public int createUserAssignment(UserAssignmentTO userAssignment);
    
    public int updateUserAssignment(UserAssignmentTO userAssignment);

    public int deleteUserAssignment(UserAssignmentTO userAssignment);

    public UserAssignmentTO getUserAssignment(UserAssignmentTO userAssignment);

    public List<UserAssignmentTO> getUserAssignmentList(UserAssignmentTO userAssignment);

    public List<UserAssignmentTO> searchUserAssignmentList(UserAssignmentTO userAssignment);

}