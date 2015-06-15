/*
 *  =========================================================================
O * Program Name: package com.saas.product.service.ServiceServiceImpl
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
package com.saas.product.service;

import java.util.List;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.DaoRunTimeException;
import com.csb.common.exception.SCServiceException;
import com.saas.product.dao.ServiceDAO;
import com.saas.product.to.ServiceExtTO;
import com.saas.product.to.ServiceSubTO;
import com.saas.product.to.ServiceTO;

public class ServiceImpl implements Service {

    private ServiceDAO serviceDAO;

    public void createService(ServiceTO serviceTO) {
    	serviceDAO.createService(serviceTO);
    }

    public void updateService(ServiceTO serviceTO) {
        try {
            int result = serviceDAO.updateService(serviceTO);

            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
               throw new ConcurrentUpdateException();
            } else {
               throw new SCServiceException(e);
            }
        }
    }

    public void deleteService(ServiceTO serviceTO) {
        try {
            int result = serviceDAO.deleteService(serviceTO);
            if (0 == result) {
                throw new ConcurrentUpdateException();
            }
        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
                throw new ConcurrentUpdateException();
            } else {
                 throw new SCServiceException(e);
            }
        }
    }

    public ServiceTO getService(ServiceTO serviceTO) {
        return serviceDAO.getService(serviceTO);
    }

    public List<ServiceTO> getServiceList(ServiceTO serviceTO) {
        return serviceDAO.getServiceList(serviceTO);
    }
    
    public List<ServiceTO> getActiveServiceList(ServiceTO serviceTO){
    	return serviceDAO.getActiveServiceList(serviceTO);
    }

    public List<ServiceTO> searchServiceList(ServiceTO serviceTO) {
        return serviceDAO.searchServiceList(serviceTO);
    }
    
    public void createServiceExt(ServiceExtTO serviceExtTO) {
    	serviceDAO.createServiceExt(serviceExtTO);
    }
    
    public void updateServiceExt(ServiceExtTO serviceExtTO) {
    	try {
    		int result = serviceDAO.updateServiceExt(serviceExtTO);
    		
    		if (0 == result) {
    			throw new ConcurrentUpdateException();
    		}
    	} catch (DaoRunTimeException e) {
    		if (e.getWrappedException() instanceof ConcurrentUpdateException) {
    			throw new ConcurrentUpdateException();
    		} else {
    			throw new SCServiceException(e);
    		}
    	}
    }
    
    public void deleteServiceExt(ServiceExtTO serviceExtTO) {
    	try {
    		int result = serviceDAO.deleteServiceExt(serviceExtTO);
    		if (0 == result) {
    			throw new ConcurrentUpdateException();
    		}
    	} catch (DaoRunTimeException e) {
    		if (e.getWrappedException() instanceof ConcurrentUpdateException) {
    			throw new ConcurrentUpdateException();
    		} else {
    			throw new SCServiceException(e);
    		}
    	}
    }
    
    public ServiceExtTO getServiceExt(ServiceExtTO serviceExtTO) {
    	return serviceDAO.getServiceExt(serviceExtTO);
    }
    
    public List<ServiceExtTO> getServiceExtList(ServiceExtTO serviceExtTO) {
    	return serviceDAO.getServiceExtList(serviceExtTO);
    }
    
    public List<ServiceExtTO> searchServiceExtList(ServiceExtTO serviceExtTO) {
    	return serviceDAO.searchServiceExtList(serviceExtTO);
    }

	public ServiceDAO getServiceDAO() {
		return serviceDAO;
	}

	public void setServiceDAO(ServiceDAO serviceDAO) {
		this.serviceDAO = serviceDAO;
	}

	public List<ServiceSubTO> loadUserExpandSubService(String userId) {
		return serviceDAO.loadUserExpandSubService(userId);
	}


	public List<ServiceSubTO> loadUserSubService(ServiceSubTO serviceSubTO) {
		return serviceDAO.loadUserSubService(serviceSubTO);
	}
	
	 public ServiceSubTO getServiceSub(ServiceSubTO serviceSubTO){
		 return serviceDAO.getServiceSub(serviceSubTO);
	 }

	public List<ServiceSubTO> loadUserSubServiceByServiceId(
			ServiceSubTO serviceSubTO) {
		return serviceDAO.loadUserSubServiceByServiceId(serviceSubTO);
	}
	
	 public ServiceTO getServiceByIssuer(String issuer){
	     List<ServiceTO> result = serviceDAO.getServiceListByIssuer(issuer);
	     if(result != null && result.size() == 1){
	         return result.get(0);
	     }
	     return null;
	 }
	
}