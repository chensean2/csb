/*
 *  =========================================================================
 * Program Name: package com.saas.common.dao.ReferenceNumDAOImpl
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
package com.csb.common.dao;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;

import com.csb.common.ConcurrentUpdateException;
import com.saas.common.to.ReferenceNumTO;

public class ReferenceNumDAOImpl extends SCBaseDAOImpl implements ReferenceNumDAO {
    public int createReferenceNum(ReferenceNumTO referenceNum) {
        return create(referenceNum);
    }

    public int deleteReferenceNum(ReferenceNumTO referenceNum) {
        return delete(referenceNum);
    }

    public int updateReferenceNum(ReferenceNumTO referenceNum) {
        return update(referenceNum);
    }

    public ReferenceNumTO getReferenceNum(ReferenceNumTO referenceNum) {
        return (ReferenceNumTO) queryForObject(referenceNum);
    }

    public List<ReferenceNumTO> getReferenceNumList(ReferenceNumTO referenceNum) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
return null;
//        return pfwClient.queryForList(ReferenceNumTO.class, "/referenceNum/getReferenceNumList", paraMap);
    }

    public List<ReferenceNumTO> searchReferenceNumList(ReferenceNumTO referenceNum) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(ReferenceNumTO.class, pfwClient, "/referenceNum/getReferenceNumList", paraMap);
    }


	public String generateReferenceNum(String refId) {
		String referenceNum=null;
    	ReferenceNumTO to =new ReferenceNumTO();
    	if(null==refId){
    		return referenceNum;
    	}else{
//    		to.setRefID(refId);
//    		to=(ReferenceNumTO)pfwClient.queryForObject(to);
    		Map<String,Object> map=new HashMap<String,Object>();
    		map.put("id", refId);
//    		List<ReferenceNumTO> list=pfwClient.queryForList(ReferenceNumTO.class,"/referenceNum/getReferenceNumById", map);
//    		if(null!=list&&list.size()>0){
//    			to=list.get(0);
//    		}else{
//    			to=null;
//    		}
    	}
    	if(null==to){
    		return referenceNum;
    	}
    	String refIndexFormat ="";
    	for(int i=0;i<to.getRefNumDigit();i++){
    		refIndexFormat=refIndexFormat+0;
    	}
    	String refSeprator=to.getRefSeperator();//ref_seperator
    	if(null==refSeprator){
    		refSeprator="";
    	}
    	String refPre=to.getRefPre();//ref_pre
    	if(null==refPre){
    		refPre="";
    	}else{
    		refPre=refPre+refSeprator;
    	}
    	String format=to.getRefDateFormat().trim();
    	String refDate=null;//ref_date
    	if(null==format||"".equals(format)){
    		refDate="";
    	}else{
    		refDate=DateFormatUtils.format(new Date(), format)+refSeprator;
    	}
    	Integer refIndex=to.getRefIndexCurrent();
//    	String refIndexCurrent=new DecimalFormat(refIndexFormat).format(refIndex); //ref_index_current
//    	referenceNum=refPre+refDate+refIndexCurrent;
//    	refIndex++;
//    	if(refIndex>to.getRefIndexEnd()){
//    		refIndex=to.getRefIndexStart();
//    	}
    	Integer day=Integer.parseInt(DateFormatUtils.format(new Date(), "dd"));
    	Integer month=Integer.parseInt(DateFormatUtils.format(new Date(), "MM"));
    	Integer year=Integer.parseInt(DateFormatUtils.format(new Date(), "yyyy"));
    	Integer day1=Integer.parseInt(DateFormatUtils.format(to.getRefUpdatedDt(), "dd"));
    	Integer month1=Integer.parseInt(DateFormatUtils.format(to.getRefUpdatedDt(), "MM"));
    	Integer year1=Integer.parseInt(DateFormatUtils.format(to.getRefUpdatedDt(), "yyyy"));
    	String refRest=to.getRefReset().trim();
    	if("DAY".equalsIgnoreCase(refRest)){
    		if(day>day1){
    			refIndex=to.getRefIndexStart();
    		}
    		
    	}else if("MONTH".equalsIgnoreCase(refRest)){
    		if(month>month1){
    			refIndex=to.getRefIndexStart();
    		}
    		
    	}else if("YEAR".equalsIgnoreCase(refRest)){
    		if(year>year1){
    			refIndex=to.getRefIndexStart();
    		}
    	}
        String refIndexCurrent=new DecimalFormat(refIndexFormat).format(refIndex);
        referenceNum=refPre+refDate+refIndexCurrent;
        refIndex++;
        if(refIndex>to.getRefIndexEnd()){
                refIndex=to.getRefIndexStart();
        }
    	to.setRefIndexCurrent(refIndex);
    	//to.setRefUpdatedDt(DateFormatter.dateToTimestamp(new Date()));
    	int n=updateReferenceNum(to);
    	if(0==n){
    		throw new ConcurrentUpdateException();
    	}
    	return referenceNum;
	}

}