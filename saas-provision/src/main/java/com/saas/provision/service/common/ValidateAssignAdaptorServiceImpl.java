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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.ValidateAdaptorService;

/**
 * This class is a adapter for provision framework to create user in Google.
 * 
 */
public class ValidateAssignAdaptorServiceImpl extends BaseAdaptor implements ValidateAdaptorService {
    private static Logger log = LoggerFactory.getLogger(ValidateAssignAdaptorServiceImpl.class);

    public String[] execute(Map<String, String> sysParamMap, String[] paramArray) {
        if (log.isDebugEnabled()) {
            log.debug("\n ValidateAssignAdaptorServiceImpl.execute");
        }

        List<String> resultList = new ArrayList<String>();

//        ConfigProperties config = ConfigProperties.getInstance();
//        String errorDesc = config.getPropertyAsString(IsvGoogleConstants.SAAS_CONFIG,
//                IsvGoogleConstants.ERROR_MANDATORY, "").replace("{0}",
//                IsvGoogleConstants.SERVICE_PARA_NAME_UI_USER_NAME);
//        if (null == paramArray || paramArray.length == 0) {
//            resultList.add(IAppsConstants.ERROR_SYSTEM);
//        } else {
//            for (String parameter : paramArray) {
//                // TODO
//                if (StringUtils.isEmpty(parameter)) {
//                    resultList.add(errorDesc);
//                } else if (parameter.contains("@")) {
//                    resultList.add(config.getPropertyAsString(IsvGoogleConstants.SAAS_CONFIG,
//                            IsvGoogleConstants.ERROR_VALIDATION_USERNAME_FORMAT, ""));
//                }
//            }
//        }
//
//        if (resultList.size() > 0) {
//            return resultList.toArray(new String[0]);
//        }
        return null;
    }

    public String getReferenceId(Map<String, String> sysParamMap, String[] paramArray) {
        String referenceId = "";

        // TODO
        if (null == paramArray || paramArray.length == 0) {
            referenceId = "no";
        } else {
            referenceId = paramArray[0];
        }

        if (log.isDebugEnabled()) {
            log.debug("[SaaSConnect] get the reference id: " + referenceId);
        }

        return referenceId;
    }
}
