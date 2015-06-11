/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.UserProductHistoryServiceImpl
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
package com.saas.product.service;

import java.util.List;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.DaoRunTimeException;
import com.csb.common.exception.SCServiceException;
import com.saas.product.dao.UserAssignmentDAO;
import com.saas.product.to.UserAssignmentTO;
import com.saas.product.to.UserProductTO;

public class UserAssignmentServiceImpl implements UserAssignmentService {

    private UserAssignmentDAO userAssignmentDAO;

    public void createUserAssignment(String assignmentId, UserProductTO userProduct) {
        UserAssignmentTO userAssignment = new UserAssignmentTO();
        try {
            //PropertyUtils.copyProperties(userAssignment, userProduct);
        } catch (Exception e) {
            throw new SCServiceException(e);
        }
        
        userAssignment.setAssignmentId(assignmentId);

        userAssignmentDAO.createUserAssignment(userAssignment);
    }

    public void updateUserAssignment(UserAssignmentTO userAssignment) {
        try {
            int result = userAssignmentDAO.updateUserAssignment(userAssignment);

            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
               throw new ConcurrentUpdateException();
            } else {
               throw new SCServiceException(e);
            }
        }
    }

    public void deleteUserAssignment(UserAssignmentTO userAssignment) {
        try {
            int result = userAssignmentDAO.deleteUserAssignment(userAssignment);
            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
                throw new ConcurrentUpdateException();
            } else {
                 throw new SCServiceException(e);
            }
        }
    }

    public UserAssignmentTO getUserAssignment(UserAssignmentTO userAssignment) {
        return userAssignmentDAO.getUserAssignment(userAssignment);
    }

    public List<UserAssignmentTO> getUserAssignmentList(UserAssignmentTO userAssignment) {
        return userAssignmentDAO.getUserAssignmentList(userAssignment);
    }

    public List<UserAssignmentTO> searchUserAssignmentList(UserAssignmentTO userAssignment) {
        return userAssignmentDAO.searchUserAssignmentList(userAssignment);
    }

    public UserAssignmentDAO getUserAssignmentDAO() {
        return userAssignmentDAO;
    }

    public void setUserAssignmentDAO(UserAssignmentDAO userAssignmentDAO) {
        this.userAssignmentDAO = userAssignmentDAO;
    }

}