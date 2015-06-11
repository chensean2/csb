package com.saas.provision.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csb.common.IAppsConstants;
import com.csb.common.SequenceUUID;
import com.csb.common.SpringApplicationContextHolder;
import com.csb.common.exception.SCServiceException;
import com.saas.pckge.service.Domain2PackageService;
import com.saas.pckge.service.Domain2ProductService;
import com.saas.pckge.service.PackageService;
import com.saas.pckge.to.PackageTO;
import com.saas.product.dao.ProductDAO;
import com.saas.product.service.ProductOrderService;
import com.saas.product.service.ProductService;
import com.saas.product.service.Service;
import com.saas.product.service.UserProductService;
import com.saas.product.to.ProductTO;
import com.saas.product.to.ServiceTO;
import com.saas.product.to.UserProductTO;
import com.saas.provision.dao.ProvisionDAO;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.to.IsvServiceDefTO;
import com.saas.provision.to.IsvServiceParaDefTO;
import com.saas.provision.to.IsvServiceParaTO;
import com.saas.provision.to.IsvServiceTO;
import com.saas.provision.to.ProvisionCaptureTO;
import com.saas.provision.to.ProvisionTO;
import com.saas.provision.to.ServiceResDetailTO;
import com.saas.provision.to.ServiceResTO;

public class ProvisionServiceImpl implements ProvisionService {

	private ProductDAO productDAO;
	private ProvisionDAO provisionDAO;
    private ApplicationContext appContext;
    private ProductOrderService productOrderService;
    private UserProductService userProductService;
    private Service service;
    private PackageService packageService;
    private ProductService productService;
    private Domain2ProductService domain2ProductService;
    private Domain2PackageService domain2PackageService;
    
    public Domain2PackageService getDomain2PackageService() {
		return domain2PackageService;
	}

	public void setDomain2PackageService(Domain2PackageService domain2PackageService) {
		this.domain2PackageService = domain2PackageService;
	}

	Logger log = LoggerFactory.getLogger(ProvisionServiceImpl.class);

    private final static String HTML_TAG_UL_START = "<ul>";
    private final static String HTML_TAG_UL_END = "</ul>";
    private final static String HTML_TAG_LI_START = "<li>";
    private final static String HTML_TAG_LI_END = "</li>";
    private final static String HTML_TAG_SLASH = " - ";
    private final static String SMS_CENTER_NUMBER = "help.center.number";

   
    public List<String> createProvisionRequest(ProvisionTO provisionTO) {

        // validate provisionTO and return a message list of validate result
        List<String> validateProvMsgList = validateProvision(provisionTO);

        if (null == validateProvMsgList || validateProvMsgList.isEmpty()) {
            // call DAO to insert a record of provisionTO into DB
            provisionDAO.createProvisionRequest(provisionTO);

            // call DAO to insert isvserviceTO into DB iteratively
            List<IsvServiceTO> isvServiceList = provisionTO.getIsvServiceList();
            for (int i = 0; i < provisionTO.getIsvServiceList().size(); i++) {
                provisionDAO.createIsvService(isvServiceList.get(i));

                // get isvServiceParaList from IsvServiceTO,call DAO to insert IsvServiceParaTO into DB iteratively
                List<IsvServiceParaTO> isvServiceParaList = isvServiceList.get(i).getIsvServiceParaList();
                for (int j = 0; j < isvServiceParaList.size(); j++) {
                    provisionDAO.createIsvServicePara(isvServiceParaList.get(j));
                }
            }

            // add a success message into msgList and return
            validateProvMsgList.add(getPropertyAsString(IAppsConstants.PROVISION_VALIDATION_ACCEPTED).replace("{0}",
                    provisionTO.getReqNo()));
            log.info(getPropertyAsString(IAppsConstants.PROVISION_VALIDATION_ACCEPTED).replace("{0}",
                    provisionTO.getReqNo()));
            return validateProvMsgList;

        } else {
            for (String errorMsg : validateProvMsgList) {
                log.info("[SaaSconnect] " + errorMsg);
            }
            return validateProvMsgList;
        }
    }

    /**
     * This method is to update a provision Request.
     * 
     * @param provisionTO
     * @return int
     * @author huajian
     */
    public int updateProvisionRequest(ProvisionTO provisionTO) {
        return provisionDAO.updateProvisionRequest(provisionTO);
    }

    /**
     * This method is to delete a provision Request by id.
     * 
     * @param reqId
     * @return int
     * @author huajian
     */
    public int deleteProvisionRequest(String reqId) {
        ProvisionTO provisionTO = new ProvisionTO();
        provisionTO.setReqId(reqId);
        return provisionDAO.deleteProvisionRequest(provisionTO);
    }

    /**
     * This method is to get a provision Request by id.
     * 
     * @param reqId
     * @return ProvisionTO
     * @author huajian
     */
    public ProvisionTO getProvisionRequest(String reqId) {
        return provisionDAO.getProvisionRequest(reqId);
    }

    /**
     * This method is to validate provision request of provisionTO.
     * 
     * @param provisionTO
     * @return msgList
     * @author huajian
     */
    private List<String> validateProvision(ProvisionTO provisionTO) {

        List<String> validateProvMsgList = new ArrayList<String>();

        // validate the provisionTO customerId
        if (null == provisionTO.getCustomerId()) {
            validateProvMsgList.add(getPropertyAsString(IAppsConstants.PROVISION_VALIDATION_CUSTID_REQUIRED));
        }

        // validate ISV service and ISV service parameter information iteratively
        List<IsvServiceTO> isvServiceList = provisionTO.getIsvServiceList();
        if (null != isvServiceList && !isvServiceList.isEmpty()) {
            // used to store the ISV services sequence
            List<Integer> sequenceList = new ArrayList<Integer>();
            for (int i = 0; i < isvServiceList.size(); i++) {
                // validate the ISV service information and return the message list
                List<String> validateIsvServMsgList = validateIsvService(isvServiceList.get(i), sequenceList);
                if (null != validateIsvServMsgList && !validateIsvServMsgList.isEmpty()) {
                    validateProvMsgList.addAll(validateIsvServMsgList);
                }
            }
        } else {
            validateProvMsgList.add(getPropertyAsString(IAppsConstants.PROVISION_VALIDATION_ISVSVC_REQUIRED));
        }

        return validateProvMsgList;
    }

    /**
     * This method is to validate the ISV service and service parameter.
     * 
     * @param isvServiceTO
     *            ,sequenceList
     * @return msglist
     * @author huajian
     */
    private List<String> validateIsvService(IsvServiceTO isvServiceTO, List<Integer> sequenceList) {
        List<String> validateIsvServMsgList = new ArrayList<String>();

        // check ISV service information with ISV service definition table
        List<IsvServiceDefTO> isvServiceDefList = provisionDAO.getIsvServiceDefList(isvServiceTO.getServiceName(),
                isvServiceTO.getServiceCategory(), isvServiceTO.getServiceOperation(), isvServiceTO
                        .getServiceDefVersion());
        if (null == isvServiceDefList || isvServiceDefList.isEmpty()) {
            String isvServInvalidMsg = getPropertyAsString(IAppsConstants.PROVISION_VALIDATION_ISVSVC_INVALID).replace(
                    "{0}",
                    isvServiceTO.getServiceName() + " " + isvServiceTO.getServiceCategory() + " "
                            + isvServiceTO.getServiceOperation() + " " + isvServiceTO.getServiceDefVersion());
            validateIsvServMsgList.add(isvServInvalidMsg);
        } else {
            isvServiceTO.setIsvServiceDefId(isvServiceDefList.get(0).getIsvServiceDefId());

            // get the ISV service parameter list and checked with ISV service parameter definition table
            List<IsvServiceParaTO> isvServiceParalist = isvServiceTO.getIsvServiceParaList();
            String isvServParaInvalidMsg = getPropertyAsString(IAppsConstants.PROVISION_VALIDATION_ISVSVC_PARA_INVALID)
                    .replace(
                            "{0}",
                            isvServiceTO.getServiceName() + " " + isvServiceTO.getServiceCategory() + " "
                                    + isvServiceTO.getServiceOperation() + " " + isvServiceTO.getServiceDefVersion());

            if (null != isvServiceParalist && !isvServiceParalist.isEmpty()) {
                List<IsvServiceParaDefTO> isvServiceParaDefList = provisionDAO.getIsvServiceParaDefList(isvServiceTO
                        .getIsvServiceDefId());
                if (null != isvServiceParaDefList) {
                    for (int i = 0; i < isvServiceParaDefList.size(); i++) {
                        boolean tag = false;
                        String defParaName = isvServiceParaDefList.get(i).getIsvServiceParaName();
                        for (int j = 0; j < isvServiceParalist.size(); j++) {
                            String paraName = isvServiceParalist.get(j).getServiceParaName();
                            if (defParaName.equals(paraName)) {
                                tag = true;
                            }
                        }
                        if (!tag) {
                            validateIsvServMsgList.add(isvServParaInvalidMsg);
                            break;
                        }
                    }
                } else {
                    validateIsvServMsgList.add(isvServParaInvalidMsg);
                }
            } 
        }

        // Validate ISV service sequence,not allow duplication
        Integer isvServiceSeq = isvServiceTO.getServiceSeq();
        if (null != isvServiceSeq && !sequenceList.contains(isvServiceSeq)) {
            sequenceList.add(isvServiceSeq);
        } else {
            validateIsvServMsgList.add(getPropertyAsString(IAppsConstants.PROVISION_VALIDATION_ISVSVC_SEQ_INVALID));
        }

        return validateIsvServMsgList;
    }

