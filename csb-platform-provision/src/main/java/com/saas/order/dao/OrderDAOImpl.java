/*
 *  =========================================================================
 * Program Name: package com.saas.order.dao.OrderDAOImpl
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
package com.saas.order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.order.to.OrderTO;

public class OrderDAOImpl extends SCBaseDAOImpl implements OrderDAO {
	private Logger log = LoggerFactory.getLogger(OrderDAOImpl.class);
	

	public int createOrder(OrderTO order) {
		int i = create(order);
		
		return i;
	}

	public int deleteOrder(OrderTO order) {
		OrderTO orderTem = (OrderTO) queryForObject(order);
		if (null == orderTem) {
			throw new SCServiceException(
					IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
		}
		int i = delete(order);
		 
		return i;
	}

	public int updateOrder(OrderTO order) {
		OrderTO oldOrder = (OrderTO) queryForObject(order);
		int i = update(order);
		 
		return i;
	}

	public int editOrder(OrderTO order) {
		OrderTO oldOrder = (OrderTO) queryForObject(order);
		int i = update(order);
		
		return i;
	}

    public OrderTO getOrder(OrderTO order) {
        return (OrderTO) queryForObject(order);
    }

    public List<OrderTO> getOrderList(OrderTO order) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", order.getDomainId());
        paraMap.put("orderType", order.getOrderType());
        paraMap.put("orderStatus", order.getOrderStatus());
        paraMap.put("orderRefNum", order.getOrderRefNum());
return null;
//        return pfwClient.queryForList(OrderTO.class, "/order/getOrderList", paraMap);
    }

    public List<OrderTO> searchOrderList(OrderTO order) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", order.getDomainId());
        paraMap.put("orderTypeSql", order.getOrderType());
        paraMap.put("orderStatus", order.getOrderStatus());
//        return PaginationEnabler.queryForList(OrderTO.class, pfwClient, "/order/getOrderList", paraMap);
        return null;
    }
//
//    public List<OrderTO> loadOrderList(OrderTO order,TenantTO tenantTO,PackageOrderTO packageOrderTO) {
//        Map<String, Object> paraMap = new HashMap<String, Object>();
//        paraMap.put("orderRefNum", order.getOrderRefNum());
//        paraMap.put("orderTypeSql", order.getOrderType());
//        paraMap.put("orderStatus", order.getOrderStatus());
//        paraMap.put("requestedBy", order.getRequestedBy());
//        paraMap.put("requestedStartDt", order.getRequestStartDt());
//        paraMap.put("requestedEndDt", order.getRequestEndDt());
//        paraMap.put("tenantName", tenantTO.getTenantName());
//        paraMap.put("packageName", packageOrderTO.getPackageName());
////        return PaginationEnabler.queryForList(OrderTO.class,pfwClient,"/order/loadOrderList", paraMap);
//        return null;
//    }

}