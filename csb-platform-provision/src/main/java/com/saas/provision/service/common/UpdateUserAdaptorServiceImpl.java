package com.saas.provision.service.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.saas.provision.service.AdaptorService;
import com.saas.provision.service.BaseAdaptor;
import com.saas.webservices.CommonIsvHelper;
import com.saas.webservices.data.RequestObject;
import com.saas.webservices.data.ResponseObject;
import com.saas.webservices.data.ResponseResult;
import com.saas.webservices.util.IsvXmlParser;

public class UpdateUserAdaptorServiceImpl extends BaseAdaptor implements AdaptorService {
	private static String SERVICE_PARA_NAME_SAASID = "saasId";
	private static String SERVICE_PARA_NAME_CUSTNAME = "custName";
	private static String SERVICE_PARA_NAME_CUSTDOMAIN = "custDomain";
	private static String SERVICE_PARA_NAME_PRODID = "prodId";
	private static String SERVICE_PARA_NAME_QTY = "qty";
	private static String SERVICE_PARA_NAME_TRIALIND = "trialInd";
	private static String SERVICE_PARA_USER_ID="userId";
	private static String SERVICE_PARA_USER_PWD="password";
	private static String SERVICE_PARA_APPLICATION="application";
	private static String SERVICE_PARA_ENV="environment";
	private static String SERVICE_PARA_ADAPTOR_VERSION="version";
	private static String SERVICE_PARA_REQUEST_NO="requestNo";
	private static String SERVICE_PARA_FIRST_NAME="firstName";
	private static String SERVICE_PARA_LAST_NAME="lastName";
	private static String SERVICE_PARA_EMAIL="email";
	private static String SERVICE_PARA_ADMIN="admin";
	private static String SERVICE_PARA_ACTIVE="active";
    private static Logger log = LoggerFactory.getLogger(UpdateUserAdaptorServiceImpl.class);

    public Map<String, Object> execute(Map<String, String> paraMap, Map<String,String> serviceMap) {
		 String userId=paraMap.get(SERVICE_PARA_USER_ID);
		 String password=paraMap.get(SERVICE_PARA_USER_PWD);
		 String application=paraMap.get(SERVICE_PARA_APPLICATION);
		 String env=paraMap.get(SERVICE_PARA_ENV);
         String adaptVersion=paraMap.get(SERVICE_PARA_ADAPTOR_VERSION);
         String requestNo=paraMap.get(SERVICE_PARA_REQUEST_NO);
		 String saasId=paraMap.get(SERVICE_PARA_NAME_SAASID);
		 String custName=paraMap.get(SERVICE_PARA_NAME_CUSTNAME);
		 String prodId=paraMap.get(SERVICE_PARA_NAME_PRODID);
		 Integer qty=Integer.parseInt(paraMap.get(SERVICE_PARA_NAME_QTY));
		 String custDomain=paraMap.get(SERVICE_PARA_NAME_CUSTDOMAIN);
		 Boolean trialind= Boolean.valueOf(paraMap.get(SERVICE_PARA_NAME_TRIALIND));
		 String firstName=paraMap.get(SERVICE_PARA_FIRST_NAME);
		 String lastName=paraMap.get(SERVICE_PARA_LAST_NAME);
		 String email=paraMap.get(SERVICE_PARA_EMAIL);
		 Boolean admin= Boolean.valueOf(paraMap.get(SERVICE_PARA_ADMIN));
		 Boolean active=Boolean.valueOf(paraMap.get(SERVICE_PARA_ACTIVE));
		 String requestStr=null;
		 String responseStr=null;
		 ResponseObject responseObject=null;
		 try {
		 RequestObject reqObject = new RequestObject(userId, password, application, env, adaptVersion,
                new Date(), requestNo);
		 reqObject.addRequestEntities(CommonIsvHelper.generateUserUpdate(saasId, userId, firstName, lastName, admin, email,active));
		 requestStr=IsvXmlParser.createRequest(reqObject);
		 //responseStr=ProvisioningServiceImpl.sendProvisioningRequest("targetEndpoint", requestStr);
		 responseObject=IsvXmlParser.parseResponse(responseStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> responseMap = new HashMap<String, Object>();
		List<ResponseResult> responseList=responseObject.getResponseResults();
		if(null!=responseList&&responseList.size()>0){
			  for(ResponseResult result:responseList){
			   responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE,result.getReturnCode() );
			   responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG,result.getReturnMessage()); 
			  }
		}
		 
        
       
        return responseMap;
    }

}
