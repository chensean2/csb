/*
 * =========================================================================
 *  Program Name: com.saas.provision.service.DeleteUserAdaptorServiceImpl
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

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.csb.common.ConfigProperties;
import com.csb.common.IAppsConstants;

import org.slf4j.*;

import com.saas.product.service.Service;
import com.saas.product.to.ServiceTO;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.IsvConstants;
import com.saas.provision.service.UserInfoTO;
import com.saas.webservices.CommonIsvHelper;
import com.saas.webservices.data.RequestObject;
import com.saas.webservices.data.ResponseObject;
import com.saas.webservices.data.ResponseResult;
import com.saas.webservices.util.IsvXmlParser;

public class DeleteUserAdaptorServiceImpl extends BaseAdaptor implements AdaptorService {
    private static Logger log = LoggerFactory.getLogger(DeleteUserAdaptorServiceImpl.class);
    private ConfigProperties config = ConfigProperties.getInstance();
    private Service service;
    public Map<String, Object> execute(Map<String, String> paraMap, Map<String, String> serviceMap) {
        String isvService = serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID);
        String returnCode = IsvConstants.ISV_ADAP_SUCCESS;
        Map<String, Object> responseMap = new HashMap<String, Object>();
        try {
            UserInfoTO userInfoTO = getUserInfo(isvService);
            ServiceTO serviceTO = new ServiceTO();
            serviceTO.setServiceId(userInfoTO.getServiceId());
            serviceTO = service.getService(serviceTO);
            String requestUrl = serviceTO.getServiceProvisionUrl();
            String saasId = userInfoTO.getSaasId();
            String loginId = userInfoTO.getLoginId();
            String requestStr = null;
            String returnMessage = "";
            ResponseObject responseObject = null;
            String errorLog = "";
            RequestObject reqObject = new RequestObject("", "", "", "", "", new Date(), "");
            reqObject.addRequestEntities(CommonIsvHelper.generateUserDelete(saasId, loginId));
            requestStr = IsvXmlParser.createRequest(reqObject);
            HttpClient httpclient = new HttpClient();
            String proxyEnable = ConfigProperties.getInstance().getPropertyAsString(IAppsConstants.SAAS_CONFIG,
                    IAppsConstants.PROVISION_COMMON_PROXY_ENABLE, "false");
            if ("true".equalsIgnoreCase(proxyEnable)) {
                httpclient.getHostConfiguration().setProxy(
                        getPropertyAsString(IAppsConstants.PROVISION_COMMON_PROXY_HOST),
                        getPropertyAsInt(IAppsConstants.PROVISION_COMMON_PROXY_PORT));
            }
            PostMethod httpPost = new PostMethod(requestUrl);
            paraMap.put(IAppsConstants.PROVISION_COMMON_PARAM, requestStr);
            NameValuePair[] requestData = prepareRequestData(paraMap);
            String reqestContent = getRequestContent(requestUrl, requestData);
            errorLog = errorLog + reqestContent;
            httpPost.setRequestBody(requestData);
            int statusCode = httpclient.executeMethod(httpPost);
            returnMessage = httpPost.getResponseBodyAsString();
            httpPost.releaseConnection();
            if (statusCode == 200) {
                if (!returnMessage.isEmpty()) {
                    responseObject = IsvXmlParser.parseResponse(returnMessage);
                    List<ResponseResult> responseList = responseObject.getResponseResults();
                    if (null != responseList && responseList.size() > 0) {
                        for (ResponseResult result : responseList) {
                            if (IsvConstants.ISV_RETURN_CODE_PS_0000.equalsIgnoreCase(result.getReturnCode())) {
                                Map<String, String> itemsMap = result.getItemsMap();
                                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, itemsMap.get(com.saas.webservices.config.IsvConstants.USER_ITEM_USERID));
                                updateUserUnAssignStatus(isvService, IAppsConstants.PROVISION_REQUEST_PROVISION_SUCCESS);
                            } else {
                                returnCode = IsvConstants.ISV_ADAP_ERROR;
                            }
                        }
                    }
                } else {
                    returnCode = IsvConstants.ISV_ADAP_ERROR;
                }

            } else {
                returnCode = IsvConstants.ISV_ADAP_ERROR;
                log.error("[Saasconnect] QKSupportAdaptorServiceImpl receive https response exception: "
                        + httpPost.getResponseBodyAsString());
            }

        } catch (Exception e) {
            returnCode = IsvConstants.ISV_ADAP_ERROR;
            log.error("[SaaSconnect] Error occured when delete user by common adapter", e);
        }
        if (!IsvConstants.ISV_ADAP_SUCCESS.equalsIgnoreCase(returnCode)) {
            updateUserUnAssignStatus(isvService, IAppsConstants.PROVISION_REQUEST_PROVISION_FAILED);
        }
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, returnCode);
        return responseMap;
    }

    /**
     * this method is used to get property from file
     * 
     * @param key
     * @return
     */
    private String getPropertyAsString(String key) {
        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Get property from file with the key: " + key);
        }

        String result = config.getPropertyAsString(IAppsConstants.SAAS_CONFIG, key, "");

        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Get property from file, return value: " + result);
        }

        return result;
    }

    /**
     * this method is used to get property from file
     * 
     * @param key
     * @return
     */
    private int getPropertyAsInt(String key) {
        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Get property from file with the key: " + key);
        }

        int result = config.getPropertyAsInt(IAppsConstants.SAAS_CONFIG, key, 0);

        if (log.isInfoEnabled()) {
            log.info("[SaaSConnect] Get property from file, return value: " + result);
        }

        return result;
    }

    private NameValuePair[] prepareRequestData(Map<String, String> paraMap) {
        if (paraMap != null) {
            NameValuePair[] data = new NameValuePair[paraMap.entrySet().size()];
            Iterator<String> paramKeys = paraMap.keySet().iterator();
            String paramKey = null;
            String paramValue = null;
            for (int i = 0; paramKeys.hasNext(); i++) {
                paramKey = paramKeys.next();
                paramValue = paraMap.get(paramKey);
                data[i] = new NameValuePair(paramKey, paramValue);
            }

            return data;
        }
        return null;
    }

    private String getRequestContent(String requestUrl, NameValuePair[] data) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            if (data[i].getValue() != null && !"".equals(data[i].getValue())) {
                stringBuffer.append(data[i].getName()).append("=")
                        .append(java.net.URLEncoder.encode(data[i].getValue(), "utf-8"));
            } else {
                stringBuffer.append(data[i].getName()).append("=").append("");
            }

            if (i < data.length - 1) {
                stringBuffer.append("&");
            }
        }
        return requestUrl + "?" + stringBuffer.toString();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
