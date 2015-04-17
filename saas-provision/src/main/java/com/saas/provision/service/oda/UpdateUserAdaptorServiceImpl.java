package com.saas.provision.service.oda;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saas.common.IAppsConstants;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.IsvConstants;

public class UpdateUserAdaptorServiceImpl extends BaseAdaptor implements AdaptorService {
    private static Logger log = LoggerFactory.getLogger(UpdateUserAdaptorServiceImpl.class);
    public Map<String, Object> execute(Map<String, String> paraMap, Map<String,String> serviceMap) {
        String isvService = serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID);
        Map<String, Object> responseMap = new HashMap<String, Object>();
        String returnCode =  IsvConstants.ISV_ADAP_SUCCESS;
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, "");
        updateUserAssignStatus(isvService, IAppsConstants.PROVISION_REQUEST_PROVISION_SUCCESS);
        //updateUserRefIdAndKey(isvService, itemsMap.get(com.saas.webservices.config.IsvConstants.USER_ITEM_USERID), itemsMap.get(com.saas.webservices.config.IsvConstants.USER_ITEM_USERID));
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, returnCode);
        return responseMap;
    }
}
