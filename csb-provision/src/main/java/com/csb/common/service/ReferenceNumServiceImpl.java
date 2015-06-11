/*
 *  =========================================================================
 * Program Name: package com.saas.common.service.ReferenceNumServiceImpl
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
 * v1.0     - Initial Release         jixiaowei                   Mar 17, 2011
 * =====================================================================================
 */
package com.csb.common.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.ConfigProperties;
import com.csb.common.DaoRunTimeException;
import com.csb.common.IAppsConstants;
import com.csb.common.dao.ReferenceNumDAO;
import com.csb.common.exception.SCServiceException;
import com.saas.common.to.ReferenceNumTO;

public class ReferenceNumServiceImpl implements ReferenceNumService {

    private ReferenceNumDAO referenceNumDAO;

    public void createReferenceNum(ReferenceNumTO referenceNum) {
    	referenceNumDAO.createReferenceNum(referenceNum);
    }

    public void updateReferenceNum(ReferenceNumTO referenceNum) {
        try {
            int result = referenceNumDAO.updateReferenceNum(referenceNum);

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

    public void deleteReferenceNum(ReferenceNumTO referenceNum) {
        try {
            int result = referenceNumDAO.deleteReferenceNum(referenceNum);
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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generateReferenceNum(String refKey){
    	String refId = ConfigProperties.getInstance().getPropertyAsString(IAppsConstants.SAAS_CONFIG, 
    			refKey, "");
    	refId = refId.trim();
    	
    	String s=null;
    	try{
    		s=referenceNumDAO.generateReferenceNum(refId);
    	 }catch(DaoRunTimeException e){
    		 if (e.getWrappedException() instanceof ConcurrentUpdateException) {
                s=generateReferenceNum(refKey);
             } else {
                  throw new SCServiceException(e);
             }
    	 }
    	 return s;
    }

    public ReferenceNumTO getReferenceNum(ReferenceNumTO referenceNum) {
        return referenceNumDAO.getReferenceNum(referenceNum);
    }

    public List<ReferenceNumTO> getReferenceNumList(ReferenceNumTO referenceNum) {
        return referenceNumDAO.getReferenceNumList(referenceNum);
    }

    public List<ReferenceNumTO> searchReferenceNumList(ReferenceNumTO referenceNum) {
        return referenceNumDAO.searchReferenceNumList(referenceNum);
    }

    public void setReferenceNumDAO(ReferenceNumDAO referenceNumDAO) {
        this.referenceNumDAO = referenceNumDAO;
    }

    public ReferenceNumDAO getReferenceNumDAO() {
        return referenceNumDAO;
    }
}