    public void provisionRequest(String reqId) {
        // get the provision request by reqId
        ProvisionTO provisionTO = provisionDAO.getProvisionRequest(reqId);
        // get the provision request matched ISV services list
        List<IsvServiceTO> isvServiceList = provisionDAO.getIsvServiceList(reqId);
        logger.info("provisionRequest - isv service size: " + isvServiceList.size() + ". with reqId:" + reqId);
        provisionTO.setIsvServiceList(isvServiceList);
        // String domainId = provisionTO.getCustomerId();
        // iterator the ISV service list to check the service operated status
        Iterator<IsvServiceTO> isvServiceIterator = provisionTO.getIsvServiceList().iterator();
        while (isvServiceIterator.hasNext()) {
            IsvServiceTO isvServiceTO = isvServiceIterator.next();
            try {
                processISVService(isvServiceTO);
            } catch (Exception e) {
                logger.error("Excption occurred when processISVService error, isv Service Id: "
                        + isvServiceTO.getIsvServiceId(), e);
            }

        }
    }

    public void provisionIsvService(String isvServiceId) {
        IsvServiceTO isvServiceTO = provisionDAO.getIsvService(isvServiceId);
        processISVService(isvServiceTO);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void processISVService(IsvServiceTO isvServiceTO) {
        if (IAppsConstants.PROVISION_SERVICE_STATUS_SUCCESS.equals(isvServiceTO.getProvisionServStatus())) {
            return;
        }
        IsvServiceDefTO isvServiceDefTO = provisionDAO.getIsvServiceDef(isvServiceTO.getIsvServiceDefId());
        IsvAdaptorTO isvAdaptorTO = provisionDAO.getIsvAdaptor(isvServiceDefTO.getIsvProvAdaptorId());
        String beanName = isvAdaptorTO.getIsvAdaptorEndpoint();
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }
        AdaptorService adaptorService = (AdaptorService) appContext.getBean(beanName);

        Map<String, Object> responseMap = new HashMap<String, Object>();
        List<IsvServiceParaTO> isvServiceParaList = provisionDAO.getIsvServiceParaList(isvServiceTO.getIsvServiceId());
        Map<String, String> parameterMap = new HashMap<String, String>();
        for (int i = 0; i < isvServiceParaList.size(); i++) {
            String paraName = isvServiceParaList.get(i).getServiceParaName();
            String paraNewValue = isvServiceParaList.get(i).getServiceParaNewValue();
            parameterMap.put(paraName, paraNewValue);
        }
        try {
            Map<String, String> serviceMap = new HashMap<String, String>();
            serviceMap.put(IAppsConstants.SERVICE_MAP_SERVICE_ID, isvServiceTO.getIsvServiceId());
            responseMap = adaptorService.execute(parameterMap, serviceMap);
        } catch (Exception e) {
            log.error("[Saasconnect] Provision Error when execute adaptor: " + isvServiceTO.getIsvServiceId(), e);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String returnMessage = sw.toString();
            try {
                pw.close();
                sw.close();
            } catch (Exception e1) {
                if (log.isInfoEnabled()) {
                    log.info("[Saasconnect] Provision Error : " + isvServiceTO.getIsvServiceId()
                            + " Error Message : Error Closing Printwriter and String Writer");
                }
            }

            responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, IsvConstants.ISV_ADAP_ERROR);
            responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, returnMessage);
        }

        String returnCode = (String) responseMap.get(IAppsConstants.ISV_ADAPTOR_RETURN_CODE);
        String returnMsg = (String) responseMap.get(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG);
        String serviceMsg = (String) responseMap.get(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_SERVICE_MSG);

        String resultStatus = "";

        if (IsvConstants.ISV_ADAP_SUCCESS.equals(returnCode)) {
            resultStatus = IAppsConstants.PROVISION_SERVICE_STATUS_SUCCESS;
        } else {
            resultStatus = IAppsConstants.PROVISION_SERVICE_STATUS_FAILURE;
        }

        List<ServiceResTO> serviceResList = provisionDAO.getServiceResList(isvServiceTO.getIsvServiceId());
        ServiceResTO serviceResTO = null;
        ServiceResDetailTO servResDetailTO = new ServiceResDetailTO();

        // if serviceResList is empty mean the service response is new,we need to create a record
        // else to update the service response record which already in DB
        if (null == serviceResList || serviceResList.isEmpty()) {
            serviceResTO = new ServiceResTO();
            serviceResTO.setServResId(SequenceUUID.getInstance().getUUID());
            serviceResTO.setIsvServiceId(isvServiceTO.getIsvServiceId());
            serviceResTO.setServResReceiveTime(getTimeStamp());
            serviceResTO.setServResType(resultStatus);
            serviceResTO.setProvResCode(returnCode);
            serviceResTO.setProvResMessage(returnMsg);
            serviceResTO.setServiceResMessage(serviceMsg);
            // to create a service response record into DB
            provisionDAO.createServiceRes(serviceResTO);

            logger.debug("[SaaSconnect]service response record insert success,isv_service_id is : "
                    + serviceResTO.getIsvServiceId());

        } else {
            serviceResTO = serviceResList.get(0);
            serviceResTO.setServResReceiveTime(getTimeStamp());
            serviceResTO.setServResType(resultStatus);
            serviceResTO.setProvResCode(returnCode);
            serviceResTO.setProvResMessage(returnMsg);
            serviceResTO.setServiceResMessage(serviceMsg);
            // update service response record status and about information
            provisionDAO.updateServiceRes(serviceResTO);

            logger.debug("[SaaSconnect]update the service record to new status and about information success,"
                    + "isv_service_id is : " + serviceResTO.getIsvServiceId());

            // delete the record already exit in service response detail table
            provisionDAO.deleteServiceResDetailAll(serviceResTO.getServResId());
            logger.debug("delete service response detail record success,service_res_id is : "
                    + servResDetailTO.getServResId());
        }

        // create a new service response detail record insert DB
        servResDetailTO.setServResDetailId(SequenceUUID.getInstance().getUUID());
        // set the service response detail record foreign key value from service response record
        servResDetailTO.setServResId(serviceResTO.getServResId());
        // to set response field name and value
        servResDetailTO.setServResFieldName(returnCode);
        servResDetailTO.setServResFieldValue(returnMsg);
        provisionDAO.createServiceResDetail(servResDetailTO);

        logger.debug("[SaaSconnect]service response detail record insert success,service_res_id is : "
                + servResDetailTO.getServResId());
        // }
        // to update ISV Service record status
        isvServiceTO.setProvisionServStatus(resultStatus);
        provisionDAO.updateIsvService(isvServiceTO);

        logger.debug("[SaaSconnect]update ISV Service record status success, ISV service id is: "
                + isvServiceTO.getIsvServiceId());
    }
    
    public IsvAdaptorTO getSvcAdaptorTO(String serviceId, String serviceCategory, String serviceOperation) {
    	ServiceTO serviceParamTO = new ServiceTO();
        serviceParamTO.setServiceId(serviceId);
        ServiceTO serviceTO = service.getService(serviceParamTO);
        if (serviceTO == null) {
        	logger.info("Error occurrd get Service by serviceID: " + serviceId);
        	return null;
        }

        IsvServiceTO isvServiceTO = new IsvServiceTO();
        isvServiceTO.setServiceName(serviceTO.getServiceDefName());
        isvServiceTO.setServiceCategory(serviceCategory);
        isvServiceTO.setServiceOperation(serviceOperation);
        isvServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
        
        IsvServiceDefTO isvServiceDefTO = getIsvServiceDef(isvServiceTO);
        
        if (isvServiceDefTO == null) {
        	logger.info("Error occurrd get get adapter: "
                    + isvServiceTO.getServiceName() + "," + isvServiceTO.getServiceCategory() + ","
                    + isvServiceTO.getServiceOperation() + "," + isvServiceTO.getServiceDefVersion());
        	return null;
        }
        
        return getSvcAdaptor(isvServiceDefTO.getIsvProvAdaptorId());
    }

