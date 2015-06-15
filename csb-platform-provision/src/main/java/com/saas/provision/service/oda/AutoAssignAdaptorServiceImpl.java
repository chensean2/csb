package com.saas.provision.service.oda;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.saas.common.to.UserTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.product.to.UserDeviceTO;
import com.saas.provision.service.AdaptorObjectService;
import com.saas.provision.service.BaseAdaptor;
import com.saas.provision.service.IsvConstants;
import com.saas.provision.util.IsvSvc;

/**
 * This class is a adapter for auto provision to assign product to user.
 * 
 */
public class AutoAssignAdaptorServiceImpl extends BaseAdaptor implements AdaptorObjectService {

    private static Logger log = LoggerFactory.getLogger(AutoAssignAdaptorServiceImpl.class);
//
//    private UserService userService;
//
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> execute(Map<String, Object> paraMap, Map<String, Object> serviceMap) {
        String returnCode = IsvConstants.ISV_ADAP_SUCCESS;
        String returnMessage = "";
        String userID = (String) paraMap.get(IsvConstants.SERVICE_MAP_USER_ID);

        List<String> serviceList = (List<String>) paraMap.get(IsvConstants.SERVICE_MAP_SERVICE_LISTS);
        List<String> noProvisionList = new ArrayList<String>();
        List<String> assignedProductNames = (List<String>) paraMap.get(IsvConstants.SERVICE_MAP_ASSIGNED_PRODUCT_NAMES);
        List<String[]> jspList = (List<String[]>) paraMap.get(IsvConstants.SERVICE_MAP_JSP_LIST);
        List<Domain2ProductTO> domainProductList = (List<Domain2ProductTO>) paraMap.get(IsvConstants.SERVICE_MAP_DOMAIN_PRODUCT_LIST);

        Map<String, Object> responseMap = new HashMap<String, Object>();
        try {
            if (log.isInfoEnabled()) {
                log.info("[SaaSConnect] Auto-assign Adaptor(ODA) start, userID: " + userID);
            }
            returnMessage = "auto assign success";
//            UserTO user = userService.getUser(userID);
            UserTO user = new UserTO();
            try {
                for (int i = 0; i < serviceList.size(); i++) {
                    log.info("[SaaSConnect] Auto-assign Adaptor(ODA), " + i + " - service Id:" + serviceList.get(i) + " userID: " + userID);
                    log.info("[SaaSConnect] Auto-assign Adaptor(ODA), " + i + " - assignedProductName:" + assignedProductNames.get(i) + " userID: " + userID);
                    log.info("[SaaSConnect] Auto-assign Adaptor(ODA), " + i + " - domainProductList:" + domainProductList.get(i).getDomainProductId() + " userID: "
                            + userID);
                    String[] jspArray = jspList.get(i);
                    StringBuffer jspBuffer = new StringBuffer();
                    if (jspArray != null) {
                        for (String jspValue : jspArray) {
                            jspBuffer.append(jspValue).append(",");
                        }
                    }
                    log.info("[SaaSConnect] Auto-assign Adaptor(ODA), " + i + " - jspList:" + jspBuffer.toString() + " userID: " + userID);
                }
            } catch (Exception e) {
                log.error("[SaaSConnect] Auto-assign Adaptor(ODA), parameters error" + " userID: " + userID, e);
            }

            // Process provsion validation
            List<String[]> errorMsg = productOrderService.processValidateAdapter(serviceList, assignedProductNames, jspList, IsvSvc.SERVICE_DEF_CATEGORY_USER,
                    IsvSvc.SERVICE_DEF_OPERATION_CREATE);
            if (errorMsg.size() > 0) {
                String[] errorArray = errorMsg.get(0);
                String errorMessage = null;
                if (errorArray != null && errorArray.length > 0) {
                    errorMessage = errorArray[0];
                }
                log.info("[SaaSConnect] Auto-assign Adaptor(ODA), validation error: " + errorMessage + " userID: " + userID);
                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, IsvConstants.ISV_ADAP_ERROR);
                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, errorMsg.get(0));
                return responseMap;
            }
            Map<String, Map<Integer, UserDeviceTO>> deviceMap = new HashMap<String, Map<Integer, UserDeviceTO>>();

            String requestId = productOrderService.assignProvisionUserAndDevice(serviceList, domainProductList, deviceMap, jspList, IsvSvc.SERVICE_DEF_CATEGORY_USER,
                    IsvSvc.SERVICE_DEF_OPERATION_CREATE, user, noProvisionList);

            if (StringUtils.isEmpty(requestId)) {
                log.info("[SaaSConnect] Auto-assign Adaptor(ODA), Provision error: " + " userID: " + userID);
                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, IsvConstants.ISV_ADAP_ERROR);
                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, "[SaaSConnect] Auto-assign Adaptor(Mobile Security) - Auto Assign Action Faild." + " userID: "
                        + userID);
                return responseMap;
            } else {
                log.info("[SaaSConnect] Auto-assign Adaptor(ODA), Auto Assign Action Successful. requestId: " + requestId + " userID: " + userID);
                responseMap.put("requestId", requestId);
                responseMap.put("noProvisionList", noProvisionList);
                return responseMap;
            }
        } catch (Exception e) {
            if (log.isInfoEnabled()) {
                log.error("[SaaSConnect] Auto-assign Adaptor(ODA), Auto Assign Action Error : userID: " + userID, e);
            }
            returnCode = IsvConstants.ISV_ADAP_ERROR;
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            returnMessage = sw.toString();
            try {
                pw.close();
                sw.close();
            } catch (Exception e1) {
                if (log.isInfoEnabled()) {
                    log.info("[SaaSConnect] Auto-assign Adaptor(ODA). Error Message : Error Closing Printwriter and String Writer" + " userID: " + userID);

                }
            }
        }
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, returnCode);
        responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, returnMessage);

        return responseMap;
    }
}
