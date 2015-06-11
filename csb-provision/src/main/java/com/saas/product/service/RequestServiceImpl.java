/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.RequestServiceImpl
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
package com.saas.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.DaoRunTimeException;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.product.dao.RequestDAO;
import com.saas.product.to.RequestTO;

public class RequestServiceImpl extends SCBaseDAOImpl implements RequestService {

	private RequestDAO requestDAO;

	public void createRequest(RequestTO request) {
		requestDAO.createRequest(request);
	}

	public void updateRequest(RequestTO request) {
		try {
			int result = requestDAO.updateRequest(request);

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

	public void deleteRequest(RequestTO request) {
		try {
			int result = requestDAO.deleteRequest(request);
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

	public RequestTO getRequest(RequestTO request) {
		return requestDAO.getRequest(request);
	}

	public List<RequestTO> getRequestList(RequestTO request) {
		Map<String, Object> paraMap = new HashMap<String, Object>();

		return requestDAO.getRequestList(request);
	}

	public List<RequestTO> searchRequestList(RequestTO request) {
		return requestDAO.searchRequestList(request);
	}

	public List<RequestTO> getRequestListByDomainId(String domainId,
			RequestTO request) {
		return requestDAO.getRequestListByDomainId(domainId, request);
	}

	public List<RequestTO> searchRequestListByDomainId(
			String domainId, RequestTO request) {
		return requestDAO.searchRequestListByDomainId(domainId, request);
	}

	public void updateRequestStatus(RequestTO request) {
		try {
			int result = requestDAO.updateRequestStatus(request);
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
	
	public RequestTO getTenantByDomainId(String domainId) {
		return requestDAO.getTenantByDomainId(domainId);
	}

	public RequestTO getRequestByRequestId(String requestId) {
		return requestDAO.getRequestByRequestId(requestId);
	}

	public void setRequestDAO(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}

	public RequestDAO getRequestDAO() {
		return requestDAO;
	}

}