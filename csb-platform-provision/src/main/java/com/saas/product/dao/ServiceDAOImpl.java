/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.serviceTODAOImpl
 *
 * Copyright 2009 saas Pte. Ltd. All Rights Reserved
 *
 * This software is confidential and proprietary to saas Pte. Ltd. You shall
 * use this software only in accordance with the terms of the license
 * agreement you entered into with saas.  No aspect or part or all of this
 * software may be reproduced, modified or disclosed without full and
 * direct written authorisation from saas.
 *
 * saas SUPPLIES THIS SOFTWARE ON AN "AS IS" BASIS. saas MAKES NO
 * REPRESENTATIONS OR WARRANTIES, EITHER EXPRESSLY OR IMPLIEDLY, ABOUT THE
 * SUITABILITY OR NON-INFRINGEMENT OF THE SOFTWARE. saas SHALL NOT BE LIABLE
 * FOR ANY LOSSES OR DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING,
 * MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * Change Revision
 * ----------------------------------------------------------------------------
 * Version    Remarks                  Author        Editor          Date
 * v1.0     - Initial Release         jixiaowei                   Mar 17, 2011
 * =====================================================================================
 */
package com.saas.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.product.to.ServiceExtTO;
import com.saas.product.to.ServiceSubTO;
import com.saas.product.to.ServiceTO;

public class ServiceDAOImpl extends SCBaseDAOImpl implements ServiceDAO {
    private Logger log = LoggerFactory.getLogger(ServiceDAOImpl.class);

    
    public int createService(ServiceTO serviceTO) {
        int i = create(serviceTO);
       
        return i;
    }

    public int updateService(ServiceTO serviceTO){
    	return 0;
    }
    
    public int updateServiceExt(ServiceExtTO serviceExtTO){
    	return 0;
    }
    public int deleteService(ServiceTO serviceTO) {
        ServiceTO service = this.getService(serviceTO);
        
        if (null == service) {
            throw new SCServiceException(IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
        }
        int i = delete(serviceTO);
        
        return i;
    }

    public ServiceTO getService(ServiceTO serviceTO) {
        return (ServiceTO) queryForObject(serviceTO);
    }

    public List<ServiceTO> searchServiceList(ServiceTO serviceTO) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(ServiceTO.class, pfwClient, "/service/getServiceList", paraMap);
    }
    
	public List<ServiceTO> getServiceList(ServiceTO serviceTO) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("service_id", serviceTO.getServiceId());
		map.put("service_category",serviceTO.getServiceCategory());
		map.put("service_status",serviceTO.getServiceStatus());
return null;
//		return this.pfwClient.queryForList(ServiceTO.class, "/service/getServiceList", map);
	}
	
	public List<ServiceTO> getActiveServiceList(ServiceTO serviceTO) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("service_id", serviceTO.getServiceId());
		map.put("service_category",serviceTO.getServiceCategory());
		map.put("service_status",serviceTO.getServiceStatus());
//		return this.pfwClient.queryForList(ServiceTO.class, "/service/getServiceListOrderByServiceName", map);
		return null;
	}
	
	
    
    public int createServiceExt(ServiceExtTO serviceExtTO) {
        int i = create(serviceExtTO);
        
        return i;
    }
    
    public int deleteServiceExt(ServiceExtTO serviceExtTO) {
        ServiceExtTO serviceExt = this.getServiceExt(serviceExtTO);
        
        if (null == serviceExt) {
            throw new SCServiceException(IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
        }
        int i = delete(serviceExtTO);
       
        return i;
    }
    
    public ServiceExtTO getServiceExt(ServiceExtTO serviceExtTO) {
    	return (ServiceExtTO) queryForObject(serviceExtTO);
    }
    
    public List<ServiceExtTO> getServiceExtList(ServiceExtTO serviceExtTO) {
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	
    	//TODO
    	paraMap.put("service_ext_id", serviceExtTO.getServiceExtID());
    	paraMap.put("service_id", serviceExtTO.getServiceID());
    	paraMap.put("category",serviceExtTO.getCategory());
    	
//    	return pfwClient.queryForList(ServiceExtTO.class, "/service/getServiceExtList", paraMap);
    	return null;
    }

	
    public List<ServiceExtTO> searchServiceExtList(ServiceExtTO serviceExtTO) {
    	Map<String, Object> paraMap = new HashMap<String, Object>();

    	//TODO
    	return null;
    	//return PaginationEnabler.queryForList(ServiceExtTO.class, pfwClient, "/service/getServiceExtList", paraMap);
    }

	public List<ServiceSubTO> loadUserExpandSubService(String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
//		return this.pfwClient.queryForList(ServiceSubTO.class,
//				"/dashboard/loadUserExpandSubService", map);
		return null;
	}


	public List<ServiceSubTO> loadUserSubService(ServiceSubTO serviceSubTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceSubId", serviceSubTO.getServiceSubId());
//		return this.pfwClient.queryForList(ServiceSubTO.class,
//				"/service/loadUserSubService", map);
		return null;
	}
	
	public List<ServiceSubTO> loadUserSubServiceByServiceId(
			ServiceSubTO serviceSubTO) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("service_id", serviceSubTO.getServiceId());
//		return this.pfwClient.queryForList(ServiceSubTO.class,
//				"/service/loadUserSubServiceByServiceId", map);
				return null;
	}
	
	public ServiceSubTO getServiceSub(ServiceSubTO serviceSubTO) {
        return (ServiceSubTO) queryForObject(serviceSubTO);
    }
	
	
	 public List<ServiceTO> getServiceListByIssuer(String issuer){
	     Map<String, Object> map = new HashMap<String, Object>();
             map.put("issuer", issuer);
             return null;
             //return this.pfwClient.queryForList(ServiceTO.class,
//                             "/service/getServiceListByIssuer", map);
	 }
	
}