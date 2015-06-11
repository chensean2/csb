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
package com.saas.provision.service.oda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.csb.common.ConfigProperties;
import com.csb.common.IAppsConstants;
import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.ValidateAdaptorService;

/**
 * This class is a adapter for provision framework to create user in SEM.
 * 
 */
public class ValidateProvisionAdaptorServiceImpl extends BaseAdaptor implements ValidateAdaptorService {
    private static Logger log = LoggerFactory.getLogger(ValidateProvisionAdaptorServiceImpl.class);

    public String[] execute(Map<String, String> sysParamMap, String[] paramArray) {
        if (log.isDebugEnabled()) {
            log.debug("\n ODA ValidateProvisionAdaptorServiceImpl.execute");
        }
        List<String> resultList = new ArrayList<String>();
        ConfigProperties config = ConfigProperties.getInstance();
        String mandatoryMsg = config.getPropertyAsString(IAppsConstants.SAAS_PROVISION, IAppsConstants.ERROR_MANDATORY, "");

        if (null == paramArray || paramArray.length == 0) {
            resultList.add(IAppsConstants.ERROR_SYSTEM);
        } else {
            for (int i = 0; i < paramArray.length; i++) {
                if (StringUtils.isEmpty(paramArray[i])) {
                    switch (i) {
                    case 0:
                        resultList.add(mandatoryMsg.replace("{0}", IAppsConstants.SERVICE_FIELD_PRODUCT_NAME));
                        break;
                    case 1:
                        resultList.add(mandatoryMsg.replace("{0}", IAppsConstants.SERVICE_FIELD_URL));
                        break;
                    case 2:
                        resultList.add(mandatoryMsg.replace("{0}", IAppsConstants.SERVICE_FIELD_CUSTOMER_ID));
                        break;
                    case 3:
                        resultList.add(mandatoryMsg.replace("{0}", IAppsConstants.SERVICE_FIELD_BILLING_ACCOUNT));
                        break;
                    default:
                        break;
                    }
                }

            }
        }

        String[] errorArray = null;
        if (resultList.size() > 0) {
            errorArray = new String[4];
            resultList.toArray(errorArray);
            return errorArray;
        }

        return errorArray;
    }

    public String getReferenceId(Map<String, String> sysParamMap, String[] paramArray) {
        // paramArray -> referenceID
        //
        return null;
    }
}
