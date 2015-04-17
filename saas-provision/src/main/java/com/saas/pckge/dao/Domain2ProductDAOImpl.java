/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.dao.Domain2ProductDAOImpl
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
 * v1.0     - Initial Release         samyang                   Mar 4, 2011
 * =====================================================================================
 */
package com.saas.pckge.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saas.common.dao.SCBaseDAOImpl;
import com.saas.order.to.OrderTO;
import com.saas.pckge.to.Domain2ProductTO;

public class Domain2ProductDAOImpl extends SCBaseDAOImpl implements Domain2ProductDAO {
    public int createDomain2Product(Domain2ProductTO domain2Product) {
        return create(domain2Product);
    }

    public int deleteDomain2Product(Domain2ProductTO domain2Product) {
        return delete(domain2Product);
    }

    public int updateDomain2Product(Domain2ProductTO domain2Product) {
        return update(domain2Product);
    }

    public Domain2ProductTO getDomain2Product(Domain2ProductTO domain2Product) {
//        return (Domain2ProductTO)pfwClient.materializeWith(domain2Product);
    	return null;
    }

    public List<Domain2ProductTO> getDomain2ProductList(Domain2ProductTO domain2Product) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId",domain2Product.getDomainId());
        paraMap.put("domainPackageId",domain2Product.getDomainPackageId());
        paraMap.put("serviceId",domain2Product.getServiceId());
        paraMap.put("domainServiceRefId",domain2Product.getDomainServiceRefId());
        paraMap.put("domainServiceRefKey",domain2Product.getDomainServiceRefKey());
        paraMap.put("domainProductStatus",domain2Product.getDomainProductStatus());
        paraMap.put("packageId",domain2Product.getPackageId());
        paraMap.put("productId",domain2Product.getProductId());
//        return pfwClient.queryForList(Domain2ProductTO.class, "/domain2Product/getDomain2ProductList", paraMap);
        return null;
    }
    
    public List<Domain2ProductTO> getActiveDomain2ProductList(Domain2ProductTO domain2Product) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domain2Product.getDomainId());
        paraMap.put("serviceId", domain2Product.getServiceId());
        paraMap.put("domainServiceRefId",domain2Product.getDomainServiceRefId());
        paraMap.put("domainProductStatus", domain2Product.getDomainProductStatus());
//        return pfwClient.queryForList(Domain2ProductTO.class, "/domain2Product/getActiveDomain2ProductList", paraMap);
        return null;
    }
    
    public List<Domain2ProductTO> getActiveDomain2ProductsByDomainId(Domain2ProductTO domain2Product) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domain2Product.getDomainId());
        paraMap.put("serviceId", domain2Product.getServiceId());
//        return pfwClient.queryForList(Domain2ProductTO.class, "/domain2Product/getActiveDomain2Product", paraMap);
        return null;
    }

    public List<Domain2ProductTO> searchDomain2ProductList(Domain2ProductTO domain2Product) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(Domain2ProductTO.class, pfwClient, "/domain2Product/getDomain2ProductList", paraMap);
    }
    
    public List<Domain2ProductTO> getDomain2ProductListByDomainPackageIdAndUserId(String domainPackageId, String domainProductId, String userId){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainPackageId", domainPackageId);
        paraMap.put("domainProductId", domainProductId);
        paraMap.put("userId", userId);
//        return pfwClient.queryForList(Domain2ProductTO.class, "/domain2Product/getDomain2ProductListByDomainPackageIdAndUserId", paraMap);
        return null;
    }
    //changed the serviceCategory with package level
//    public List<Domain2ProductTO> getDomainProductListByDomainPackageIdAndServiceCategory(String domainPackageId, String serviceCategory) {
//    	Map<String, Object> paraMap = new HashMap<String, Object>();
//        paraMap.put("domainPackageId", domainPackageId);
//        paraMap.put("serviceCategory", serviceCategory);
//        
//        return pfwClient.queryForList(Domain2ProductTO.class, "/domain2Product/getDomainProductListByDomainPackageIdAndServiceCategory", paraMap);
//    }
    
    public List<Domain2ProductTO> getMainDomainProduct(String domainPackageId) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainPackageId", domainPackageId);
        return null;
//        return pfwClient.queryForList(Domain2ProductTO.class, "/domain2Product/getMainDomainProduct", paraMap);
    }
    
    public Integer getLicenseAssigned(String domainPackageId, String domainProductId, String userId){
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	paraMap.put("domainPackageId", domainPackageId);
    	paraMap.put("domainProductId", domainProductId);
    	paraMap.put("userId", userId);
//    	return (Integer)pfwClient.executeMapSQL("/domain2Product/getLicenseAssigned", paraMap);
    	return null;
    }

    public boolean checkUnCompletedService(String domainId, String serviceId) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domainId);
        paraMap.put("serviceId", serviceId);
//        List<OrderTO> list = pfwClient.queryForList(OrderTO.class, "/order/getCompletedOrderList", paraMap);
//        if (null != list && !list.isEmpty() && list.size() > 0) {
//            return true;
//        }
        return false;
    }
    
    public boolean checkOrderStatus(String domainId, String serviceId, String orderType, String orderStatus, String packageOrderStatus, String productOrderStatus, String excluedProTxId){
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("domainId", domainId);
        paraMap.put("serviceId", serviceId);
        paraMap.put("orderType", orderType);
        paraMap.put("orderStatus", orderStatus);
        paraMap.put("packageOrderStatus", packageOrderStatus);
        paraMap.put("productOrderStatus", productOrderStatus);
        paraMap.put("excluedProTxId", excluedProTxId);
//        List<OrderTO> list = pfwClient.queryForList(OrderTO.class, "/order/getStatusOrderList", paraMap);
//        if (null != list && !list.isEmpty() && list.size() > 0) {
//            return true;
//        }
        return false;
    }
}