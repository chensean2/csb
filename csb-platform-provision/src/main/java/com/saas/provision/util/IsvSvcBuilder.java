package com.saas.provision.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.csb.common.IAppsConstants;
import com.csb.common.SequenceUUID;
import com.saas.provision.to.IsvServiceParaTO;
import com.saas.provision.to.IsvServiceTO;
import com.saas.provision.to.ProvisionTO;

public class IsvSvcBuilder {

/**
 * This method is to populate provision request in order to provision framework can recognize the request. 
 * @param customerId
 * @param serviceList
 * @return
 */
    public static ProvisionTO populateProvision(String domainId, List<IsvSvc> serviceList){
     // Step1: populate common provision
        ProvisionTO provisionTO = new ProvisionTO();
        provisionTO.setCustomerId(domainId);
        provisionTO.setNotifRecipient("");
        provisionTO.setReqRecTime(new Timestamp(new Date().getTime()));
        provisionTO.setReqEffTime(new Timestamp(new Date().getTime()));
        provisionTO.setProvStartTime(new Timestamp(new Date().getTime()));
        provisionTO.setProvEndTime(new Timestamp(new Date().getTime()));
//        provisionTO.setRollbackStartTime(new Timestamp(new Date().getTime()));
//        provisionTO.setRollbackEndTime(new Timestamp(new Date().getTime()));
        provisionTO.setProvSendTimes(0);
//        provisionTO.setProvStatus(IAppsConstants.PROVISION_STATUS_PENDING);
        provisionTO.setRollbackSendTimes(0);
        provisionTO.setReqId(SequenceUUID.getInstance().getUUID());
        provisionTO.setReqNo(SequenceUUID.getInstance().getUUID());
        // Step2: populate isv service
        List<IsvServiceTO> isvServiceList = new ArrayList<IsvServiceTO>();
        for(int i = 0; i < serviceList.size(); i++){
            IsvSvc isvSvc = serviceList.get(i);
            IsvServiceTO isvServiceTO = new IsvServiceTO();
            isvServiceTO.setServiceName(isvSvc.getServiceName());
            isvServiceTO.setServiceCategory(isvSvc.getServiceCategory());
            isvServiceTO.setServiceOperation(isvSvc.getServiceOperation());
            isvServiceTO.setServiceDefVersion(isvSvc.getSvcDefVersion());
            isvServiceTO.setRequestNum(SequenceUUID.getInstance().getUUID());
            isvServiceTO.setServiceSeq(i);
            isvServiceTO.setProvisionServStatus(IAppsConstants.PROVISION_SERVICE_STATUS_INPROCESS);
            isvServiceTO.setIsvServiceId(SequenceUUID.getInstance().getUUID());
            isvServiceTO.setReqId(provisionTO.getReqId()); 
         // populate parameters for each service.
            List<IsvServiceParaTO> isvServiceParaList = new ArrayList<IsvServiceParaTO>();
            isvServiceTO.setIsvServiceParaList(isvServiceParaList);
            Map<String, String> newParemeterMap = isvSvc.getNewParamterMap();
            Map<String, String> oldParemeterMap = isvSvc.getOldParamterMap();
            for(String key : newParemeterMap.keySet()){
                populateIsvServiceParameter(isvServiceTO, key, newParemeterMap.get(key), oldParemeterMap.get(key));
            }
            isvServiceList.add(isvServiceTO);
        }
       
        provisionTO.setIsvServiceList(isvServiceList);
        return provisionTO;
    }
    
    private static void populateIsvServiceParameter(IsvServiceTO isvServiceTO, String paramName, String paramNewValue, String paramOldValue) {
        List<IsvServiceParaTO> isvServiceParaList = isvServiceTO.getIsvServiceParaList();
        IsvServiceParaTO isvServiceParaTO = new IsvServiceParaTO();
        isvServiceParaTO.setIsvServiceParaId(SequenceUUID.getInstance().getUUID());
        isvServiceParaTO.setServiceParaName(paramName);
        if(StringUtils.isNotEmpty(paramNewValue)){
        	isvServiceParaTO.setServiceParaNewValue(paramNewValue.trim());
        }else{
        	isvServiceParaTO.setServiceParaNewValue(paramNewValue);
        }
        
        if(StringUtils.isNotEmpty(paramOldValue)){
        	isvServiceParaTO.setServiceParaOldValue(paramOldValue.trim());
        }else{
        	isvServiceParaTO.setServiceParaOldValue(paramOldValue);
        }
        
        isvServiceParaTO.setIsvServiceId(isvServiceTO.getIsvServiceId());

        isvServiceParaList.add(isvServiceParaTO);
    }

}
