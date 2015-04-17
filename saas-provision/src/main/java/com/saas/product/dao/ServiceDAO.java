/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.AASvcDAO
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
package com.saas.product.dao;

import java.util.List;

import com.saas.product.to.ServiceExtTO;
import com.saas.product.to.ServiceSubTO;
import com.saas.product.to.ServiceTO;

public interface ServiceDAO {

    public int createService(ServiceTO serviceTO);

    public int updateService(ServiceTO serviceTO);

    public int deleteService(ServiceTO serviceTO);

    public ServiceTO getService(ServiceTO serviceTO);

    public List<ServiceTO> getServiceList(ServiceTO serviceTO);
    
    public List<ServiceTO> getActiveServiceList(ServiceTO serviceTO);

    public List<ServiceTO> searchServiceList(ServiceTO serviceTO);
    
    public int createServiceExt(ServiceExtTO serviceExtTO);
    
    public int updateServiceExt(ServiceExtTO serviceExtTO);
    
    public int deleteServiceExt(ServiceExtTO serviceExtTO);
    
    public ServiceExtTO getServiceExt(ServiceExtTO serviceExtTO);
    
    public List<ServiceExtTO> getServiceExtList(ServiceExtTO serviceExtTO);
    
    public List<ServiceExtTO> searchServiceExtList(ServiceExtTO serviceExtTO);

    public List<ServiceSubTO> loadUserExpandSubService(String userId);
    
    
    public List<ServiceSubTO> loadUserSubService(ServiceSubTO serviceSubTO);
    
    public List<ServiceSubTO> loadUserSubServiceByServiceId(ServiceSubTO serviceSubTO);
    
    public ServiceSubTO getServiceSub(ServiceSubTO serviceSubTO);
    
    
    public List<ServiceTO> getServiceListByIssuer(String issuer);
}