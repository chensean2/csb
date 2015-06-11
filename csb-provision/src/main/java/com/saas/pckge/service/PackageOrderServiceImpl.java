/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.PackageOrderServiceImpl
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
 * v1.0     - Initial Release         jixiaowei                   Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.service;

import java.util.List;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.DaoRunTimeException;
import com.csb.common.exception.SCServiceException;
import com.saas.order.service.OrderService;
import com.saas.pckge.dao.PackageOrderDAO;
import com.saas.pckge.to.PackageOrderTO;

public class PackageOrderServiceImpl implements PackageOrderService {

    private PackageOrderDAO packageOrderDAO;
	private OrderService orderService;
    private Domain2PackageService domain2PackageService;
    
    public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Domain2PackageService getDomain2PackageService() {
		return domain2PackageService;
	}

	public void setDomain2PackageService(Domain2PackageService domain2PackageService) {
		this.domain2PackageService = domain2PackageService;
	}

    public void createPackageOrder(PackageOrderTO packageOrder) {
        packageOrderDAO.createPackageOrder(packageOrder);
    }

    public void updatePackageOrder(PackageOrderTO packageOrder) {
        try {
            int result = packageOrderDAO.updatePackageOrder(packageOrder);

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

    public void deletePackageOrder(PackageOrderTO packageOrder) {
        try {
            int result = packageOrderDAO.deletePackageOrder(packageOrder);
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
    public void deletePackageOrderByOrderId(PackageOrderTO packageOrder){
    	   try {
               int result = packageOrderDAO.deletePackageOrderByOrderId(packageOrder);
              
           } catch (DaoRunTimeException e) {
               if (e.getWrappedException() instanceof ConcurrentUpdateException) {
                   throw new ConcurrentUpdateException();
               } else {
                    throw new SCServiceException(e);
               }
           }
    }

    public PackageOrderTO getPackageOrder(PackageOrderTO packageOrder) {
        return packageOrderDAO.getPackageOrder(packageOrder);
    }

    public List<PackageOrderTO> getPackageOrderList(PackageOrderTO packageOrder) {    	
        return packageOrderDAO.getPackageOrderList(packageOrder);
    }

    public List<PackageOrderTO> searchPackageOrderList(PackageOrderTO packageOrder) {
        return packageOrderDAO.searchPackageOrderList(packageOrder);
    }

    public void setPackageOrderDAO(PackageOrderDAO packageOrderDAO) {
        this.packageOrderDAO = packageOrderDAO;
    }

    public PackageOrderDAO getPackageOrderDAO() {
        return packageOrderDAO;
    }
}