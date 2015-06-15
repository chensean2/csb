/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.RequestService
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
 * v1.0     - Initial Release         jixiaowei                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.product.service;

import java.util.List;

import com.saas.product.to.RequestTO;

public interface RequestService {

    /**
     * this method is used to create Request
     * version: 1.3.0
     */
    public void createRequest(RequestTO request);

    /**
     * this method is used to update Request
     * version: 1.3.0
     */
    public void updateRequest(RequestTO request);

    /**
     * this method is used to delete Request
     * version: 1.3.0
     */
    public void deleteRequest(RequestTO request);

    /**
     * this method is used to search Request
     * version: 1.3.0
     */
    public RequestTO getRequest(RequestTO request);

    /**
     * this method is used to get Request List
     * version: 1.3.0
     */
    public List<RequestTO> getRequestList(RequestTO request);

    /**
     * this method is used to search Request
     * version: 1.3.0
     */
    public List<RequestTO> searchRequestList(RequestTO request);
    
    /**
     * this method is used to get Request List by domainId
     * version: 1.3.0
     * @param request
     * @return
     */
    public List<RequestTO> getRequestListByDomainId(String domainId, RequestTO request);

    /**
     * this method is used to search Request by domainId
     * version: 1.3.0
     * @param request
     * @return
     */
    public List<RequestTO> searchRequestListByDomainId(String domainId, RequestTO request); 
    
    /**
     * this method is used to update Request Status
     * version: 1.3.0
     * @param request
     */
    public void updateRequestStatus(RequestTO request);
    
    /**
     * this method is used to search Request by requestId
     * version: 1.3.0
     * @param requestId
     * @return
     */
    public RequestTO getRequestByRequestId(String requestId);
    
    /**
     * this method is used to search Request by domainId
     * @param requestId
     * @return
     */
    public RequestTO getTenantByDomainId(String domainId);

}