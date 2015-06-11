/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.RequestDAOImpl
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
 * v1.0     - Initial Release         jixiaowei                   Mar 4, 2011
 * =====================================================================================
 */
package com.saas.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.product.to.RequestTO;

public class RequestDAOImpl extends SCBaseDAOImpl implements RequestDAO {
    private Logger log = LoggerFactory.getLogger(RequestDAOImpl.class);

    
    public int createRequest(RequestTO request) {
        int i = create(request);
        
        return i;
    }

    public int deleteRequest(RequestTO request) {
        RequestTO requestTO = this.getRequest(request);
        
        if (null == requestTO) {
            throw new SCServiceException(IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
        }
        
        int i = delete(request);
        
        return i;
    }

    public int updateRequest(RequestTO request) {
        RequestTO oldrequestTO = this.getRequest(request);
        int i = update(request);

       
        return i;
    }

    public RequestTO getRequest(RequestTO request) {
        return (RequestTO) queryForObject(request);
    }

    public List<RequestTO> getRequestList(RequestTO request) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
return null;
//        return pfwClient.queryForList(RequestTO.class, "/request/getRequestList", paraMap);
    }

    public List<RequestTO> searchRequestList(RequestTO request) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(RequestTO.class, pfwClient, "/request/getRequestList", paraMap);
    }

	public List<RequestTO> getRequestListByDomainId(String domainId, RequestTO request) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("domainId", domainId);
		paraMap.put("companyName", request == null? null : request.getTenantName());
		paraMap.put("companyBillingId", request == null? null : request.getSaasId());
		paraMap.put("requestStatus", request == null? null : request.getRequestStatus());
		paraMap.put("requestStartDate", request == null? null : request.getRequestStartDate());
		paraMap.put("requestEndDate", request == null? null : request.getRequestEndDate());
		return null;
//		return pfwClient.queryForList(RequestTO.class, "/request/getRequestListByDomainId", paraMap);
	}

	public List<RequestTO> searchRequestListByDomainId(
			String domainId, RequestTO request) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("domainId", domainId);
		paraMap.put("companyName", request == null? null : request.getTenantName());
		paraMap.put("companyBillingId", request == null? null : request.getSaasId());
		paraMap.put("requestStatus", request == null? null : request.getRequestStatus());
		paraMap.put("requestStartDate", request == null? null : request.getRequestStartDate());
		paraMap.put("requestEndDate", request == null? null : request.getRequestEndDate());
		return null;
//		return PaginationEnabler.queryForList(RequestTO.class, pfwClient, "/request/getRequestListByDomainId", paraMap);
	}

	public int updateRequestStatus(RequestTO request) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("requestId", request.getRequestId());
		paraMap.put("requestStatus", request.getRequestStatus());
		paraMap.put("requestCurrentFollowedBy", request.getRequestCurrentFollowedBy());
		paraMap.put("requestCurrentFollowedDt", request.getRequestCurrentFollowedDt());
		paraMap.put("requestLastFollowedBy", request.getRequestLastFollowedBy());
		paraMap.put("requestLastFollowedDt", request.getRequestLastFollowedDt());
		paraMap.put("requestProvisionRemarks", request.getRequestProvisionRemarks());
		
//		List<RequestTO> list = this.pfwClient.queryForList(RequestTO.class,
//	                "/request/queryRequestStatus", paraMap);

//		int value =  ((Integer)this.pfwClient.executeMapSQL("/request/updateRequestStatus", paraMap)).intValue();
//	        for (int i = 0; i < list.size(); i++) {
//	            RequestTO requestTONewValue = this.getRequest(list.get(i));
//	            XStream xstream = new XStream();
//	            String requestOrderNewValue = xstream.toXML(requestTONewValue);
//	            String requestOrderOldValue = xstream.toXML(list.get(i));
//	            try {
//	                auditTrailService.createAuditTrail("UPDATE_REQUEST", requestTONewValue.getRequestId(),
//	                        "TBL_SS_REQUEST", "UPDATE", requestTONewValue.getLastUpdatedBy(),
//	                        requestOrderOldValue, requestOrderNewValue);
//	            } catch (Exception e) {
//	                log.error("auditTrail for update request failed", e);
//	                log.error("UPDATE_REQUEST-New Value" + requestOrderNewValue);
//	                log.error("UPDATE_REQUEST-Old Value" + requestOrderOldValue);
//	            }
//	        }

	        return 0;
		
	}

	public RequestTO getRequestByRequestId(String requestId) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("requestId", requestId);
		
//		RequestTO requestTO = (RequestTO)pfwClient.queryForList(RequestTO.class, "/request/getRequestByRequestId", paraMap).get(0);
		return null;
//		return requestTO;
	}

	public RequestTO getTenantByDomainId(String domainId) {
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("domainId", domainId);
//		
//		RequestTO requestTO = (RequestTO)pfwClient.queryForList(RequestTO.class, "/request/getTenantByDomainId", paraMap).get(0);
//		
//		return requestTO;
		return null;
	}

}