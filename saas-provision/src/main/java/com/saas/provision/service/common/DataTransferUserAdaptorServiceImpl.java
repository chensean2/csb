/*
 * =========================================================================
 *  Program Name: com.saas.provision.service.GoogleCreateUserAdaptorServiceImpl
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
package com.saas.provision.service.common;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.*;
import com.saas.common.IAppsConstants;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.ProvisionService;

/**
 * This class is a adapter for provision framework to create user in Google.
 * 
 */
public class DataTransferUserAdaptorServiceImpl extends BaseAdaptor implements AdaptorService {
    private static Logger log = LoggerFactory.getLogger(DataTransferUserAdaptorServiceImpl.class);

    public Map<String, Object> execute(Map<String, String> paraMap, Map<String,String> serviceMap) {
        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, IAppsConstants.PROVISION_REQUEST_PROVISION_SUCCESS);
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG,
                IAppsConstants.PROVISION_REQUEST_PROVISION_SUCCESS_MSG);
        return responseMap;
    }

}
