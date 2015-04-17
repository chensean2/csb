package com.saas.provision.service.oda;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.saas.common.IAppsConstants;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.CustomerInfoTO;
import com.saas.provision.service.IsvConstants;

public class UpdateServiceAdaptorServiceImpl extends BaseAdaptor implements AdaptorService {
    private static Logger log = LoggerFactory.getLogger(UpdateServiceAdaptorServiceImpl.class);
    public Map<String, Object> execute(Map<String, String> paraMap, Map<String,String> serviceMap) { Map<String, Object> responseMap = new HashMap<String, Object>();
    String productName = paraMap.get(IAppsConstants.PARA_MAP_PRODUCT_NAME);
    String customerId = paraMap.get(IAppsConstants.PARA_MAP_CUSTOMER_ID);
    String url = paraMap.get(IAppsConstants.PARA_MAP_URL);
    String billingAccount = paraMap.get(IAppsConstants.PARA_MAP_BILLING_ACCOUNT);
    
    String isvService = serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID);
    CustomerInfoTO custInfo = provisionService.getCustomerInfo(isvService);
    updateProductOrderStatus(serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID),
            IAppsConstants.PACKAGE_ORDER_STATUS_SUCCESS);
    responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, IsvConstants.ISV_ADAP_SUCCESS);
    responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG,
    custInfo.getSaasId() + IAppsConstants.SERVICE_PARA_SEPERATER + productName
                    + IAppsConstants.SERVICE_PARA_SEPERATER + url + IAppsConstants.SERVICE_PARA_SEPERATER + customerId + IAppsConstants.SERVICE_PARA_SEPERATER + billingAccount);
    return responseMap;}
}
