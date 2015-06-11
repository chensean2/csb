package com.saas.provision.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.csb.common.SpringApplicationContextHolder;
import com.saas.provision.service.ProvisionService;
import com.saas.provision.to.IsvServiceDefTO;
import com.saas.provision.to.IsvServiceParaDefTO;

public class IsvSvcImpl implements IsvSvc {

    protected String svcDefName;
    protected String svcDefCatetroy;
    protected String svcDefOperation;
    protected String svcDefVersion;
    private Map<String, String> newParamterMap = new HashMap<String, String>();
    private Map<String, String> oldParamterMap = new HashMap<String, String>();

    public IsvSvcImpl(String svcDefName, String svcDefCatetroy, String svcDefOperation, String svcDefVersion) {
        this.svcDefName = svcDefName;
        this.svcDefCatetroy = svcDefCatetroy;
        this.svcDefOperation = svcDefOperation;
        this.svcDefVersion = svcDefVersion;
    }
    //
    public void prepareIsvSvcDefParameter(String[] paramArray) {
        if (paramArray == null || paramArray.length == 0) {
            return;
        }
        ApplicationContext appContext = SpringApplicationContextHolder.get();
        ProvisionService provisionService = (ProvisionService) appContext.getBean("provisionService");
        List<IsvServiceDefTO> isvServiceDefList = provisionService.getIsvServiceDef(svcDefName, svcDefCatetroy,
                svcDefOperation, svcDefVersion);
        if (isvServiceDefList.size() > 0) {
            IsvServiceDefTO isvServiceDefTO = isvServiceDefList.get(0);
            List<IsvServiceParaDefTO> isvServiceParaDefList = provisionService.getIsvServiceParaDef(isvServiceDefTO
                    .getIsvServiceDefId());
            // newParamterMap.put(returnPara.get(i), paramList.get(i));
            if (isvServiceParaDefList.size() > 0) {
                for (int i = 0; i < isvServiceParaDefList.size(); i++) {
                    newParamterMap.put(isvServiceParaDefList.get(i).getIsvServiceParaName(), paramArray[i]);
                }
            }
        }
    }

    public Map<String, String> getNewParamterMap() {
        return newParamterMap;
    }

    public Map<String, String> getOldParamterMap() {
        return oldParamterMap;
    }

    public String getServiceCategory() {
        return svcDefCatetroy;
    }

    public String getServiceName() {
        return svcDefName;
    }

    public String getServiceOperation() {
        return svcDefOperation;
    }
	public String getSvcDefVersion() {
		return svcDefVersion;
	}

}
