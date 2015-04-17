/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.ProductOrderService
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
 * v1.0     - Initial Release         jixiaowei                  Mar 4, 2011
 * =====================================================================================
 */
package com.saas.product.service;

import java.util.List;
import java.util.Map;

import com.saas.common.to.UserTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.product.to.ProductOrderTO;
import com.saas.product.to.UserDeviceTO;
import com.saas.provision.service.IsvProvisionServiceTO;
import com.saas.provision.service.ProvisionValidateException;

public interface ProductOrderService {

    /**
     * this method is used to create ProductOrder
     * version: 1.3.0
     */
    public void createProductOrder(ProductOrderTO productOrder);

    /**
     * this method is used to update ProductOrder
     * version: 1.3.0
     */
    public void updateProductOrder(ProductOrderTO productOrder);

    /**
     * this method is used to delete ProductOrder
     * version: 1.3.0
     */
    public void deleteProductOrder(ProductOrderTO productOrder);
    /**
     * this method is used to delete ProductOrder
     * version: 1.3.0
     */
    public void deleteProductOrderByOrderId(ProductOrderTO productOrder);

    /**
     * this method is used to search ProductOrder
     * version: 1.3.0
     */
    public ProductOrderTO getProductOrder(ProductOrderTO productOrder);

    /**
     * this method is used to get ProductOrder List
     * version: 1.3.0
     */
    public List<ProductOrderTO> getProductOrderList(ProductOrderTO productOrder);
    
    /**
     * this method is used to search ProductOrder
     * version: 1.3.0
     */
    public ProductOrderTO getProductOrderByProTxId(String proTxId);

    /**
     * this method is used to search ProductOrder
     * version: 1.3.0
     */
    public List<ProductOrderTO> searchProductOrderList(ProductOrderTO productOrder);
    
    public String assignProvisionUser(List<String> serviceIds, List<Domain2ProductTO> domainProductList, List<String[]> jspList, String svcDefCatetroy, String svcDefOperation,UserTO userTO, List<String> noProvsionList);
    public String assignProvisionUserAndDevice(List<String> serviceIds, List<Domain2ProductTO> domainProductList,Map<String,Map<Integer, UserDeviceTO>> deviceMap, List<String[]> jspList, String svcDefCatetroy, String svcDefOperation,UserTO userTO, List<String> noProvsionList);
    public String unAssignProvisionUser(List<String> serviceIds, List<String> user2ProductIds, String svcDefCatetroy, String svcDefOperation, UserTO userTO, List<String> noProvsionList);
    public String applyProvisionService(List<String> serviceIds, List<String> product2OrderIds, List<String> packageOrderIds4Provision, List<String[]> jspList, List<String> serviceIds4Downgrade, String svcDefCatetroy, String domainId,List<IsvProvisionServiceTO> returnList) throws ProvisionValidateException ;
    public String applyDeProvisionService(List<String> serviceIds, List<String> product2OrderIds, String domainId, List<IsvProvisionServiceTO> returnList);
    /**
     * this method is used to update productOrderStatus
     * version: 1.3.0
     */
    public void updateProductOrderStatus(String productOrderId,String productOrderStatus);

    public int updateProductOrderStatusByProTxId(String proTxId,String productOrderStatus);
    
    public List<String[]> processValidateAdapter(List<String> serviceIds, List<String> assignedProductNames, List<String[]> jspList,String svcDefCatetroy, String svcDefOperation);
    public String autoUnAssignProvisionUser(List<String> serviceIds, List<String> user2ProductIds, String svcDefCatetroy, String svcDefOperation, UserTO userTO, List<String> noProvsionList);
//    public Map<String, Object> processPreAdapter(String action,UserTO user,Domain2ProductTO mainDomainProduct,Integer pkgOrderNo,MultiPackageLicenseHelpTO multiHelpTO);
    
}