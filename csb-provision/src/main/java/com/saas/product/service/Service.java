/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.ServiceService
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
 * v1.0     - Initial Release         jixiaowei                  Mar 17, 2011
 * =====================================================================================
 */
package com.saas.product.service;

import java.util.List;

import com.saas.product.to.ServiceExtTO;
import com.saas.product.to.ServiceSubTO;
import com.saas.product.to.ServiceTO;

public interface Service {

    /**
     * this method is used to create Service
     * version: 1.3.0
     */
    public void createService(ServiceTO serviceTO);

    /**
     * this method is used to update Service
     * version: 1.3.0
     */
    public void updateService(ServiceTO serviceTO);

    /**
     * this method is used to delete Service
     * version: 1.3.0
     */
    public void deleteService(ServiceTO serviceTO);

    /**
     * this method is used to search Service
     * version: 1.3.0
     */
    public ServiceTO getService(ServiceTO serviceTO);

    /**
     * this method is used to get Service List
     * version: 1.3.0
     */
    public List<ServiceTO> getServiceList(ServiceTO serviceTO);
    
    /**
     * this method is used to get Active Service List
     * version: 1.3.0
     */
    public List<ServiceTO> getActiveServiceList(ServiceTO serviceTO);

    /**
     * this method is used to search Service
     * version: 1.3.0
     */
    public List<ServiceTO> searchServiceList(ServiceTO serviceTO);
    /**
     * this method is used to create Service
     * version: 1.3.0
     */
    public void createServiceExt(ServiceExtTO serviceExtTO);
    
    /**
     * this method is used to update Service
     * version: 1.3.0
     */
    public void updateServiceExt(ServiceExtTO serviceExtTO);
    
    /**
     * this method is used to delete Service
     * version: 1.3.0
     */
    public void deleteServiceExt(ServiceExtTO serviceExtTO);
    
    /**
     * this method is used to search Service
     * version: 1.3.0
     */
    public ServiceExtTO getServiceExt(ServiceExtTO serviceExtTO);
    
    /**
     * this method is used to get Service List
     * version: 1.3.0
     */
    public List<ServiceExtTO> getServiceExtList(ServiceExtTO serviceExtTO);
    
    /**
     * this method is used to search Service
     * version: 1.3.0
     */
    public List<ServiceExtTO> searchServiceExtList(ServiceExtTO serviceExtTO);

    /**
     * this method is used to load user expand sub services by userId.
     * version: 1.3.0
     */
    public List<ServiceSubTO> loadUserExpandSubService(String userId);
    
    /**
     * this method is used to load user services by dashboardTO.
     * version: 1.3.0
     */
    /**
     * this method is used to load user services by serviceSubTO.
     * version: 1.3.0
     */
    public List<ServiceSubTO> loadUserSubService(ServiceSubTO serviceSubTO);
    
    public ServiceSubTO getServiceSub(ServiceSubTO serviceSubTO);
    
    /**
     * this method is used to load user sub services by serviceSubTO.
     * version: 1.3.0
     */
    public List<ServiceSubTO> loadUserSubServiceByServiceId(ServiceSubTO serviceSubTO);
    
    
    public ServiceTO getServiceByIssuer(String issuer);
}