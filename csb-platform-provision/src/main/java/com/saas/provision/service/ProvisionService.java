package com.saas.provision.service;

import java.util.List;

import com.saas.common.to.UserTO;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.to.IsvServiceDefTO;
import com.saas.provision.to.IsvServiceParaDefTO;
import com.saas.provision.to.IsvServiceParaTO;
import com.saas.provision.to.IsvServiceTO;
import com.saas.provision.to.ProvisionCaptureTO;
import com.saas.provision.to.ProvisionTO;
import com.saas.provision.to.ServiceResDetailTO;
import com.saas.provision.to.ServiceResTO;

public interface ProvisionService {

    public List<String> createProvisionRequest(ProvisionTO provisionTO);

    public int updateProvisionRequest(ProvisionTO provisionTO);

    public int deleteProvisionRequest(String reqId);

    public ProvisionTO getProvisionRequest(String reqId);

    public void provisionRequest(String reqId);
    
    public void provisionRequestAction(String reqId,String status,String operation);

    public List<IsvServiceTO> getProvisionDetail(String reqId);

    public List<IsvServiceTO> searchProvisionDetail(String reqId);

    public List<ProvisionTO> getProvisionList(ProvisionTO provisionTO);

    public List<IsvServiceParaTO> getIsvServiceDetail(String isvServiceId);

    public List<ServiceResTO> getServiceResList(String isvServiceId);

    public List<ServiceResDetailTO> getResponseDetailList(String servResId);

    public ServiceResTO getServiceResInfo(String servResId);

    public IsvServiceTO getIsvServiceInfo(String isvServiceId);

    public int updateIsvService(IsvServiceTO isvServiceTO);

    public String getSvcAdaptor(String svcDefName, String svcDefCategory, String svcDefOperation);

    public List<IsvServiceDefTO> getIsvServiceDef(String svcDefName, String svcDefCatetroy, String svcDefOperation,
            String serviceDefVersion);

    public List<IsvServiceParaDefTO> getIsvServiceParaDef(String isvServiceDefId);

    public CustomerInfoTO getCustomerInfo(String isvServiceId);

    public CustomerInfoTO getCustomerInfoByDomainProductId(String domainProductId);

    public CustomerInfoTO getCustomerInfoFromOldPackage(String isvServiceId);

    public UserInfoTO getUserInfo(String isvServiceId);


    public IsvServiceDefTO getIsvServiceDef(IsvServiceTO isvServiceTO);

    public IsvAdaptorTO getSvcAdaptor(String adaptorId);

//    public void sendNotificationEmail(String reqId, List<String> noProvisionList, String sendType, String adminUserId);

    public void provisionIsvService(String isvServiceId);

//    public void sendNotificationSms(String reqId, List<String> noProvsionList, String sendType);

    public List<IsvServiceParaTO> getIsvServiceParaList(String isvServiceId);

//    public void updateGoogleUserName(String userId, String userName);
//    
//    public void updateWebsms(UserTO newUserTO);
//
//    public void updateGoogleUser(UserTO newUser, UserTO oldUser);
//
//    public void updateGoogleUserPassword(String userId, String password);
//    
//    public void suspendGoogleDomain(String domainId, boolean isSuspend);
//    
//    public void suspendBackupLicense(String domainId);
//    
//    public void reactiveBackupLicense(String domainId);
    
    public IsvServiceParaTO getIsvServicePara(String isvServiceParaId);
    
    public int updateIsvServicePara(IsvServiceParaTO isvServiceParaTO);
    
//    public void sendAutoAssignFailureNotificationEmail(String reqId, String adminUserId);
    
//    public void updateWebfax(UserTO newUserTO);
    
    public IsvAdaptorTO getSvcAdaptorTO(String serviceId, String serviceCategory, String serviceOperation);
    
//    public void sendAutoAssignNotificationEmail(String reqId, List<String> noProvsionList, String sendType, String adminUserId);
    
    public int createCaptureRequest(ProvisionCaptureTO provisionCaptureTO);

    public int updateCaptureRequest(ProvisionCaptureTO provisionCaptureTO);

    public List<ProvisionCaptureTO> getCaptureRequest(String captureId);
    
    public List<ProvisionCaptureTO> getCaptureByTransactionId(String transactionId);
    
    public List<ProvisionCaptureTO> searchCaptureList(ProvisionCaptureTO provisionCaptureTO);
    public ServiceResTO getServiceRes(String isvServiceId);
}
