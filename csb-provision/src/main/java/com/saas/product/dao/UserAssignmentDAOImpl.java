/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.UserAssignmentDAOImpl
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
 * v1.3.0     - Initial Release         jixiaowei                   Mar 2, 2011
 * =====================================================================================
 */
package com.saas.product.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.product.to.UserAssignmentTO;

public class UserAssignmentDAOImpl extends SCBaseDAOImpl implements UserAssignmentDAO {
    private Logger log = LoggerFactory.getLogger(UserAssignmentDAOImpl.class);

    public int createUserAssignment(UserAssignmentTO userAssignment) {
        Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
        userAssignment.setLastUpdatedBy("SYSTEM");
        userAssignment.setCreatedDt(now);
        userAssignment.setLastUpdatedDt(now);

//        int i = pfwClient.insert(userAssignment);
//        
//        return i;
        return 0;
    }
    
    public int deleteUserAssignment(UserAssignmentTO userAssignment) {
        
        UserAssignmentTO userAssignmentTO = this.getUserAssignment(userAssignment);
        
        if (null == userAssignmentTO) {
            throw new SCServiceException(IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
        }
        int i = delete(userAssignment);
       
        return i;
    }

    public int updateUserAssignment(UserAssignmentTO userAssignment) {
        UserAssignmentTO oldUserAssignmentTO = this.getUserAssignment(userAssignment);
        int i = update(userAssignment);

       
        return i;
    }

    public UserAssignmentTO getUserAssignment(UserAssignmentTO serAssignment) {
        return (UserAssignmentTO) queryForObject(serAssignment);
    }

    public List<UserAssignmentTO> getUserAssignmentList(UserAssignmentTO userAssignment) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("userId", userAssignment.getUserId());
        return null;
//        return pfwClient.queryForList(UserAssignmentTO.class, "/userAssignment/getUserAssignmentList", paraMap);
    }

    public List<UserAssignmentTO> searchUserAssignmentList(UserAssignmentTO userAssignment) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("userId", userAssignment.getUserId());
//        return PaginationEnabler.queryForList(UserAssignmentTO.class, pfwClient, "/userAssignment/getUserAssignmentList", paraMap);
        return null;
    }

}