//    public void sendNotificationSms(String reqId, List<String> noProvsionList, String sendType) {
//        // get ISV service id
//        List<UserProductTO> userProductAllList = new ArrayList<UserProductTO>();
//        if (StringUtils.isNotEmpty(reqId)) {
//
//            List<IsvServiceTO> isvServiceList = searchProvisionDetail(reqId);
//
//            if (null == isvServiceList || isvServiceList.isEmpty()) {
//                if (log.isDebugEnabled()) {
//                    log.debug("[SaaSConnect] Error occured when send notification sms, can't get IsvService records.");
//                }
//            }
//
//            // get user information
//          for(IsvServiceTO isvServiceTo : isvServiceList){
//        	  UserProductTO userProductParam = new UserProductTO();
//              userProductParam.setProTxId(isvServiceTo.getIsvServiceId());
//              List<UserProductTO> userProductList = userProductService.getUserProductList(userProductParam);
//              userProductAllList.addAll(userProductList);
//          }
//            
////            // get user information
////            UserProductTO userProductParam = new UserProductTO();
////            userProductParam.setProTxId(isvServiceList.get(0).getIsvServiceId());
////            List<UserProductTO> userProductList = userProductService.getUserProductList(userProductParam);
////            userProductAllList.addAll(userProductList);
//        }
//
//        if (noProvsionList != null && noProvsionList.size() > 0) {
//            for (String productId : noProvsionList) {
//                UserProductTO userProduct = new UserProductTO();
//                userProduct.setUserProductId(productId);
//                List<UserProductTO> userProductList = userProductService.getUserProductList(userProduct);
//                userProductAllList.addAll(userProductList);
//            }
//        }
//
//        if (null == userProductAllList || userProductAllList.isEmpty()) {
//            if (log.isDebugEnabled()) {
//                log.debug("[SaaSConnect] Error occured when send notification sms, can't get UserProduct records.");
//            }
//            return;
//        }
//
//        UserTO user = userService.getUser(userProductAllList.get(0).getUserId());
//
//        if (!IAppsConstants.IND_YES.equals(user.getSmsIndicateNotification())) {
//            return;
//        }
//
//        if (IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN.equalsIgnoreCase(sendType)) {
//            sendAssignNotificationSms(userProductAllList, user);
//        } else if (IAppsConstants.ASSIGN_STATUS_TYPE_UNASSIGN.equalsIgnoreCase(sendType)) {
//            sendUnassignNotificationSms(userProductAllList, user);
//        } else {
//            if (log.isDebugEnabled()) {
//                log.debug("[SaaSConnect] Error occured when send notification sms, send type is wrong.");
//            }
//        }
//    }
//
//    private void sendUnassignNotificationSms(List<UserProductTO> userProductList, UserTO user) {
//        // remove not success product
//    	List<UserProductTO> successUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> failureUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> multiSuccessUserProductList =  new ArrayList<UserProductTO>();
//        List<UserProductTO> multiFailureUserProductList = new ArrayList<UserProductTO>();
//        separateUserProduct(userProductList, successUserProductList, failureUserProductList,multiSuccessUserProductList,multiFailureUserProductList);
//
//        List<UserProductTO> packageIdList = getPackageIdList(successUserProductList);
//
//        if (packageIdList.isEmpty()&&multiSuccessUserProductList.isEmpty()) {
//            if (log.isInfoEnabled()) {
//                log.info("[SaaSConnect] No need to send unassign notification SMS");
//            }
//            
//            return;
//        }
//
//        StringBuffer sb = new StringBuffer();
//        for (UserProductTO userProductTO : packageIdList) {
//            userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//            sb.append(userProductTO.getPackageName()).append(",");
//        }
//        
//        for (UserProductTO userProductTO : multiSuccessUserProductList) {
//        	userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//
//            sb.append(userProductTO.getPackageName());
//            if(IsvFSecureConstants.FSECURE_MOBILE_SERVICE_ID.equalsIgnoreCase(userProductTO.getServiceId())){
//                sb.append(HTML_TAG_SLASH);
//                sb.append(getMobileNumByRefKey(getServiceRefKey(userProductTO)));
//            }
//            sb.append(",");
//        }
//        
//        if (sb.length() > 1) {
//            sb = new StringBuffer(sb.substring(0, sb.length() - 1));
//        }
//        
//        // set the template
//        ReportTemplateTO reportTemplateTO = new ReportTemplateTO();
//        reportTemplateTO.setTemplateId(IAppsConstants.NOF_SMS_PRODUCT_UNASSIGN);
//
//        // set the send to list
//        List<String> smsToList = new ArrayList<String>();
//        smsToList.add(user.getMobileNum());
//
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("productNames", sb.toString());
//
//        // send SMS
//        reportTemplateService.sendSMS(reportTemplateTO, map, null, smsToList);
//    }

