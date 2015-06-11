/*
 *  =========================================================================
 * Program Name: package com.saas.product.dao.ProductOrderDAOImpl
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
package com.saas.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csb.common.IAppsConstants;
import com.csb.common.dao.SCBaseDAOImpl;
import com.csb.common.exception.SCServiceException;
import com.saas.product.to.ProductOrderTO;

public class ProductOrderDAOImpl extends SCBaseDAOImpl implements ProductOrderDAO {
    private Logger log = LoggerFactory.getLogger(ProductOrderDAOImpl.class);

    
    public int createProductOrder(ProductOrderTO productOrder) {
        
        int i = create(productOrder);
       
        return i;
    }

    public int deleteProductOrder(ProductOrderTO productOrder) {
        ProductOrderTO productOrderTO = this.getProductOrder(productOrder);
        
        if (null == productOrderTO) {
            throw new SCServiceException(IAppsConstants.MSG_RECORD_MODIFIED_ELSEWHERE);
        }
        
        int i = delete(productOrder);
        
        return i;
    }
    
    public int deleteProductOrderByOrderId(ProductOrderTO productOrder) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("orderId", productOrder.getOrderId());
//        List<ProductOrderTO> list = this.pfwClient.queryForList(ProductOrderTO.class,
//                "/productOrder/queryProductOrderByOrderId", paraMap);
//        pfwClient.executeMapSQL("/productOrder/deleteProductOrderByOrderId", paraMap);
//        for (int i = 0; i < list.size(); i++) {
//            ProductOrderTO productOrderTONewValue = this.getProductOrder(list.get(i));
//            XStream xstream = new XStream();
//            String productOrderNewValue = xstream.toXML(productOrderTONewValue);
//            String productOrderOldValue = xstream.toXML(list.get(i));
//            try {
//                auditTrailService.createAuditTrail("UPDATE_PRODUCT_ORDER", productOrderTONewValue.getProductOrderId(),
//                        "TBL_SS_PRODUCT2ORDER", "UPDATE", productOrderTONewValue.getLastUpdatedBy(),
//                        productOrderOldValue, productOrderNewValue);
//            } catch (Exception e) {
//                log.error("auditTrail for update product order failed", e);
//                log.error("UPDATE_PRODUCT_ORDER-New Value" + productOrderNewValue);
//                log.error("UPDATE_PRODUCT_ORDER-Old Value" + productOrderOldValue);
//            }
//        }
        return 0;
    }

    public int updateProductOrder(ProductOrderTO productOrder) {
        ProductOrderTO oldproductOrderTO = this.getProductOrder(productOrder);
        int i = update(productOrder);

        return i;
    }

    public ProductOrderTO getProductOrder(ProductOrderTO productOrder) {
        return (ProductOrderTO) queryForObject(productOrder);
    }

    public List<ProductOrderTO> getProductOrderList(ProductOrderTO productOrder) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        
        paraMap.put("packageOrderId", productOrder.getPackageOrderId());
        paraMap.put("orderId", productOrder.getOrderId());
        paraMap.put("notStatus", productOrder.getProductOrderStatus());
        paraMap.put("packageId", productOrder.getPackageId());
        paraMap.put("productId", productOrder.getProductId());
        paraMap.put("proTxId", productOrder.getProTxId());
        return null;
//        return pfwClient.queryForList(ProductOrderTO.class, "/productOrder/getProductOrderList", paraMap);
    }

    public List<ProductOrderTO> searchProductOrderList(ProductOrderTO productOrder) {
        Map<String, Object> paraMap = new HashMap<String, Object>();

        //TODO
        return null;
//        return PaginationEnabler.queryForList(ProductOrderTO.class, pfwClient, "/productOrder/getProductOrderList", paraMap);
    }

    public int updateProductOrderStatusByProTxId(String proTxId, String productOrderStatus) {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        paraMap.put("proTxId", proTxId);
        paraMap.put("productOrderStatus", productOrderStatus);

//        List<ProductOrderTO> list = this.pfwClient.queryForList(ProductOrderTO.class,
//                "/productOrder/queryProductOrderStatusByProTxId", paraMap);

//        int value = ((Integer) this.pfwClient.executeMapSQL("/productOrder/updateProductOrderStatusByProTxId", paraMap))
//                .intValue();
//        for (int i = 0; i < list.size(); i++) {
//            ProductOrderTO productOrderTONewValue = this.getProductOrder(list.get(i));
//            XStream xstream = new XStream();
//            String productOrderNewValue = xstream.toXML(productOrderTONewValue);
//            String productOrderOldValue = xstream.toXML(list.get(i));
//            try {
//                auditTrailService.createAuditTrail("UPDATE_PRODUCT_ORDER", productOrderTONewValue.getProductOrderId(),
//                        "TBL_SS_PRODUCT2ORDER", "UPDATE", productOrderTONewValue.getLastUpdatedBy(),
//                        productOrderOldValue, productOrderNewValue);
//            } catch (Exception e) {
//                log.error("auditTrail for update product order failed", e);
//                log.error("UPDATE_PRODUCT2ORDER-New Value" + productOrderNewValue);
//                log.error("UPDATE_PRODUCT2ORDER-Old Value" + productOrderOldValue);
//            }
//        }

        return 0;
    }
    
    public List<ProductOrderTO> getMainProductOrderByPackageOrderId(String packageOrderId) {
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	paraMap.put("packageOrderId", packageOrderId);
//        return pfwClient.queryForList(ProductOrderTO.class, "/productOrder/queryMainProductOrderByOrderId", paraMap);
    	return null;
    }
    
    public ProductOrderTO getProductOrder(String orderId, String packageId, String productServiceId){
    	Map<String, Object> paraMap = new HashMap<String, Object>();
    	paraMap.put("orderId", orderId);
    	paraMap.put("packageId", packageId);
    	paraMap.put("productServiceId", productServiceId);
//    	
//    	List<ProductOrderTO> productOrderList = pfwClient.queryForList(ProductOrderTO.class, "/productOrder/getProductOrder", paraMap);
//    	if (productOrderList != null && productOrderList.size() == 1){
//    		return productOrderList.get(0);
//    	}
    	
        return null;
    }

}