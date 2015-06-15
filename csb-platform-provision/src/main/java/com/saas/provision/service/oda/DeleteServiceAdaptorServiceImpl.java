/*
 * =========================================================================
 *  Program Name: com.saas.provision.service.DeleteServiceAdaptorServiceImpl
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
 * -------------------------------------------------------------------------
 *  Version    Remarks
 *  v1.0       - Initial Release
 * =========================================================================
 */
package com.saas.provision.service.oda;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.saas.provision.service.DeleteAdaptor;
import com.saas.provision.service.IsvConstants;

public class DeleteServiceAdaptorServiceImpl extends DeleteAdaptor {
    private static Logger log = LoggerFactory.getLogger(DeleteServiceAdaptorServiceImpl.class);
    public Map<String, Object> executeProductLogic(Map<String, String> paraMap, Map<String, String> serviceMap) {
        String isvService = serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID);
        String returnCode = IsvConstants.ISV_ADAP_SUCCESS;
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, IAppsConstants.PROVISION_REQUEST_PROVISION_SUCCESS_MSG);
        updateProductOrderStatus(isvService, IAppsConstants.PACKAGE_ORDER_STATUS_SUCCESS);
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, returnCode);
        return responseMap;
    }
}
