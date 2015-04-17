/*
 *  =========================================================================
 * Program Name: package com.saas.order.service.OrderServiceImpl
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
 * v1.3.0     - Initial Release         jixiaowei                   Mar 2, 2011
 * =====================================================================================
 */
package com.saas.order.service;

import java.util.List;

import com.saas.common.ConcurrentUpdateException;
import com.saas.common.DaoRunTimeException;
import com.saas.common.exception.SCServiceException;
import com.saas.order.dao.OrderDAO;
import com.saas.order.to.OrderTO;
import com.saas.pckge.to.PackageOrderTO;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public void createOrder(OrderTO order) {
    	orderDAO.createOrder(order);
    }

    public void updateOrder(OrderTO order) {
        try {
            int result = orderDAO.updateOrder(order);

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
    
    
    public void editOrder(OrderTO order) {
        try {
            int result = orderDAO.editOrder(order);

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

    public void deleteOrder(OrderTO order) {
        try {
            int result = orderDAO.deleteOrder(order);
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

    public OrderTO getOrder(OrderTO order) {
        return orderDAO.getOrder(order);
    }

    public List<OrderTO> getOrderList(OrderTO order) {
        return orderDAO.getOrderList(order);
    }

    public List<OrderTO> searchOrderList(OrderTO order) {
        return orderDAO.searchOrderList(order);
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

//    public List<OrderTO> loadOrderList(OrderTO order,TenantTO tenantTO,PackageOrderTO packageOrderTO) {
//        return this.orderDAO.loadOrderList(order,tenantTO,packageOrderTO);
//    }
}