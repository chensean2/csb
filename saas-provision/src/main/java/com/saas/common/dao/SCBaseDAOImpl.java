/*
 * =========================================================================
 *  Program Name:com.saas.common.dao.SCBaseDAOImpl
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
 * ----------------------------------------------------------------------------
 *  Version    Remarks	              Author	    Editor          Date
 *  v1.0       - Initial Release	  zhujun	                    23/11/2009
 * =====================================================================================
 */

package com.saas.common.dao;

import com.saas.common.to.SCBaseTO;

public class SCBaseDAOImpl implements SCBaseDAO {


    /**
     * Insert object to database
     * 
     * @param scBaseTO
     *                Object to insert into database
     * @return Number of records affected
     */

	public int create(SCBaseTO scBaseTO) {
//		IUserSessionInfo usi = USIEnabler.currentUSI();
//		Timestamp now = new Timestamp(Calendar.getInstance().getTimeInMillis());
//
//		if (usi != null) {
//			scBaseTO.setCreatedBy(usi.getSubjectId());
//			scBaseTO.setLastUpdatedBy(usi.getSubjectId());
//		} else {
//			if(scBaseTO.getCreatedBy() == null || scBaseTO.getCreatedBy().isEmpty()){
//				scBaseTO.setCreatedBy("SYSTEM");
//			}
//			if(scBaseTO.getLastUpdatedBy() == null || scBaseTO.getLastUpdatedBy().isEmpty()){
//				scBaseTO.setLastUpdatedBy("SYSTEM");
//			}
//		}
//		if(scBaseTO.getCreatedDt() == null){
//		    scBaseTO.setCreatedDt(now);
//		}
//		scBaseTO.setLastUpdatedDt(now);
//
//		return pfwClient.insert(scBaseTO);
		return 0;
	}

    /**
     * update record
     * 
     * @param scBaseTO
     * @return
     */
    public int update(SCBaseTO scBaseTO) {
//        IUserSessionInfo usi = USIEnabler.currentUSI();
//		if (usi != null) {
//			scBaseTO.setLastUpdatedBy(usi.getSubjectId());
//		} else {
//			if(scBaseTO.getLastUpdatedBy() == null || scBaseTO.getLastUpdatedBy().isEmpty()){
//				scBaseTO.setLastUpdatedBy("SYSTEM");
//			}
//		}
//
//        scBaseTO.setLastUpdatedDt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        return pfwClient.update(scBaseTO);
    	return 0;
    }

    /**
     * This method only update records of Not-Null values
     */
    public int updatePartially(SCBaseTO scBaseTO) {
//        IUserSessionInfo usi = USIEnabler.currentUSI();
//        if (usi != null) {
//            scBaseTO.setLastUpdatedBy(usi.getSubjectId());
//        } else {
//        	if(scBaseTO.getLastUpdatedBy() == null || scBaseTO.getLastUpdatedBy().isEmpty()){
//        		scBaseTO.setLastUpdatedBy("SYSTEM");
//        	}
//        }
//
//        scBaseTO.setLastUpdatedDt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        return pfwClient.updatePartially(scBaseTO);
    	return 0;
    }

    /**
     * delete record
     * 
     * @param scBaseTO
     * @return
     */
    public int delete(SCBaseTO scBaseTO) {
//        return pfwClient.delete(scBaseTO);
        return 0;
    }

    /**
     * query record
     * 
     * @param scBaseTO
     * @return
     */
    public SCBaseTO queryForObject(SCBaseTO scBaseTO) {
//        return (SCBaseTO) pfwClient.queryForObject(scBaseTO);
    	return null;
    }
    
    /**
     * Create history record refer its original record before being updated.
     * 
     * @param transactionId
	 *            The transactionId 
     * @param destHistorySCBaseTO
     * @param oriSCBaseTO
     * @return
     */
	public int createHistory(String transactionId, SCBaseTO destHistorySCBaseTO, SCBaseTO oriSCBaseTO) {
//		try {
//			PropertyUtils.copyProperties(destHistorySCBaseTO, oriSCBaseTO);
//			PropertyUtils.setProperty(destHistorySCBaseTO, "historyId", SequenceUUID.getInstance().getUUID());
//			PropertyUtils.setProperty(destHistorySCBaseTO, "transactionId", transactionId);
//			
//			return create(destHistorySCBaseTO);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new DaoRunTimeException(e);
//		}
		return 0;
	}
}
