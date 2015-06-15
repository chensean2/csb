package com.saas.provision.dao;

import java.util.List;

import com.saas.provision.service.CustomerInfoTO;
import com.saas.provision.service.UserInfoTO;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.to.IsvServiceDefTO;
import com.saas.provision.to.IsvServiceParaDefTO;
import com.saas.provision.to.IsvServiceParaTO;
import com.saas.provision.to.IsvServiceTO;
import com.saas.provision.to.NotificationTO;
import com.saas.provision.to.ProvisionCaptureTO;
import com.saas.provision.to.ProvisionSearchTO;
import com.saas.provision.to.ProvisionTO;
import com.saas.provision.to.ServiceResDetailTO;
import com.saas.provision.to.ServiceResTO;

public interface ProvisionDAO {
    //operation of ProvisionRequest
    public int createProvisionRequest(ProvisionTO provisionTO);

    public int updateProvisionRequest(ProvisionTO provisionTO);

    public int deleteProvisionRequest(ProvisionTO provisionTO);

    public ProvisionTO getProvisionRequest(String reqId);

    public List<ProvisionTO> getProvisionReqIdListByJobType(String status);

    //operation of IsvService
    public int createIsvService(IsvServiceTO isvServiceTO);

    public int updateIsvService(IsvServiceTO isvServiceTO);

    public int deleteIsvService(IsvServiceTO isvServiceTO);

    public IsvServiceTO getIsvService(String isvServiceId);

    public List<IsvServiceTO> getIsvServiceList(String reqId);

    //operation of IsvServiceDef
    public IsvServiceDefTO getIsvServiceDef(String isvServiceDefId);

    public List<IsvServiceDefTO> getIsvServiceDefList(String isvServiceDefName, String isvServiceDefCategory,
            String isvServiceDefOperation,String serviceDefVersion);

    //operation of IsvServicePara
    public int createIsvServicePara(IsvServiceParaTO isvServiceParaTO);

    public int deleteIsvServicePataAll(IsvServiceParaTO isvServiceParaTO);

    public IsvServiceParaTO getIsvServicePara(String isvServiceParaId);

    public List<IsvServiceParaTO> getIsvServiceParaList(String isvServiceId);

    //operation of IsvServiceParaDef
    public List<IsvServiceParaDefTO> getIsvServiceParaDefList(String isvServiceDefId);

    //operation of IsvAdaptor
    public IsvAdaptorTO getIsvAdaptor(String isvAdaptorId);

    //operation of ServiceRes
    public int createServiceRes(ServiceResTO serviceResTO);

    public List<ServiceResTO> getServiceResList(String isvServiceId);

    public int updateServiceRes(ServiceResTO serviceResTO);

    //operation of notification
    public int createNotification(NotificationTO notificationTO);

    public List<NotificationTO> getNotification(String reqId);

    public int updateNotification(NotificationTO notificationTO);

    //operation of servResDetail
    public void deleteServiceResDetailAll(String servResId);

    public int createServiceResDetail(ServiceResDetailTO servResDetailTO);

    //provision admin
    public List<ProvisionTO> getProvision(ProvisionSearchTO provisionSearchTO);
    
    public List<ProvisionTO> getProvisionList(ProvisionTO provisionTO);

    public List<IsvServiceTO> getProvisionDetail(String reqId);
    
    public List<IsvServiceTO> searchProvisionDetail(String reqId);

    public IsvServiceTO getIsvServiceInfo(String isvServiceId);
	
    
    public String getSvcAdaptor(String svcDefName, String svcDefCategory, String svcDefOperation);
    
    public ProvisionTO getProvision(String reqId);

    public List<IsvServiceParaTO> getIsvServiceDetail(String isvServiceId);

    public List<ServiceResTO> getServiceResponseList(String isvServiceId);

    public List<ServiceResDetailTO> getResponseDetailList(String servResId);

    public ServiceResTO getServiceResInfo(String servResId);
    
    public CustomerInfoTO getCustomerInfo(String isvServiceId);
    public CustomerInfoTO getCustomerInfoByDomainProductId(String domainProductId);
    public CustomerInfoTO getCustomerInfoFromOldPackage(String isvServiceId);
    public CustomerInfoTO getOldDomainPackage(String isvServiceId);
    
    public UserInfoTO getUserInfo(String isvServiceId);
    
    public int updateIsvServicePara(IsvServiceParaTO isvServiceParaTO);
    
    //operation of capture
    public int createCapture(ProvisionCaptureTO provisionCaptureTO);

    public List<ProvisionCaptureTO> getCapture(String captureId);

    public int updateCapture(ProvisionCaptureTO provisionCaptureTO);
    
    public List<ProvisionCaptureTO> getCaptureByTransactionId(String transactionId);

	public List<ProvisionCaptureTO> searchCaptureList(ProvisionCaptureTO provisionCaptureTO);

}