//    private void sendAssignNotificationSms(List<UserProductTO> userProductList, UserTO user) {
//        // remove not success product
//    	List<UserProductTO> successUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> failureUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> multiSuccessUserProductList =  new ArrayList<UserProductTO>();
//        List<UserProductTO> multiFailureUserProductList = new ArrayList<UserProductTO>();
//        separateUserProduct(userProductList, successUserProductList, failureUserProductList,multiSuccessUserProductList,multiFailureUserProductList);
//        
//        List<UserProductTO> packageIdList = getPackageIdList(successUserProductList);
//
//        if (packageIdList.isEmpty()&&multiSuccessUserProductList.isEmpty()) {
//            if (log.isInfoEnabled()) {
//                log.info("[SaaSConnect] No need to send assign notification SMS");
//            }
//            
//            return;
//        }
//
//        StringBuffer sb = new StringBuffer();
//        for (UserProductTO userProductTO : packageIdList) {
//            userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//            sb.append(userProductTO.getPackageName()).append(",");
//        }
//        
//        boolean isBackupService = false;
//        for (UserProductTO userProductTO : multiSuccessUserProductList) {
//        	userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//
//            sb.append(userProductTO.getPackageName());
//            if(IsvFSecureConstants.FSECURE_MOBILE_SERVICE_ID.equalsIgnoreCase(userProductTO.getServiceId())){
//                sb.append(HTML_TAG_SLASH);
//                sb.append(getMobileNumByRefKey(getServiceRefKey(userProductTO)));
//            }
//            if(IsvFSecureBackupConstants.FSECURE_ONLINE_BACKUP_SERVICE_ID.equalsIgnoreCase(userProductTO.getServiceId())){
//                isBackupService = true;
//            }
//            sb.append(",");
//        }
//
//        if (sb.length() > 1) {
//            sb = new StringBuffer(sb.substring(0, sb.length() - 1));
//        }
//
//        ReportTemplateTO reportTemplateTO = new ReportTemplateTO();
//        if(isBackupService){
//            reportTemplateTO.setTemplateId(IAppsConstants.NOF_SMS_DEVICE_PRODUCT_ASSIGN);
//        }else{
//            reportTemplateTO.setTemplateId(IAppsConstants.NOF_SMS_PRODUCT_ASSIGN);
//        }
//
//        List<String> smsToList = new ArrayList<String>();
//        smsToList.add(user.getMobileNum());
//
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("productNames", sb.toString());
//        map.put("optusSupportNum", config.getPropertyAsString(IAppsConstants.SAAS_CONFIG, SMS_CENTER_NUMBER, ""));
//
//        reportTemplateService.sendSMS(reportTemplateTO, map, null, smsToList);
//    }
//
//    /**
//     * send notification email
//     */
//    public void sendNotificationEmail(String reqId, List<String> noProvsionList, String sendType, String adminUserId) {
//        // get ISV service id
//        List<UserProductTO> userProductAllList = new ArrayList<UserProductTO>();
//        if (StringUtils.isNotEmpty(reqId)) {
//
//            List<IsvServiceTO> isvServiceList = searchProvisionDetail(reqId);
//
//            if (null == isvServiceList || isvServiceList.isEmpty()) {
//                if (log.isDebugEnabled()) {
//                    log.debug("[SaaSConnect] Error occured when send notification email, can't get IsvService records.");
//                }
//            }
//
//            // get user information
////            UserProductTO userProductParam = new UserProductTO();
////            userProductParam.setProTxId(isvServiceList.get(0).getIsvServiceId());
//            for(IsvServiceTO isvServiceTo : isvServiceList){
//            	UserProductTO userProductParam = new UserProductTO();
//            	userProductParam.setProTxId(isvServiceTo.getIsvServiceId());
//            	List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProductParam);
//            	
//            	// when there is 1 internet security product, no need send the mail.
//            	if(IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN.equalsIgnoreCase(sendType)){
//        	       if(userProductList != null && userProductList.size() > 0){
//                       UserProductTO userProduct = userProductList.get(0);
//                       if(userProduct != null && IsvFSInternetSecurityConstants.FSECURE_INTERNET_SECURITY_SERVICE_ID.equals(userProduct.getServiceId())){
//                           UserProductTO userProductAll = new UserProductTO();
//                           userProductAll.setDomainProductId(userProduct.getDomainProductId());
//                           userProductAll.setUserId(userProduct.getUserId());
//                           userProductAll.setServiceId(IsvFSInternetSecurityConstants.FSECURE_INTERNET_SECURITY_SERVICE_ID);
//                           List<UserProductTO> userProductListAll = userProductService.getAllAssignedUserProducts(userProductAll);
//                             
//                           if(userProductListAll.size() > 1){
//                             log.info("[sendNotificationEmail: Fsecure-internet-security] there are other device assigned, no need send Activation Email, proTxId: " + userProduct.getUserProductId());
//                             continue;
//                           }
//                       }
//                     
//                    }
//            	}
//           
//                  
//                userProductAllList.addAll(userProductList);
//            }
//            
//        }
//
//        if (noProvsionList != null && noProvsionList.size() > 0) {
//            for (String productId : noProvsionList) {
//                UserProductTO userProduct = new UserProductTO();
//                userProduct.setUserProductId(productId);
//                List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProduct);
//                userProductAllList.addAll(userProductList);
//            }
//        }
//
//        if (null == userProductAllList || userProductAllList.isEmpty()) {
//            if (log.isDebugEnabled()) {
//                log.debug("[SaaSConnect] Error occured when send notification email, can't get UserProduct records.");
//            }
//            return;
//        }
//
//        UserTO user = userService.getUser(userProductAllList.get(0).getUserId());
//
//        if (IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN.equalsIgnoreCase(sendType)) {
//            sendAssignNotificationEmail(userProductAllList, user, adminUserId);
//        } else if (IAppsConstants.ASSIGN_STATUS_TYPE_UNASSIGN.equalsIgnoreCase(sendType)) {
//            sendUnassignNotificationEmail(userProductAllList, user, adminUserId);
//        } else {
//            if (log.isDebugEnabled()) {
//                log.debug("[SaaSConnect] Error occured when send notification email, send type is wrong.");
//            }
//        }
//    }
//    
//    /**
//     * send notification email
//     */
//    public void sendAutoAssignFailureNotificationEmail(String reqId, String adminUserId) {
//        // get ISV service id
//        List<UserProductTO> userProductAllList = new ArrayList<UserProductTO>();
//        List<UserProductTO> failureUserProductList = new ArrayList<UserProductTO>();
//        if (StringUtils.isNotEmpty(reqId)) {
//            List<IsvServiceTO> isvServiceList = searchProvisionDetail(reqId);
//            if (null == isvServiceList || isvServiceList.isEmpty()) {
//                if (log.isDebugEnabled()) {
//                    log.debug("[SaaSConnect] Error occured when send notification email, can't get IsvService records.");
//                }
//            }
//            for (IsvServiceTO isvServiceTo : isvServiceList) {
//                UserProductTO userProductParam = new UserProductTO();
//                userProductParam.setProTxId(isvServiceTo.getIsvServiceId());
//                // userProductParam.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_SUCCESS);
//                List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProductParam);
//                userProductAllList.addAll(userProductList);
//            }
//            for (int i = userProductAllList.size() - 1; i >= 0; i--) {
//                ProductTO productTO = new ProductTO();
//                productTO.setProductId(userProductAllList.get(i).getProductId());
//                productTO = productDAO.getProduct(productTO);
//                if (!IAppsConstants.PRO_DES_CODE_ID_SUCCESS.equalsIgnoreCase(userProductAllList.get(i)
//                        .getProDescCodeId())) {
//                    failureUserProductList.add(userProductAllList.get(i));
//                    continue;
//                }
//            }
//        }
//
//        if (null != failureUserProductList && !failureUserProductList.isEmpty()) {
//            UserTO user = userService.getUser(userProductAllList.get(0).getUserId());
//            if (log.isInfoEnabled()) {
//                log.info("[SaaSConnect] Start to send assign failure notification email");
//            }
//            String packageName = null;
//            String productName = null;
//            String userProductId = null;
//            if(failureUserProductList.get(0) != null){
//                PackageTO packagePara = new PackageTO();
//                packagePara.setPackageId(failureUserProductList.get(0).getPackageId());
//                packagePara = packageService.getPackage(packagePara);
//                packageName = packagePara.getPackageName();
//                
//                ProductTO productPara = new ProductTO();
//                productPara.setProductId(failureUserProductList.get(0).getProductId());
//                productPara = productService.getProduct(productPara);
//                productName = productPara.getProductName();
//                
//                userProductId = failureUserProductList.get(0).getUserProductId();
//            }
//            
//            // report template
//            ReportTemplateTO reportTemplateTO = new ReportTemplateTO();
//            reportTemplateTO.setTemplateId(IAppsConstants.NOF_PRODUCT_AUTO_ASSIGN_FAILED);
//
//            // parameter map
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("packageName", packageName);
//            map.put("productName", productName);
//            map.put("userProductId", userProductId);
//            map.put("loginId", user.getLoginId());
//
//            try {
//                // send email
//                reportTemplateService.sendEmail(reportTemplateTO, map, null, null, null, null, null, null);
//            } catch (MailException e) {
//                if (log.isDebugEnabled()) {
//                    log.debug("[SaaSConnect] Error occured when send assign failure notification email.", e);
//                }
//            }
//        }
//    }
//    
//    /**
//     * this method is used to send auto assign notification email to company admin user.
//     * 
//     * @param reqId
//     * @param noProvsionList
//     * @param sendType
//     * @param adminUserId
//     */
//    public void sendAutoAssignNotificationEmail(String reqId, List<String> noProvsionList, String sendType, String adminUserId) {
//        // get ISV service id
//        List<UserProductTO> userProductAllList = new ArrayList<UserProductTO>();
//        if (StringUtils.isNotEmpty(reqId)) {
//            List<IsvServiceTO> isvServiceList = searchProvisionDetail(reqId);
//            if (null == isvServiceList || isvServiceList.isEmpty()) {
//                if (log.isDebugEnabled()) {
//                    log.debug("[SaaSConnect] Error occured when send notification email, can't get IsvService records.");
//                }
//            }
//
//            // get user information
//            // UserProductTO userProductParam = new UserProductTO();
//            // userProductParam.setProTxId(isvServiceList.get(0).getIsvServiceId());
//            for (IsvServiceTO isvServiceTo : isvServiceList) {
//                UserProductTO userProductParam = new UserProductTO();
//                userProductParam.setProTxId(isvServiceTo.getIsvServiceId());
//                List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProductParam);
//
//                // when there is 1 internet security product, no need send the mail.
//                if (IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN.equalsIgnoreCase(sendType)) {
//                    if (userProductList != null && userProductList.size() > 0) {
//                        UserProductTO userProduct = userProductList.get(0);
//                        if (userProduct != null && IsvFSInternetSecurityConstants.FSECURE_INTERNET_SECURITY_SERVICE_ID.equals(userProduct.getServiceId())) {
//                            UserProductTO userProductAll = new UserProductTO();
//                            userProductAll.setDomainProductId(userProduct.getDomainProductId());
//                            userProductAll.setUserId(userProduct.getUserId());
//                            userProductAll.setServiceId(IsvFSInternetSecurityConstants.FSECURE_INTERNET_SECURITY_SERVICE_ID);
//                            List<UserProductTO> userProductListAll = userProductService.getAllAssignedUserProducts(userProductAll);
//
//                            if (userProductListAll.size() > 1) {
//                                log.info("[sendNotificationEmail: Fsecure-internet-security] there are other device assigned, no need send Activation Email, proTxId: "
//                                        + userProduct.getUserProductId());
//                                continue;
//                            }
//                        }
//
//                    }
//                }
//                userProductAllList.addAll(userProductList);
//            }
//        }
//
//        if (noProvsionList != null && noProvsionList.size() > 0) {
//            for (String productId : noProvsionList) {
//                UserProductTO userProduct = new UserProductTO();
//                userProduct.setUserProductId(productId);
//                List<UserProductTO> userProductList = userProductService.getMatchingUserProducts(userProduct);
//                userProductAllList.addAll(userProductList);
//            }
//        }
//
//        if (null == userProductAllList || userProductAllList.isEmpty()) {
//            if (log.isDebugEnabled()) {
//                log.debug("[SaaSConnect] Error occured when send notification email, can't get UserProduct records.");
//            }
//            return;
//        }
//
//        UserTO user = userService.getUser(userProductAllList.get(0).getUserId());
//
//        if (IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN.equalsIgnoreCase(sendType)) {
//            sendAssignNotificationEmail(userProductAllList, user, adminUserId);
//        } else {
//            if (log.isDebugEnabled()) {
//                log.debug("[SaaSConnect] Error occured when send notification email, send type is wrong.");
//            }
//        }
//    }
//
//    private void sendAssignNotificationEmail(List<UserProductTO> userProductList, UserTO user, String adminUserId) {
//        // remove not success product
//        List<UserProductTO> successUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> failureUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> multiSuccessUserProductList =  new ArrayList<UserProductTO>();
//        List<UserProductTO> multiFailureUserProductList = new ArrayList<UserProductTO>();
//        separateUserProduct(userProductList, successUserProductList, failureUserProductList,multiSuccessUserProductList,multiFailureUserProductList);
//         
//        // send success assign notification email
//        if (!successUserProductList.isEmpty()||!multiSuccessUserProductList.isEmpty()) {
//            if (log.isInfoEnabled()) {
//                log.info("[SaaSConnect] Start to send assign success notification email");
//            }
//            
//            List<UserProductTO> packageIdList = getPackageIdList(successUserProductList);
//            
//
//            if (packageIdList.isEmpty()&&multiSuccessUserProductList.isEmpty()) {
//                if (log.isInfoEnabled()) {
//                    log.info("[SaaSConnect] No need to send assign success notification email");
//                }
//            }else{
//                StringBuffer sb = new StringBuffer();
//                sb.append(HTML_TAG_UL_START);
//                for (UserProductTO userProductTO : packageIdList) {
//                	userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//
//                    sb.append(HTML_TAG_LI_START);
//                    sb.append(userProductTO.getPackageName());
//                    sb.append(HTML_TAG_LI_END);
//                }
//                
//                for(UserProductTO userProduct : multiSuccessUserProductList){
//                	userProduct = domain2PackageService.constructUserProduct(userProduct);
//                    
//                    sb.append(HTML_TAG_LI_START);
//                    sb.append(userProduct.getPackageName());
//                    if(IsvFSecureConstants.FSECURE_MOBILE_SERVICE_ID.equalsIgnoreCase(userProduct.getServiceId())){
//                        sb.append(HTML_TAG_SLASH);
//                        sb.append(getMobileNumByRefKey(getServiceRefKey(userProduct)));
//                    }
//                    sb.append(HTML_TAG_LI_END);
//                }
//                
//                sb.append(HTML_TAG_UL_END);
//                
//                // report template
//                ReportTemplateTO reportTemplateTO = new ReportTemplateTO();
//                reportTemplateTO.setTemplateId(IAppsConstants.NOF_PRODUCT_ASSIGN);
//                
//                // email to list
//                List<String> emailToList = new ArrayList<String>();
//                emailToList.add(user.getEmail());
//                emailToList.add(user.getChallengeEmail());
//                
//                // parameter map
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("firstName", user.getFirstName());
//                map.put("lastName", user.getLastName());
//
//                map.put("productNames", sb.toString());
//                map.put("loginId", user.getLoginId());
//
//                try {
//                    // send email
//                    reportTemplateService.sendEmail(reportTemplateTO, map, null, null, null, emailToList, null, null);
//                } catch (MailException e) {
//                    if (log.isDebugEnabled()) {
//                        log.debug("[SaaSConnect] Error occured when send assign success notification email.", e);
//                    }
//                }
//                
//                // add audit log for send email
//                try {
//                    UserTO adminUser = userService.getUser(adminUserId);
//                    auditTrailService.createAuditTrail("ASSIGN_NOTIFICATION", adminUser.getUserId(),
//                            "TBL_SS_USER", "CREATE", adminUser.getUserId(), null, user.getEmail() + "," + user.getChallengeEmail());
//                } catch (Exception e) {
//                    log.error(" Error occured when send assign success notification email.", e);
//                }
//            }
//        }
//        
//        // send assign failure notification email
//        if (!failureUserProductList.isEmpty()||!multiFailureUserProductList.isEmpty()) {
//            if (log.isInfoEnabled()) {
//                log.info("[SaaSConnect] Start to send assign failure notification email");
//            }
//            
//            List<UserProductTO> packageIdList = getPackageIdList(failureUserProductList);
//
//            if (packageIdList.isEmpty()) {
//                if (log.isInfoEnabled()) {
//                    log.info("[SaaSConnect] No need to send assign failure notification email");
//                }
//                
//                return;
//            }
//
//            StringBuffer sb = new StringBuffer();
//            sb.append(HTML_TAG_UL_START);
//            for (UserProductTO userProductTO : packageIdList) {
//            	userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//
//                sb.append(HTML_TAG_LI_START);
//                sb.append(userProductTO.getPackageName());
//                sb.append(HTML_TAG_LI_END);
//            }
//            
//            for(UserProductTO userProduct : multiFailureUserProductList){
//            	userProduct = domain2PackageService.constructUserProduct(userProduct);
//                
//                sb.append(HTML_TAG_LI_START);
//                sb.append(userProduct.getPackageName());
//                if(IsvFSecureConstants.FSECURE_MOBILE_SERVICE_ID.equalsIgnoreCase(userProduct.getServiceId())){
//                    sb.append(HTML_TAG_SLASH);
//                    sb.append(getMobileNumByRefKey(getServiceRefKey(userProduct)));
//                }
//                sb.append(HTML_TAG_LI_END);
//            }
//            
//            sb.append(HTML_TAG_UL_END);
//            
//            // report template
//            ReportTemplateTO reportTemplateTO = new ReportTemplateTO();
//            reportTemplateTO.setTemplateId(IAppsConstants.NOF_PRODUCT_ASSIGN_FAILED);
//
//            // get ADMIN user information
//            UserTO adminUser = userService.getUser(adminUserId);
//            
//            // email to list
//            List<String> emailToList = new ArrayList<String>();
//            emailToList.add(adminUser.getEmail());
//            emailToList.add(adminUser.getChallengeEmail());
//            
//            // parameter map
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("firstName", adminUser.getFirstName());
//            map.put("lastName", adminUser.getLastName());
//
//            map.put("productNames", sb.toString());
//            map.put("loginId", user.getLoginId());
//
//            try {
//                // send email
//                reportTemplateService.sendEmail(reportTemplateTO, map, null, null, null, emailToList, null, null);
//            } catch (MailException e) {
//                if (log.isDebugEnabled()) {
//                    log.debug("[SaaSConnect] Error occured when send assign failure notification email.", e);
//                }
//            }
//            
//            // add audit log for send email
//            try {
//                auditTrailService.createAuditTrail("ASSIGN_NOTIFICATION", adminUser.getUserId(),
//                        "TBL_SS_USER", "CREATE", adminUser.getUserId(), null, adminUser.getEmail() + "," + adminUser.getChallengeEmail());
//            } catch (Exception e) {
//                log.error("Error occured when send assign failure notification email.", e);
//            }
//        }
//    }
//
//    private void sendUnassignNotificationEmail(List<UserProductTO> userProductList, UserTO user, String adminUserId) {
//        // remove not success product
//        List<UserProductTO> successUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> failureUserProductList = new ArrayList<UserProductTO>();
//        List<UserProductTO> multiSuccessUserProductList =  new ArrayList<UserProductTO>();
//        List<UserProductTO> multiFailureUserProductList = new ArrayList<UserProductTO>();
//        separateUserProduct(userProductList, successUserProductList, failureUserProductList,multiSuccessUserProductList,multiFailureUserProductList);
//        
//        // send UN assign successful notification email
//        if (!successUserProductList.isEmpty()||!multiSuccessUserProductList.isEmpty()) {
//            List<UserProductTO> packageIdList = getPackageIdList(successUserProductList);
//
//            if (packageIdList.isEmpty()&&multiSuccessUserProductList.isEmpty()) {
//                if (log.isInfoEnabled()) {
//                    log.info("[SaaSConnect] No need to send unassign successful notification email");
//                }
//            }else{
//                StringBuffer sb = new StringBuffer();
//                sb.append(HTML_TAG_UL_START);
//                for (UserProductTO userProductTO : packageIdList) {
//                	userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//
//                    sb.append(HTML_TAG_LI_START);
//                    sb.append(userProductTO.getPackageName());
//                    sb.append(HTML_TAG_LI_END);
//                }
//                
//                for(UserProductTO userProduct : multiSuccessUserProductList){
//                	userProduct = domain2PackageService.constructUserProduct(userProduct);
//                    
//                    sb.append(HTML_TAG_LI_START);
//                    sb.append(userProduct.getPackageName());
//                    if(IsvFSecureConstants.FSECURE_MOBILE_SERVICE_ID.equalsIgnoreCase(userProduct.getServiceId())){
//                        sb.append(HTML_TAG_SLASH);
//                        sb.append(getMobileNumByRefKey(getServiceRefKey(userProduct)));
//                    }
//                    sb.append(HTML_TAG_LI_END);
//                }
//                
//                sb.append(HTML_TAG_UL_END);
//                
//                // report template
//                ReportTemplateTO reportTemplateTO = new ReportTemplateTO();
//                reportTemplateTO.setTemplateId(IAppsConstants.NOF_PRODUCT_UNASSIGN);
//
//                // send email to list
//                List<String> sendTOList = new ArrayList<String>();
//                sendTOList.add(user.getEmail());
//                sendTOList.add(user.getChallengeEmail());
//                
//                // parameter map
//                Map<String, String> map = new HashMap<String, String>();
//                map.put("firstName", user.getFirstName());
//                map.put("lastName", user.getLastName());
//                map.put("products", sb.toString());
//
//                try {
//                    // send email
//                    reportTemplateService.sendEmail(reportTemplateTO, map, null, null, null, sendTOList, null, null);
//                } catch (MailException e) {
//                    if (log.isDebugEnabled()) {
//                        log.debug("[SaaSConnect] Error occured when send notification email.", e);
//                    }
//                }
//                
//                // add audit log for send email
//                try {
//                    UserTO adminUser = userService.getUser(adminUserId);
//                    auditTrailService.createAuditTrail("UNASSIGN_NOTIFICATION", adminUser.getUserId(),
//                            "TBL_SS_USER", "CREATE", adminUser.getUserId(), null, user.getEmail() + "," + user.getChallengeEmail());
//                } catch (Exception e) {
//                    log.error("[SaaSConnect] Error occured when send notification email.", e);
//                }
//            }
//        }
//        
//        // send UN assign failure notification email
//        if (!failureUserProductList.isEmpty()) {
//            List<UserProductTO> packageIdList = getPackageIdList(failureUserProductList);
//
//            if (packageIdList.isEmpty()) {
//                if (log.isInfoEnabled()) {
//                    log.info("[SaaSConnect] No need to send unassign failure notification email");
//                }
//                
//                return;
//            }
//
//            StringBuffer sb = new StringBuffer();
//            sb.append(HTML_TAG_UL_START);
//            for (UserProductTO userProductTO : packageIdList) {
//            	userProductTO = domain2PackageService.constructUserProduct(userProductTO);
//
//                sb.append(HTML_TAG_LI_START);
//                sb.append(userProductTO.getPackageName());
//                sb.append(HTML_TAG_LI_END);
//            }
//            
//            for(UserProductTO userProduct : multiFailureUserProductList){
//            	userProduct = domain2PackageService.constructUserProduct(userProduct);
//                
//                sb.append(HTML_TAG_LI_START);
//                sb.append(userProduct.getPackageName());
//                if(IsvFSecureConstants.FSECURE_MOBILE_SERVICE_ID.equalsIgnoreCase(userProduct.getServiceId())){
//                    sb.append(HTML_TAG_SLASH);
//                    sb.append(getMobileNumByRefKey(getServiceRefKey(userProduct)));
//                }
//                sb.append(HTML_TAG_LI_END);
//            }
//            
//            sb.append(HTML_TAG_UL_END);
//            
//            // get ADMIN user information
//            UserTO adminUser = userService.getUser(adminUserId);
//            
//            // report template
//            ReportTemplateTO reportTemplateTO = new ReportTemplateTO();
//            reportTemplateTO.setTemplateId(IAppsConstants.NOF_PRODUCT_UNASSIGN_FAILED);
//
//            // send email to list
//            List<String> sendTOList = new ArrayList<String>();
//            sendTOList.add(adminUser.getEmail());
//            sendTOList.add(adminUser.getChallengeEmail());
//            
//            // parameter map
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("firstName", adminUser.getFirstName());
//            map.put("lastName", adminUser.getLastName());
//            map.put("productNames", sb.toString());
//            map.put("loginId", user.getLoginId());
//            
//            try {
//                // send email
//                reportTemplateService.sendEmail(reportTemplateTO, map, null, null, null, sendTOList, null, null);
//            } catch (MailException e) {
//                if (log.isDebugEnabled()) {
//                    log.debug("[SaaSConnect] Error occured when send notification email.", e);
//                }
//            }
//            
//            // add audit log for re send email
//            try {
//                auditTrailService.createAuditTrail("UNASSIGN_NOTIFICATION", adminUser.getUserId(),
//                        "TBL_SS_USER", "CREATE", adminUser.getUserId(), null, adminUser.getEmail() + "," + adminUser.getChallengeEmail());
//            } catch (Exception e) {
//                log.error("[SaaSConnect] Error occured when send notification email.", e);
//            }
//        }
//    }
    
    /**
     * this method is used to remove failure user product record form list
     * @param userProductList
     */
	private void separateUserProduct(List<UserProductTO> userProductList,
			List<UserProductTO> successUserProductList,
			List<UserProductTO> failureUserProductList,
			List<UserProductTO> multiSuccessUserProductList,
			List<UserProductTO> multiFailureUserProductList) {
        if (null != userProductList && !userProductList.isEmpty()) {
            for (int i = userProductList.size() - 1; i >= 0; i--) {
            	
            	ProductTO productTO = new ProductTO();
                productTO.setProductId(userProductList.get(i).getProductId());
                productTO = productDAO.getProduct(productTO);
            	
                if (!IAppsConstants.PRO_DES_CODE_ID_SUCCESS.equalsIgnoreCase(userProductList.get(i).getProDescCodeId())) {
                    if(IAppsConstants.IND_YES.equalsIgnoreCase(productTO.getMultiLicenseIndicator())){
                    	multiFailureUserProductList.add(userProductList.get(i));
                    }else{
                    	failureUserProductList.add(userProductList.get(i));
                    }
                    continue;
                }
                
                if(IAppsConstants.IND_YES.equalsIgnoreCase(productTO.getMultiLicenseIndicator())){
                	multiSuccessUserProductList.add(userProductList.get(i));
                }else{
                	successUserProductList.add(userProductList.get(i));
                }
                
            }
        }
    }

    /**
     * this mehtod is used to get package id list according user product list
     * 
     * @param userProductList
     * @return
     */
    private List<UserProductTO> getPackageIdList(List<UserProductTO> userProductList) {
        List<String> packageIdList = new ArrayList<String>();
        List<UserProductTO> userProductTOList = new ArrayList<UserProductTO>();

        if (null != userProductList && !userProductList.isEmpty()) {
            // get package id list
            for (UserProductTO userProductItem : userProductList) {
                ServiceTO serviceTO = new ServiceTO();
                serviceTO.setServiceId(userProductItem.getServiceId());

                serviceTO = service.getService(serviceTO);
                PackageTO packageTO = new PackageTO();
                packageTO.setPackageId(userProductItem.getPackageId());
                packageTO = packageService.getPackage(packageTO);
                
                if (null == serviceTO
                        || !userProductItem.getServiceId().equalsIgnoreCase(packageTO.getMainServiceId())
                        || packageIdList.contains(userProductItem.getPackageId())) {
                    continue;
                }

                packageIdList.add(userProductItem.getPackageId());
                userProductTOList.add(userProductItem);
            }
        }

        return userProductTOList;
    }
    
    private String getServiceRefKey(UserProductTO userProductTO){
    	String serviceRefKey = "";
    	if (StringUtils.isEmpty(userProductTO.getServiceRefKey())) {
			List<IsvServiceParaTO> isvServiceParas = getIsvServiceParaList(userProductTO.getProTxId());
			if(null!=isvServiceParas && isvServiceParas.size()>0){
				serviceRefKey = isvServiceParas.get(0).getServiceParaNewValue();
			}
		}else{
			serviceRefKey = userProductTO.getServiceRefKey();
		}
    	return serviceRefKey;
    }
    
    
    private String getMobileNumByRefKey(String serviceRefKey) {
		
		if(serviceRefKey.contains("@")){
			int i = serviceRefKey.indexOf("@");
			return serviceRefKey.substring(0, i);
		}else{
			return serviceRefKey;
		}
		
	}

    /**
     * used to get a dateTime
     * 
     * @return String
     * @author huajian
     */
    private Timestamp getTimeStamp() {
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        return timestamp;
    }

    public List<IsvServiceTO> getProvisionDetail(String reqId) {
        return provisionDAO.getProvisionDetail(reqId);
    }

    public List<ProvisionTO> getProvisionList(ProvisionTO provisionTO) {
        return provisionDAO.getProvisionList(provisionTO);
    }

    public List<IsvServiceTO> searchProvisionDetail(String reqId) {
        return provisionDAO.searchProvisionDetail(reqId);
    }

    public ProvisionTO getProvision(String reqId) {
        return provisionDAO.getProvision(reqId);
    }

    public List<IsvServiceParaTO> getIsvServiceDetail(String isvServiceId) {
        return provisionDAO.getIsvServiceDetail(isvServiceId);
    }

    public List<ServiceResTO> getServiceResList(String isvServiceId) {
        return provisionDAO.getServiceResponseList(isvServiceId);
    }

    public List<ServiceResDetailTO> getResponseDetailList(String servResId) {
        return provisionDAO.getResponseDetailList(servResId);
    }

    public ServiceResTO getServiceResInfo(String servResId) {
        return provisionDAO.getServiceResInfo(servResId);
    }
    public ServiceResTO getServiceRes(String isvServiceId) {
        List<ServiceResTO> serviceResList = provisionDAO.getServiceResList(isvServiceId);
        if(serviceResList != null && serviceResList.size()>0){
            return serviceResList.get(0);
        }else{
            return null;
        }
        
    }

    public IsvServiceTO getIsvServiceInfo(String isvServiceId) {
        return provisionDAO.getIsvServiceInfo(isvServiceId);
    }

    public IsvAdaptorTO getSvcAdaptor(String adaptorId) {
        return provisionDAO.getIsvAdaptor(adaptorId);
    }

    public int updateIsvService(IsvServiceTO isvServiceTO) {
        int result = provisionDAO.updateIsvService(isvServiceTO);
        if (0 == result) {
            throw new SCServiceException(IAppsConstants.ERROR_MESSAGE_UPDATE);
        }
        return result;
    }
