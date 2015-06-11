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
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.IsvConstants;
import com.saas.provision.to.ServiceResTO;

/**
 * This class is a adapter for provision framework to create user in Google.
 * 
 */
public class DataTransferServiceAdaptorServiceImpl extends BaseAdaptor implements AdaptorService {
    private static Logger log = LoggerFactory.getLogger(DataTransferServiceAdaptorServiceImpl.class);

    public Map<String, Object> execute(Map<String, String> paraMap, Map<String, String> serviceMap) {
        String isvService = serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID);
        if (log.isInfoEnabled()) {
            log.info("[Saasconnect] Google - Service Data Transfer Start : " + isvService);
        }

        String RefId = "";
        String RefKey = "";
        String[] googleResponse;
        try {
            if (log.isInfoEnabled()) {
                log.info("[Saasconnect] Google - Service Data Transfer - Get Response : " + isvService);
            }
            List<ServiceResTO> isvServiceRes = provisionService.getServiceResList(isvService);
           // googleResponse = isvServiceRes.get(0).getProvResMessage().split(IsvGoogleConstants.SERVICE_PARA_SEPERATER);
           // RefId = googleResponse[0];
           // RefKey = "<b>Common Name: </b>" + googleResponse[0];
            String tempstr = "";
//            for (int i = 1 ; i < googleResponse.length; i ++)
//            {
//                if (i == 1) {
//                    tempstr = "<b>Common Type: </b>";
//                } else if (i == 2) {
//                    tempstr = "<b>CName: </b>";
//                } else {
//                    tempstr = "";
//                }   
//                //RefKey += IsvGoogleConstants.SERVICE_KEY_SEPERATER + tempstr + googleResponse[i];
//            }
            if (log.isInfoEnabled()) {
                log.info("[Saasconnect] Google - Service Data Transfer - Response : " + isvService + " Reference ID : "
                        + RefId + " Reference Key : " + RefKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put(IsvConstants.ISV_DOMAIN_SERVICE_REF_ID, RefId);
        responseMap.put(IsvConstants.ISV_DOMAIN_SERVICE_REF_KEY, RefKey);
        if (log.isInfoEnabled()) {
            log.info("[Saasconnect] Google - Service Data Transfer End : " + isvService);
        }
        return responseMap;
    }

}