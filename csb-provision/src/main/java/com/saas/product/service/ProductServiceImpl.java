/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.ProductServiceImpl
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
package com.saas.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.DaoRunTimeException;
import com.csb.common.IAppsConstants;
import com.csb.common.SpringApplicationContextHolder;
import com.csb.common.exception.SCServiceException;
import com.saas.common.to.UserTO;
import com.saas.order.to.OrderTO;
import com.saas.pckge.service.Domain2PackageService;
import com.saas.pckge.service.Domain2ProductService;
import com.saas.pckge.service.PackageOrderService;
import com.saas.pckge.service.PackageService;
import com.saas.pckge.to.Domain2PackageTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.pckge.to.PackageOrderTO;
import com.saas.pckge.to.PackageTO;
import com.saas.product.dao.ProductDAO;
import com.saas.product.to.ProductTO;
import com.saas.product.to.ServiceTO;
import com.saas.product.to.UserProductTO;
import com.saas.provision.service.AdaptorObjectService;
import com.saas.provision.service.ProvisionService;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.util.IsvSvc;

public class ProductServiceImpl implements ProductService {
    private Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ApplicationContext appContext = null;
    private ProductDAO productDAO;

    public void createProduct(ProductTO product) {
    	productDAO.createProduct(product);
    }

    public void updateProduct(ProductTO product) {
        try {
            int result = productDAO.updateProduct(product);

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

    public void deleteProduct(ProductTO product) {
        try {
            int result = productDAO.deleteProduct(product);
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
    
    public void executeAutoAssignForAPI(OrderTO order, UserTO contactUser) {
        List<String> requestIds = new ArrayList<String>();
        Map<String, List<String>> noProvisionLists = new HashMap<String, List<String>>();
        List<Domain2PackageTO> domain2PackageList = null;
        String orderId = null;
        String domainId = null;
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }
//        UserService userService = (UserService) appContext.getBean("userService");
        Domain2PackageService domain2PackageService = (Domain2PackageService) appContext.getBean("domain2PackageService");
        Domain2ProductService domain2ProductService = (Domain2ProductService) appContext.getBean("domain2ProductService");
        PackageService packageService = (PackageService) appContext.getBean("packageService");
        ProductService productService = (ProductService) appContext.getBean("productService");
        UserProductService userProductService = (UserProductService) appContext.getBean("userProductService");
        Service service = (Service) appContext.getBean("service");
        ProvisionService provisionService = (ProvisionService) appContext.getBean("provisionService");
        PackageOrderService packageOrderService = (PackageOrderService) appContext.getBean("packageOrderService");
        
        try {
            List<String> noNeedAutoAssignPackageIds = new ArrayList<String>();
            if (null != order) {
                domainId = order.getDomainId();
                contactUser = new UserTO();
                orderId = order.getOrderId();
                contactUser.setDomainId(order.getDomainId());
                contactUser.setPriContactInd(IAppsConstants.IND_YES);
//                List<UserTO> primaryContactUserList = userService.loadUserListNoPagination(contactUser);
//                if (null != primaryContactUserList && !primaryContactUserList.isEmpty()) {
//                    contactUser = primaryContactUserList.get(0);
//                } else {
//                    contactUser = null;
//                    log.info("[SaaSConnect] Auto-assign: Primary Contact is empty, orderID: " + order.getOrderId());
//                    return;
//                }
                domain2PackageList = domain2PackageService.getActiveDomain2PackageList(order.getDomainId(), orderId, IAppsConstants.PACKAGE_STATUS_ACTIVE);
                
                PackageOrderTO packageOrder = new PackageOrderTO();
                packageOrder.setOrderId(orderId);
                List<PackageOrderTO> packageOrderList = packageOrderService.getPackageOrderList(packageOrder);
                for(PackageOrderTO packageOrderItem : packageOrderList){
                	if(!StringUtils.isEmpty(packageOrderItem.getOldDomainPackageId())){
                		noNeedAutoAssignPackageIds.add(packageOrderItem.getPackageId());
                	}
                }
            } else {
                domainId = contactUser.getDomainId();
                domain2PackageList = domain2PackageService.getActiveDomain2PackageList(domainId, IAppsConstants.PACKAGE_STATUS_ACTIVE);
            }
            
            for (Domain2PackageTO domain2Package : domain2PackageList) {
            	if(!noNeedAutoAssignPackageIds.contains(domain2Package.getPackageId())){
	                log.info("[SaaSConnect] Auto-assign: Get Domain2Package:" + domain2Package.getDomainPackageId() + " domainId: " + domainId);
	                // get domain2poduct list
	                Domain2ProductTO domain2Product = new Domain2ProductTO();
	                domain2Product.setDomainPackageId(domain2Package.getDomainPackageId());
	                domain2Product.setDomainId(domainId);
	                domain2Product.setDomainProductStatus(IAppsConstants.PACKAGE_STATUS_ACTIVE);
	                List<Domain2ProductTO> domain2ProductList = domain2ProductService.getDomain2ProductList(domain2Product);
	
	                // loop list
	                // get product id
	                // get product to by product id in tbl_ss_product.
	                List<String> servicesList = new ArrayList<String>();
	                List<String> assignedProductNames = new ArrayList<String>();
	                List<String[]> jspList = new ArrayList<String[]>();
	                List<Domain2ProductTO> domainProductList = new ArrayList<Domain2ProductTO>();
	                String[] parameters = new String[1];
	                parameters[0] = contactUser.getUserName();
	
	                Domain2ProductTO mainDomain2Product = new Domain2ProductTO();
	                List<Domain2ProductTO> noProvisionDomain2ProductList = new ArrayList<Domain2ProductTO>();
	
	                log.info("[SaaSConnect] Auto-assign: Get Domain2ProductList:" + domain2ProductList.size() + " domainId: " + domainId);
	
	                if (null == domain2ProductList || domain2ProductList.isEmpty()) {
	                    continue;
	                } else if (domain2ProductList.size() == 1) {
	                    mainDomain2Product = domain2ProductList.get(0);
	                    log.info("[SaaSConnect] Auto-assign: Main Domain Product:" + mainDomain2Product.getDomainProductId() + " service Id: " + mainDomain2Product.getServiceId()
	                            + " orderID: " + orderId);
	                } else if (domain2ProductList.size() > 1) {
	                    PackageTO mainPackageTO = new PackageTO();
	                    mainPackageTO.setPackageId(domain2Package.getPackageId());
	                    mainPackageTO = packageService.getPackage(mainPackageTO);
	                    if (mainPackageTO == null) {
	                        log.info("[SaaSConnect] Auto-assign: no main service id found for the package:" + domain2Package.getPackageId() + " domainId: " + domainId);
	                        continue;
	                    }
	                    for (Domain2ProductTO domain2ProductTO : domain2ProductList) {
	                        if (mainPackageTO.getMainServiceId().equals(domain2ProductTO.getServiceId())) {
	                            mainDomain2Product = domain2ProductTO;
	                            log.info("[SaaSConnect] Auto-assign: Main Domain Product:" + mainDomain2Product.getDomainProductId() + " service Id: "
	                                    + mainDomain2Product.getServiceId() + " domainId: " + domainId);
	                        } else {
	                            log.info("[SaaSConnect] Auto-assign: Other Domain Product:" + domain2ProductTO.getDomainProductId() + " service Id: "
	                                    + domain2ProductTO.getServiceId() + " domainId: " + domainId);
	                            noProvisionDomain2ProductList.add(domain2ProductTO);
	                        }
	                    }
	                }
	
	                servicesList.add(mainDomain2Product.getServiceId());
	                assignedProductNames.add(mainDomain2Product.getProductName());
	                domainProductList.add(mainDomain2Product);
	                jspList.add(parameters);// first product also main product
	
	                // process the no provision domain2product list
	                for (Domain2ProductTO domain2product : noProvisionDomain2ProductList) {
	                    servicesList.add(domain2product.getServiceId());
	                    assignedProductNames.add(domain2product.getProductName());
	                    domainProductList.add(domain2product);
	                    jspList.add(parameters);
	                }
	
	                try {
	                    for (int i = 0; i < servicesList.size(); i++) {
	                        log.info("[SaaSConnect] Auto-assign: Parameter " + i + " - service Id:" + servicesList.get(i) + " domainId: " + domainId);
	                        log.info("[SaaSConnect] Auto-assign: Parameter " + i + " - assignedProductName:" + assignedProductNames.get(i) + " domainId: " + domainId);
	                        log.info("[SaaSConnect] Auto-assign: Parameter " + i + " - domainProductList:" + domainProductList.get(i).getDomainProductId() + " domainId: "
	                                + domainId);
	                        String[] jspArray = jspList.get(i);
	                        StringBuffer jspBuffer = new StringBuffer();
	                        if (jspArray != null) {
	                            for (String jspValue : jspArray) {
	                                jspBuffer.append(jspValue).append(",");
	                            }
	                        }
	                        log.info("[SaaSConnect] Auto-assign: Parameter " + i + " - jspList:" + jspBuffer.toString() + " domainId: " + domainId);
	                    }
	                } catch (Exception e) {
	                    log.error("[SaaSConnect] Auto-assign: parameters error" + " domainId: " + domainId, e);
	                }
	
	                ProductTO productTO = new ProductTO();
	                productTO.setProductId(mainDomain2Product.getProductId());
	                productTO = productService.getProduct(productTO);
	                if (null == productTO) {
	                    log.info("[SaaSConnect] Auto-assign: product is empty. product ID: " + mainDomain2Product.getProductId() + " domainId: " + domainId);
	                    continue;
	                }
	                String serviceId = productTO.getServiceId();
	
	                if (!IAppsConstants.IND_YES.equalsIgnoreCase(productTO.getAutoAssiginIndicator())) {
	                    log.info("[SaaSConnect] Auto-assign: product not allow auto assign." + " product ID: " + productTO.getProductId() + " domainId: " + domainId);
	                    continue;
	                }
	
	                // Do not auto-assign a product if that product already assigned to primary admin
	                UserProductTO userProduct = new UserProductTO();
	                userProduct.setUserId(contactUser.getUserId());
	                userProduct.setServiceId(serviceId);
	                List<UserProductTO> result = userProductService.getAllActiveAssignedUserProducts(userProduct);
	                // all user product
	                // if empty to do auto assign
	                // if not empty do check:
	                // all unassign success to do auto assign
	                if (!result.isEmpty()) {
	                    log.info("[SaaSConnect] Auto-assign: The userId: " + contactUser.getUserId() + " already have the product. serverId:" + serviceId + " domainId: "
	                            + domainId);
	                    continue;
	                }
	
	                ServiceTO serviceTO = new ServiceTO();
	                serviceTO.setServiceId(serviceId);
	                serviceTO = service.getService(serviceTO);
	                if (serviceTO == null) {
	                    log.info("[SaaSConnect] Auto-assign: get serviceTO is empty by serviceId: " + serviceId + " domainId: " + domainId);
	                    continue;
	                }
	
	                List<Domain2ProductTO> activeDomain2ProductList = domain2ProductService.getDomain2ProductListByDomainPackageIdAndUserId(null, mainDomain2Product
	                        .getDomainProductId(), contactUser.getUserId());
	                if (null != activeDomain2ProductList && !activeDomain2ProductList.isEmpty()) {
	                    Domain2ProductTO domain2ProductTO = activeDomain2ProductList.get(0);
	                    if (!IAppsConstants.PACKAGE_PRODUCT_UNLIMITED_YES.equalsIgnoreCase(domain2ProductTO.getUnlimitIndicator())) {
	                        int totalLicenseLeft = domain2ProductTO.getTotalLicenseLeft() == null ? 0 : Integer.parseInt(domain2ProductTO.getTotalLicenseLeft());
	                        if (totalLicenseLeft < 1) {
	                            log.info("[SaaSConnect] Auto-assign: no available license by serviceId: " + serviceId + " domainId: " + domainId);
	                            continue;
	                        }
	                    }
	                }
	                // to get the adaptor and execute.
	                IsvAdaptorTO adaptorTO = provisionService.getSvcAdaptorTO(serviceId, IsvSvc.SERVICE_DEF_CATEGORY_SERVICE, IsvSvc.SERVICE_DEF_OPERATION_AUTO_ASSIGN);
	                if (adaptorTO == null || adaptorTO.getIsvAdaptorEndpoint() == null) {
	                    log.info("[SaaSConnect] Auto-assign: get adaptorTO or adaptorTO.getIsvAdaptorEndpoint() is empty by serviceId: " + serviceId + " domainId: " + domainId);
	                    continue;
	                }
	
	                AdaptorObjectService adaptor = (AdaptorObjectService) appContext.getBean(adaptorTO.getIsvAdaptorEndpoint());
	                if (null == adaptor) {
	                    log.info("[SaaSConnect] Auto-assign:get bean is empty by beanName: " + adaptorTO.getIsvAdaptorEndpoint() + "serviceId" + serviceId + " domainId: "
	                            + domainId);
	                    continue;
	                }
	                Map<String, Object> paraMap = new HashMap<String, Object>();
//	                paraMap.put(IsvFSecureBackupConstants.SERVICE_MAP_USER_ID, contactUser.getUserId());
//	                // put above list to adaptor
//	                paraMap.put(IsvFSecureConstants.SERVICE_MAP_SERVICE_LISTS, servicesList);
//	                paraMap.put(IsvFSecureConstants.SERVICE_MAP_ASSIGNED_PRODUCT_NAMES, assignedProductNames);
//	                paraMap.put(IsvFSecureConstants.SERVICE_MAP_JSP_LIST, jspList);
//	                paraMap.put(IsvFSecureConstants.SERVICE_MAP_DOMAIN_PRODUCT_LIST, domainProductList);
	
	                Map<String, Object> responseMap = adaptor.execute(paraMap, new HashMap<String, Object>());
	                String requestId = (String) responseMap.get("requestId");
	                log.info("[SaaSConnect] Auto-assign:requestId: " + requestId + " domainId: " + domainId);
	                List<String> noProvisionList = (List) responseMap.get("noProvisionList");
	                if (StringUtils.isEmpty(requestId)) {
	                    continue;
	                } else {
	                    requestIds.add(requestId);
	                    noProvisionLists.put(requestId, noProvisionList);
	                }
            	}   
            }
        } catch (Exception e) {
            log.error("[SaaSConnect] Auto-assign failed, errorMsg: " + e.getMessage() + " domainId: " + domainId, e);
        }

        if (!requestIds.isEmpty()) {
            log.info("[SaaSConnect] Auto-assign: send mail with auto assign: " + " domainId: " + domainId);
           // CombineAutoAssignmentThread combineAutoAssignmentThread = new CombineAutoAssignmentThread();
            //IUserSessionInfo usi = USIEnabler.currentUSI();
            //combineAutoAssignmentThread.setUsi(usi);
//            combineAutoAssignmentThread.setRequestIds(requestIds);
//            combineAutoAssignmentThread.setNoProvisionLists(noProvisionLists);
//            combineAutoAssignmentThread.setOrderId(orderId);
//            combineAutoAssignmentThread.setAdminUserId(contactUser.getUserId());
//            new Thread(combineAutoAssignmentThread, "[SaaSConnect] Auto-assign: Combine Auto Assignment Thread start.").start();
        }
    }

    public ProductTO getProduct(ProductTO product) {
        return productDAO.getProduct(product);
    }

    public List<ProductTO> getProductList(ProductTO product) {
        return productDAO.getProductList(product);
    }

    public List<ProductTO> searchProductList(ProductTO product) {
        return productDAO.searchProductList(product);
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }
}