//    
//    public void suspendGoogleDomain(String domainId, boolean isSuspend) {
//        try {
//            // get domain product list
//            Domain2ProductTO domain2ProductTO = new Domain2ProductTO();
//            domain2ProductTO.setDomainId(domainId);
//            domain2ProductTO.setDomainProductStatus(IAppsConstants.PRODUCT_STATUS_ACTIVE);
//            List<Domain2ProductTO> domain2ProductList = domain2ProductService.getDomain2ProductList(domain2ProductTO);
//
//            // get the GOOGLE application, and suspend GOOGLE domain
//            for (Domain2ProductTO domainProductParam : domain2ProductList) {
//                if (IAppsConstants.SERVICE_GOOGLE_APP.equals(domainProductParam.getServiceId())) {
//                    IsvAdaptorTO adaptorTO = getSvcAdaptor(IsvConstants.ISV_ADAP_GOOGLE_SUSPEND_DOMAIN);
//
//                    if (appContext == null) {
//                        appContext = SpringApplicationContextHolder.get();
//                    }
//
//                    AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
//
//                    Map<String, String> domainProductMap = new HashMap<String, String>();
//                    domainProductMap.put(IAppsConstants.SERVICE_MAP_DOMAIN_PRODUCT_ID, domainProductParam.getDomainProductId());
//                    domainProductMap.put(IAppsConstants.SERVICE_MAP_DOMAIN_ID, domainId);
//                    domainProductMap.put(IAppsConstants.SERVICE_MAP_IS_SUSPEND, new Boolean(isSuspend).toString());
//
//                    adaptor.execute(domainProductMap, new HashMap<String, String>());
//                }
//            }
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when suspend google domain.", e);
//        }
//    }
//    
//    public void suspendBackupLicense(String domainId){
//        try {
//            Domain2ProductTO domain2Product = new Domain2ProductTO();
//            domain2Product.setServiceId(IsvFSecureBackupConstants.FSECURE_ONLINE_BACKUP_SERVICE_ID);
//            domain2Product.setDomainId(domainId);
//            List<Domain2ProductTO> activeDomainProductList = domain2ProductService.getActiveDomain2ProductList(domain2Product);
//            for(Domain2ProductTO domain2product : activeDomainProductList){
//                
//                //domain2product :to be suspend/Active/NULL
//                if (StringUtils.isEmpty(domain2product.getExt1()) || IsvFSecureBackupConstants.SUBSCRIPTION_STATUS_TOBE_SUSPEND.equalsIgnoreCase(domain2product.getExt1())
//                        ||IsvFSecureBackupConstants.SUBSCRIPTION_STATUS_ACTIVE.equalsIgnoreCase(domain2product.getExt1())) {
//                    UserProductTO userProduct = new UserProductTO();
//                    userProduct.setServiceId(IsvFSecureBackupConstants.FSECURE_ONLINE_BACKUP_SERVICE_ID);
//                    userProduct.setDomainProductId(domain2product.getDomainProductId());
//                    userProduct.setDomainId(domain2product.getDomainId());
//                    List<UserProductTO> userProductList = userProductService.getAllAssignedUserProducts(userProduct);
//                    fsecureBackupServiceHelper.suspendUserProductLicenses(userProductList,IsvFSecureBackupConstants.SUSPEND_COMPANY_LICENSE);
//                }
//            }
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when suspend backup license.", e);
//        }
//    }
//    
//    
//    public void reactiveBackupLicense(String domainId){
//        try {
//            Domain2ProductTO domain2Product = new Domain2ProductTO();
//            domain2Product.setServiceId(IsvFSecureBackupConstants.FSECURE_ONLINE_BACKUP_SERVICE_ID);
//            domain2Product.setDomainId(domainId);
//            List<Domain2ProductTO> activeDomainProductList = domain2ProductService.getActiveDomain2ProductList(domain2Product);
//            for(Domain2ProductTO domain2product : activeDomainProductList){
//                
//                //domain2product :to be suspend/Active/NULL
//                if (StringUtils.isEmpty(domain2product.getExt1()) || IsvFSecureBackupConstants.SUBSCRIPTION_STATUS_TOBE_SUSPEND.equalsIgnoreCase(domain2product.getExt1())
//                        ||IsvFSecureBackupConstants.SUBSCRIPTION_STATUS_ACTIVE.equalsIgnoreCase(domain2product.getExt1())) {
//                    UserProductTO userProduct = new UserProductTO();
//                    userProduct.setServiceId(IsvFSecureBackupConstants.FSECURE_ONLINE_BACKUP_SERVICE_ID);
//                    userProduct.setDomainProductId(domain2product.getDomainProductId());
//                    userProduct.setDomainId(domain2product.getDomainId());
//                    List<UserProductTO> userProductList = userProductService.getAllAssignedUserProducts(userProduct);
//                    fsecureBackupServiceHelper.reactiveUserProductLicenses(userProductList,IsvFSecureBackupConstants.SUSPEND_COMPANY_LICENSE);
//                }
//            }
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when reinstae backup license.", e);
//        }
//    }

    // private String getDomainIdByName(String domainName) {
    // List<DomainTO> domainList = domainService.searchDomain(domainName, null, null);
    // if (domainList != null && domainList.getTotalFound() > 0) {
    // DomainTO domainTO = domainList.get(0);
    // return domainTO.getDomainId();
    // } else {
    // return null;
    // }
    // }

    public CustomerInfoTO getCustomerInfo(String isvServiceId) {
        return provisionDAO.getCustomerInfo(isvServiceId);
    }

    public CustomerInfoTO getCustomerInfoByDomainProductId(String domainProductId) {
        return provisionDAO.getCustomerInfoByDomainProductId(domainProductId);
    }

    public CustomerInfoTO getCustomerInfoFromOldPackage(String isvServiceId) {
        return provisionDAO.getCustomerInfoFromOldPackage(isvServiceId);
    }

    public UserInfoTO getUserInfo(String isvServiceId) {
        return provisionDAO.getUserInfo(isvServiceId);
    }

    public CustomerInfoTO getOldDomainPackage(String isvServiceId) {
        return provisionDAO.getOldDomainPackage(isvServiceId);
    }


    private String getPropertyAsString(String key) {
//        return config.getPropertyAsString(IAppsConstants.SAAS_PROVISION, key, "");
    	return null;
    }

    public String getSvcAdaptor(String svcDefName, String svcDefCategory, String svcDefOperation) {
        return this.provisionDAO.getSvcAdaptor(svcDefName, svcDefCategory, svcDefOperation);
    }

    public List<IsvServiceDefTO> getIsvServiceDef(String isvServiceDefName, String isvServiceDefCategory,
            String isvServiceDefOperation, String serviceDefVersion) {
        return provisionDAO.getIsvServiceDefList(isvServiceDefName, isvServiceDefCategory, isvServiceDefOperation,
                serviceDefVersion);
    }

    public IsvServiceDefTO getIsvServiceDef(IsvServiceTO isvServiceTO) {
        List<IsvServiceDefTO> list = provisionDAO.getIsvServiceDefList(isvServiceTO.getServiceName(), isvServiceTO
                .getServiceCategory(), isvServiceTO.getServiceOperation(), isvServiceTO.getServiceDefVersion());
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }
//
//    public void updateGoogleUserName(String userId, String userName) {
//        // update user password to google
//        try {
//            UserProductTO userProductTO = new UserProductTO();
//            userProductTO.setUserId(userId);
//            userProductTO.setServiceId(IAppsConstants.SERVICE_GOOGLE_APP);
//            List<UserProductTO> userProductList = userProductService
//                    .getUserProductListByUserIdAndServiceId(userProductTO);
//            for (UserProductTO userProductParam : userProductList) {
//                IsvAdaptorTO adaptorTO = this.getSvcAdaptor(IsvConstants.ISV_ADAP_GOOGLE_UPDATE_LOGINID);
//                if (appContext == null) {
//                    appContext = SpringApplicationContextHolder.get();
//                }
//                AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
//                Map<String, String> userProductMap = new HashMap<String, String>();
//                userProductMap.put(IAppsConstants.SERVICE_MAP_USER_PRODUCT_ID, userProductParam.getUserProductId());
//                userProductMap.put(IAppsConstants.SERVICE_MAP_USER_NAME, userName);
//                adaptor.execute(userProductMap, new HashMap<String, String>());
//            }
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when update user google password.", e);
//        }
//    }
//    
//    public void updateWebsms(UserTO newUserTO) {
//        // update user password to google
//        try {
//            UserProductTO userProductTO = new UserProductTO();
//            userProductTO.setUserId(newUserTO.getUserId());
//            userProductTO.setServiceId(IsvWebsmsConstants.SERVICE_WEBSMS_APP);
//            List<UserProductTO> userProductList = userProductService
//                    .getUserProductListByUserIdAndServiceId(userProductTO);
//            for (UserProductTO userProduct:userProductList) {
//                IsvAdaptorTO adaptorTO = this.getSvcAdaptor(IsvWebsmsConstants.ISV_ADAP_WEBSMS_UPDATE_USER);
//                if (appContext == null) {
//                    appContext = SpringApplicationContextHolder.get();
//                }
//                AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
//                Map<String, String> paraMap = new HashMap<String, String>();
//                paraMap.put(IsvWebsmsConstants.SERVICE_MAP_LOGIN_ID, newUserTO.getLoginId());
//                paraMap.put(IsvWebsmsConstants.SERVICE_MAP_USER_ID, newUserTO.getUserId());
//                paraMap.put(IsvWebsmsConstants.SERVICE_MAP_ROLE, newUserTO.getLoginRoleId());
//                paraMap.put(IsvWebsmsConstants.SERVICE_MAP_DOMAIN_ID, newUserTO.getDomainId());
//                paraMap.put(IsvWebsmsConstants.SERVICE_MAP_USER_PRODUCT_ID, userProduct.getUserProductId());
//                adaptor.execute(paraMap, new HashMap<String, String>());
//            }
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when update user google password.", e);
//        }
//    }
//    
//    public void updateWebfax(UserTO newUserTO) {
//        // update user info to webfax
//        try {
//            UserProductTO userProductTO = new UserProductTO();
//            userProductTO.setUserId(newUserTO.getUserId());
//            userProductTO.setServiceId(IsvWebfaxConstants.SERVICE_WEBFAX_APP);
//            List<UserProductTO> userProductList = userProductService.getUserProductListByUserIdAndServiceId(userProductTO);
//            for (UserProductTO userProduct : userProductList) {
//                IsvAdaptorTO adaptorTO = this.getSvcAdaptor(IsvWebfaxConstants.ISV_ADAP_WEBFAX_UPDATE_USER);
//                if (appContext == null) {
//                    appContext = SpringApplicationContextHolder.get();
//                }
//                AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
//                Map<String, String> paraMap = new HashMap<String, String>();
//                paraMap.put(IsvWebfaxConstants.SERVICE_MAP_LOGIN_ID, newUserTO.getLoginId());
//                paraMap.put(IsvWebfaxConstants.SERVICE_MAP_USER_ID, newUserTO.getUserId());
//                paraMap.put(IsvWebfaxConstants.SERVICE_MAP_ROLE, newUserTO.getLoginRoleId());
//                paraMap.put(IsvWebfaxConstants.SERVICE_MAP_DOMAIN_ID, newUserTO.getDomainId());
//                paraMap.put(IsvWebfaxConstants.SERVICE_MAP_USER_PRODUCT_ID, userProduct.getUserProductId());
//                paraMap.put(IsvWebfaxConstants.SERVICE_MAP_FIRST_NAME, newUserTO.getFirstName());
//                paraMap.put(IsvWebfaxConstants.SERVICE_MAP_LAST_NAME, newUserTO.getLastName());
//                adaptor.execute(paraMap, new HashMap<String, String>());
//            }
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when update user google password.", e);
//        }
//    }
//    
//
//    /**
//     * this method is used to update GOOGLE user information(firstName, lastName, role)
//     * 
//     * @param newUser
//     * @param oldUser
//     */
//    public void updateGoogleUser(UserTO newUser, UserTO oldUser) {
//        try {
//            if (newUser.getFirstName().equals(oldUser.getFirstName())
//                    && newUser.getLastName().equalsIgnoreCase(oldUser.getLastName())
//                    && newUser.getLoginRoleId().equals(oldUser.getLoginRoleId())) {
//                return;
//            } else {
//                UserProductTO userProductTO = new UserProductTO();
//                userProductTO.setUserId(newUser.getUserId());
//                userProductTO.setServiceId(IAppsConstants.SERVICE_GOOGLE_APP);
//                List<UserProductTO> userProductList = userProductService
//                        .getUserProductListByUserIdAndServiceId(userProductTO);
//
//                for (UserProductTO userProductParam : userProductList) {
//                    IsvAdaptorTO adaptorTO = this.getSvcAdaptor(IsvConstants.ISV_ADAP_GOOGLE_UPDATE_USER);
//
//                    if (appContext == null) {
//                        appContext = SpringApplicationContextHolder.get();
//                    }
//
//                    AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
//
//                    Map<String, String> userProductMap = new HashMap<String, String>();
//                    userProductMap.put(IAppsConstants.SERVICE_MAP_USER_PRODUCT_ID, userProductParam.getUserProductId());
//                    userProductMap.put(IAppsConstants.SERVICE_MAP_USER_FIRSTNAME, newUser.getFirstName());
//                    userProductMap.put(IAppsConstants.SERVICE_MAP_USER_LASTNAME, newUser.getLastName());
//                    userProductMap.put(IAppsConstants.SERVICE_MAP_USER_ROLE, newUser.getLoginRoleId());
//
//                    adaptor.execute(userProductMap, new HashMap<String, String>());
//                }
//            }
//
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when update user google", e);
//        }
//    }
//
//    public void updateGoogleUserPassword(String userId, String password) {
//        // update user password to google
//        try {
//            UserProductTO userProductTO = new UserProductTO();
//            userProductTO.setUserId(userId);
//            userProductTO.setServiceId(IAppsConstants.SERVICE_GOOGLE_APP);
//            List<UserProductTO> userProductList = userProductService
//                    .getUserProductListByUserIdAndServiceId(userProductTO);
//            for (UserProductTO userProductParam : userProductList) {
//                IsvAdaptorTO adaptorTO = this.getSvcAdaptor(IsvConstants.ISV_ADAP_GOOGLE_UPDATE_USER_PASSWORD);
//                if (appContext == null) {
//                    appContext = SpringApplicationContextHolder.get();
//                }
//                AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
//                Map<String, String> userProductMap = new HashMap<String, String>();
//                userProductMap.put(IAppsConstants.SERVICE_MAP_USER_PRODUCT_ID, userProductParam.getUserProductId());
//                userProductMap.put(IAppsConstants.SERVICE_MAP_USER_PASSWORD, password);
//                adaptor.execute(userProductMap, new HashMap<String, String>());
//            }
//        } catch (Exception e) {
//            log.error("[SaaSconnect] Error occured when update user google password.", e);
//        }
//    }
//    
    public void provisionRequestAction(String reqId,String status,String operation) {
    	List<IsvServiceTO> isvServiceList = provisionDAO.getIsvServiceList(reqId);
    	for(IsvServiceTO isvServiceTO : isvServiceList){
    		if(status.equalsIgnoreCase(isvServiceTO.getProvisionServStatus())){
    			isvServiceTO.setServiceOperation(operation);
    			IsvServiceDefTO isvServiceDefTO = getIsvServiceDef(isvServiceTO);
    			if(isvServiceDefTO!=null){
    				IsvAdaptorTO adaptorTO = provisionDAO.getIsvAdaptor(isvServiceDefTO.getIsvProvAdaptorId());
        			AdaptorService adaptor = (AdaptorService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
        			Map<String, String> serviceMap = new HashMap<String, String>();
                    serviceMap.put(IAppsConstants.SERVICE_MAP_SERVICE_ID, isvServiceTO.getIsvServiceId());
        			adaptor.execute(new HashMap<String,String>(),serviceMap);
    			}
    		}
    	}
    }

    public List<IsvServiceParaTO> getIsvServiceParaList(String isvServiceId) {
        return provisionDAO.getIsvServiceParaList(isvServiceId);
    }

    public List<IsvServiceParaDefTO> getIsvServiceParaDef(String isvServiceDefId) {
        return provisionDAO.getIsvServiceParaDefList(isvServiceDefId);
    }
    
    public IsvServiceParaTO getIsvServicePara(String isvServiceParaId){
    	return provisionDAO.getIsvServicePara(isvServiceParaId);
    }
    
    public int updateIsvServicePara(IsvServiceParaTO isvServiceParaTO){
    	return provisionDAO.updateIsvServicePara(isvServiceParaTO);
    }

    public ProductOrderService getProductOrderService() {
        return productOrderService;
    }

    public void setProductOrderService(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }


    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        this.appContext = appContext;
    }

    private Logger logger = LoggerFactory.getLogger(ProvisionServiceImpl.class);
    
    public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

    public ProvisionDAO getProvisionDAO() {
        return provisionDAO;
    }

    public void setProvisionDAO(ProvisionDAO provisionDAO) {
        this.provisionDAO = provisionDAO;
    }

   
    public UserProductService getUserProductService() {
        return userProductService;
    }

    public void setUserProductService(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public PackageService getPackageService() {
        return packageService;
    }

    public void setPackageService(PackageService packageService) {
        this.packageService = packageService;
    }

    public Domain2ProductService getDomain2ProductService() {
        return domain2ProductService;
    }

    public void setDomain2ProductService(Domain2ProductService domain2ProductService) {
        this.domain2ProductService = domain2ProductService;
    }
    
   
    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    public int createCaptureRequest(ProvisionCaptureTO provisionCaptureTO) {
        return provisionDAO.createCapture(provisionCaptureTO);
    }
    
    public int updateCaptureRequest(ProvisionCaptureTO provisionCaptureTO) {
        return provisionDAO.updateCapture(provisionCaptureTO);
    }
    
    public List<ProvisionCaptureTO> getCaptureRequest(String captureId) {
        return provisionDAO.getCapture(captureId);
    }
    
    public List<ProvisionCaptureTO> getCaptureByTransactionId(String transactionId) {
        return provisionDAO.getCaptureByTransactionId(transactionId);
    }

	@Override
	public List<ProvisionCaptureTO> searchCaptureList(ProvisionCaptureTO provisionCaptureTO) {
		return provisionDAO.searchCaptureList(provisionCaptureTO);
	}
}
