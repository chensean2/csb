/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.RequestDAO
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
package com.saas.product.dao;

import java.util.List;

import com.saas.product.to.RequestTO;

public interface RequestDAO {

    public int createRequest(RequestTO request);

    public int updateRequest(RequestTO request);

    public int deleteRequest(RequestTO request);

    public RequestTO getRequest(RequestTO request);

    public List<RequestTO> getRequestList(RequestTO request);

    public List<RequestTO> searchRequestList(RequestTO request);
    
    public List<RequestTO> getRequestListByDomainId(String domainId, RequestTO request);

    public List<RequestTO> searchRequestListByDomainId(String domainId, RequestTO request);
    
    public int updateRequestStatus(RequestTO request);
    
    public RequestTO getRequestByRequestId(String requestId);
    
    public RequestTO getTenantByDomainId(String domainId);

}