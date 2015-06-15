/*
 *  =========================================================================
 * Program Name: package com.saas.product.service.ProductOrderServiceImpl
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
package com.saas.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.csb.common.ConcurrentUpdateException;
import com.csb.common.ConfigProperties;
import com.csb.common.DaoRunTimeException;
import com.csb.common.IAppsConstants;
import com.csb.common.SequenceUUID;
import com.csb.common.SpringApplicationContextHolder;
import com.csb.common.exception.SCServiceException;
import com.saas.common.to.UserTO;
import com.saas.pckge.service.Domain2PackageService;
import com.saas.pckge.service.Domain2ProductService;
import com.saas.pckge.service.PackageOrderService;
import com.saas.pckge.to.Domain2PackageTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.pckge.to.PackageOrderTO;
import com.saas.product.dao.ProductOrderDAO;
import com.saas.product.to.ProductOrderTO;
import com.saas.product.to.ServiceTO;
import com.saas.product.to.UserDeviceTO;
import com.saas.product.to.UserProductTO;
import com.saas.provision.service.IsvProvisionServiceTO;
import com.saas.provision.service.ProvisionService;
import com.saas.provision.service.ProvisionValidateException;
import com.saas.provision.service.ValidateAdaptorService;
import com.saas.provision.to.IsvAdaptorTO;
import com.saas.provision.to.IsvServiceDefTO;
import com.saas.provision.to.IsvServiceTO;
import com.saas.provision.to.ProvisionTO;
import com.saas.provision.util.IsvSvc;
import com.saas.provision.util.IsvSvcBuilder;
import com.saas.provision.util.IsvSvcImpl;

public class ProductOrderServiceImpl implements ProductOrderService {

    private ProductOrderDAO productOrderDAO;
    private PackageOrderService packageOrderService;
    private UserProductService userProductService;
	private UserAssignmentService userAssignmentService;
    private ApplicationContext appContext;
    private Service service;
    private ProvisionService provisionService;
    private Domain2ProductService domain2ProductService;
    private Domain2PackageService domain2PackageService;

    private ConfigProperties config = ConfigProperties.getInstance();

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ProvisionService getProvisionService() {
        return provisionService;
    }

    public void setProvisionService(ProvisionService provisionService) {
        this.provisionService = provisionService;
    }
    
    
    public Domain2ProductService getDomain2ProductService() {
        return domain2ProductService;
    }

    public void setDomain2ProductService(Domain2ProductService domain2ProductService) {
        this.domain2ProductService = domain2ProductService;
    }

    public void createProductOrder(ProductOrderTO productOrder) {
        productOrderDAO.createProductOrder(productOrder);
    }

    public void updateProductOrder(ProductOrderTO productOrder) {
        try {
            int result = productOrderDAO.updateProductOrder(productOrder);
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

    public void deleteProductOrderByOrderId(ProductOrderTO productOrder) {
        try {
            int result = productOrderDAO.deleteProductOrderByOrderId(productOrder);

        } catch (DaoRunTimeException e) {
            if (e.getWrappedException() instanceof ConcurrentUpdateException) {
                throw new ConcurrentUpdateException();
            } else {
                throw new SCServiceException(e);
            }
        }
    }

    public void deleteProductOrder(ProductOrderTO productOrder) {
        try {
            int result = productOrderDAO.deleteProductOrder(productOrder);
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

    public void updateProductOrderStatus(String productOrderId, String productOrderStatus) {
        ProductOrderTO productOrder = new ProductOrderTO();
        productOrder.setProductOrderId(productOrderId);
        productOrder = productOrderDAO.getProductOrder(productOrder);
        productOrder.setProductOrderStatus(productOrderStatus);
        updateProductOrder(productOrder);
    }

    public ProductOrderTO getProductOrder(ProductOrderTO productOrder) {
        return productOrderDAO.getProductOrder(productOrder);
    }
    
    public ProductOrderTO getProductOrderByProTxId(String proTxId){
    	ProductOrderTO productOrder = new ProductOrderTO();
		productOrder.setProTxId(proTxId);
		List<ProductOrderTO> productOrderList = productOrderDAO.getProductOrderList(productOrder);
		if(productOrderList!=null&&productOrderList.size()>0){
			return productOrderList.get(0);
		}else{
			return null;
		}
    }

    public List<ProductOrderTO> getProductOrderList(ProductOrderTO productOrder) {
        return productOrderDAO.getProductOrderList(productOrder);
    }

    public List<ProductOrderTO> searchProductOrderList(ProductOrderTO productOrder) {
        return productOrderDAO.searchProductOrderList(productOrder);
    }

    @Transactional
    public String applyProvisionService(List<String> serviceIds, List<String> product2OrderIds, List<String> packageOrderIds, List<String[]> jspList,
            List<String> serviceIds4Downgrade, String svcDefCatetroy, String domainId, List<IsvProvisionServiceTO> returnList)
            throws ProvisionValidateException {
        if (serviceIds == null || jspList == null || serviceIds.size() != jspList.size()) {
            throw new IllegalArgumentException("[SaaSconnect] Error occurrd when validate serviceIds and jspList.");
        }
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }

        List<IsvProvisionServiceTO> svcDefList = new ArrayList<IsvProvisionServiceTO>();
        List<IsvProvisionServiceTO> svcNoDefList = new ArrayList<IsvProvisionServiceTO>();
        processService(serviceIds, jspList, product2OrderIds, packageOrderIds, null, svcDefCatetroy, null, svcDefList, svcNoDefList);

        List<String[]> errorMessageList = processValidate(svcDefList);
        if (errorMessageList.size() > 0) {
            throw new ProvisionValidateException(errorMessageList);
        }

        processReferenceId(domainId, svcDefList);

        List<String[]> errorMsgList = processValidateForServiceId(svcDefList);
        if (errorMsgList.size() > 0) {
            throw new ProvisionValidateException(errorMsgList);
        }

        //for down grade.
        if(serviceIds4Downgrade.size() > 0){
            for(String serviceId: serviceIds4Downgrade){
                ServiceTO serviceParamTO = new ServiceTO();
                serviceParamTO.setServiceId(serviceId);
                ServiceTO serviceTO = service.getService(serviceParamTO);
                if (serviceTO == null) {
                    throw new RuntimeException("[SaaSconnect] Error occured get downgrad Service by serviceID: " + serviceId);
                }
                if (!StringUtils.isEmpty(serviceTO.getServiceDefName())) {
                    IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
                    isvProvisionServiceTO.setServiceId(serviceId);
                    isvProvisionServiceTO.setServiceDefCategory(IsvSvc.SERVICE_DEF_CATEGORY_SERVICE);
                    isvProvisionServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                    isvProvisionServiceTO.setServiceDefName(serviceTO.getServiceDefName());
                    isvProvisionServiceTO.setSvcDerfOperation(IsvSvc.SERVICE_DEF_OPERATION_DELETE);
                    isvProvisionServiceTO.setDowngradeService(true);
                    svcDefList.add(isvProvisionServiceTO);
                }
            }
        }
        // provision
        ProvisionTO provisionTO = processProvisionRequest(domainId, svcDefList);

        for (int i = 0; i < svcDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
            if(!isvProvisionServiceTO.isDowngradeService()){
                ProductOrderTO productOrder = new ProductOrderTO();
                productOrder.setProductOrderId(isvProvisionServiceTO.getProduct2OrderId());
                productOrder = productOrderDAO.getProductOrder(productOrder);
                productOrder.setProTxId(isvProvisionServiceTO.getIsvServiceId());
                updateProductOrder(productOrder);
            }
        }

        // update product2order status
        for (int i = 0; i < svcNoDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcNoDefList.get(i);
            returnList.add(isvProvisionServiceTO);
        }
        // we can not update product2order in this method. so only return with a list
        if (null == provisionTO) {
			return null;
		}
        return provisionTO.getReqId();

    }
    
    @Transactional
    public String applyDeProvisionService(List<String> serviceIds, List<String> product2OrderIds, String domainId, List<IsvProvisionServiceTO> returnList){
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }
        
        List<IsvProvisionServiceTO> svcDefList = new ArrayList<IsvProvisionServiceTO>();
        List<IsvProvisionServiceTO> svcNoDefList = new ArrayList<IsvProvisionServiceTO>();

        for (int i = 0; i < serviceIds.size(); i++) {
            String serviceId = serviceIds.get(i);
            ServiceTO serviceParamTO = new ServiceTO();
            serviceParamTO.setServiceId(serviceId);
            ServiceTO serviceTO = service.getService(serviceParamTO);
            if (serviceTO == null) {
                throw new RuntimeException("[SaaSconnect] Error occurrd get Service by serviceID: " + serviceId);
            }
            IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
            isvProvisionServiceTO.setServiceId(serviceId);
            if (product2OrderIds != null) {
                isvProvisionServiceTO.setProduct2OrderId(product2OrderIds.get(i));
            }
            
            if (StringUtils.isEmpty(serviceTO.getServiceDefName())) {
                svcNoDefList.add(isvProvisionServiceTO);
            } else {
                isvProvisionServiceTO.setServiceDefCategory(IsvSvc.SERVICE_DEF_CATEGORY_SERVICE);
                isvProvisionServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                isvProvisionServiceTO.setServiceDefName(serviceTO.getServiceDefName());
                isvProvisionServiceTO.setSvcDerfOperation(IsvSvc.SERVICE_DEF_OPERATION_DELETE);
                svcDefList.add(isvProvisionServiceTO);
            }
        }
        
        // provision
        ProvisionTO provisionTO = processProvisionRequest(domainId, svcDefList);
        
        for (int i = 0; i < svcDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
            ProductOrderTO productOrder = new ProductOrderTO();
            productOrder.setProductOrderId(isvProvisionServiceTO.getProduct2OrderId());
            productOrder = productOrderDAO.getProductOrder(productOrder);
            productOrder.setProTxId(isvProvisionServiceTO.getIsvServiceId());
            updateProductOrder(productOrder);
        }
        
        // update product2order status
        for (int i = 0; i < svcNoDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcNoDefList.get(i);
            returnList.add(isvProvisionServiceTO);
        }
        // we can not update product2order in this method. so only return with a list
        if (null == provisionTO) {
            return null;
        }
        return provisionTO.getReqId();
        
    }

    public List<String[]> processValidateAdapter(List<String> serviceIds, List<String> assignedProductNames,
            List<String[]> jspList, String svcDefCatetroy, String svcDefOperation) {
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }

        List<String[]> errorMessageList = new ArrayList<String[]>();

        for (int i = 0; i < serviceIds.size(); i++) {
            String serviceId = serviceIds.get(i);
            ServiceTO serviceParamTO = new ServiceTO();
            serviceParamTO.setServiceId(serviceId);
            ServiceTO serviceTO = service.getService(serviceParamTO);
            if (serviceTO == null) {
                throw new RuntimeException("[SaaSconnect] Error occurrd get Service by serviceID: " + serviceId);
            }
            IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
            isvProvisionServiceTO.setServiceId(serviceId);
            if (StringUtils.isNotEmpty(serviceTO.getServiceDefName())) {
                IsvServiceTO paramIsvServiceTO = new IsvServiceTO();
                paramIsvServiceTO.setServiceName(serviceTO.getServiceDefName());
                paramIsvServiceTO.setServiceCategory(svcDefCatetroy);
                paramIsvServiceTO.setServiceOperation(IsvSvc.SERVICE_DEF_OPERATION_VALIDATE);
                paramIsvServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                // get validate adapter
                IsvServiceDefTO validateIsvServiceDefTO = provisionService.getIsvServiceDef(paramIsvServiceTO);
                if (validateIsvServiceDefTO == null) {
                    throw new RuntimeException("[SaaSconnect] Error occurrd get get validate adapter: "
                            + paramIsvServiceTO.getServiceName() + "," + paramIsvServiceTO.getServiceCategory() + ","
                            + paramIsvServiceTO.getServiceOperation() + "," + paramIsvServiceTO.getServiceDefVersion());
                }
                IsvAdaptorTO validateIsvAdaptorTO = provisionService.getSvcAdaptor(validateIsvServiceDefTO
                        .getIsvProvAdaptorId());

                ValidateAdaptorService validateAdaptorService = (ValidateAdaptorService) appContext
                        .getBean(validateIsvAdaptorTO.getIsvAdaptorEndpoint());
                Map<String, String> sysParamMap = new HashMap<String, String>();
                sysParamMap.put(IAppsConstants.SERVICE_MAP_PRODUCT_NAME, assignedProductNames.get(i));
                String[] errorMessageArray = validateAdaptorService.execute(sysParamMap, jspList.get(i));

                if (errorMessageArray != null) {
                    errorMessageList.add(errorMessageArray);
                }
            }
        }

        return errorMessageList;
    }
    
    
    
    /*public Map<String, Object> processPreAdapter(String action,UserTO user,Domain2ProductTO mainDomainProduct,Integer pkgOrderNo,MultiPackageLicenseHelpTO multiHelpTO) {
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }

        ServiceTO serviceParamTO = new ServiceTO();
        serviceParamTO.setServiceId(mainDomainProduct.getServiceId());
        ServiceTO serviceTO = service.getService(serviceParamTO);
        if (serviceTO == null) {
            throw new RuntimeException("[SaaSconnect] Error occurrd get Service by serviceID: " + mainDomainProduct.getServiceId());
        }
        IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
        isvProvisionServiceTO.setServiceId(mainDomainProduct.getServiceId());
        if (StringUtils.isNotEmpty(serviceTO.getServiceDefName())) {
            IsvServiceTO paramIsvServiceTO = new IsvServiceTO();
            paramIsvServiceTO.setServiceName(serviceTO.getServiceDefName());
            paramIsvServiceTO.setServiceCategory(IsvSvc.SERVICE_DEF_CATEGORY_USER);
            paramIsvServiceTO.setServiceOperation("PRECREATE");
            paramIsvServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
            // get Assign adapter
            IsvServiceDefTO assignIsvServiceDefTO = provisionService.getIsvServiceDef(paramIsvServiceTO);
            if (assignIsvServiceDefTO == null) {
                return null;
            }
            IsvAdaptorTO assignIsvAdaptorTO = provisionService.getSvcAdaptor(assignIsvServiceDefTO
                    .getIsvProvAdaptorId());

            UserAppsAdaptorService assignAdaptorService = (UserAppsAdaptorService) appContext
                    .getBean(assignIsvAdaptorTO.getIsvAdaptorEndpoint());
            if("create".equalsIgnoreCase(action)){
            	return assignAdaptorService.initAdd(user, mainDomainProduct, pkgOrderNo, multiHelpTO);
            }else{
            	return assignAdaptorService.initEdit(user,mainDomainProduct,pkgOrderNo,multiHelpTO);
            	
            }
            
        }

        return null;
    }*/
    
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String assignProvisionUser(List<String> serviceIds, List<Domain2ProductTO> domainProductList, List<String[]> jspList,
            String svcDefCatetroy, String svcDefOperation, UserTO userTO, List<String> noProvsionList) {
        if (serviceIds == null || jspList == null || serviceIds.size() != jspList.size()) {
            throw new IllegalArgumentException("[SaaSconnect]Error occurrd when validate serviceIds and jspList.");
        }
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }

        List<IsvProvisionServiceTO> svcDefList = new ArrayList<IsvProvisionServiceTO>();
        List<IsvProvisionServiceTO> svcNoDefList = new ArrayList<IsvProvisionServiceTO>();

        for (int i = 0; i < serviceIds.size(); i++) {
            String serviceId = serviceIds.get(i);
            ServiceTO serviceParamTO = new ServiceTO();
            serviceParamTO.setServiceId(serviceId);
            ServiceTO serviceTO = service.getService(serviceParamTO);
            if (serviceTO == null) {
                throw new RuntimeException("[SaaSconnect]Error occurrd get Service by serviceID: " + serviceId);
            }
            IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
            isvProvisionServiceTO.setServiceId(serviceId);
            isvProvisionServiceTO.setDomain2ProductTO(domainProductList.get(i));

            if (StringUtils.isEmpty(serviceTO.getServiceDefName())) {
                svcNoDefList.add(isvProvisionServiceTO);
            } else {
                isvProvisionServiceTO.setJspArray(jspList.get(i));
                isvProvisionServiceTO.setServiceDefCategory(svcDefCatetroy);
                isvProvisionServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                isvProvisionServiceTO.setServiceDefName(serviceTO.getServiceDefName());
                isvProvisionServiceTO.setSvcDerfOperation(svcDefOperation);

                svcDefList.add(isvProvisionServiceTO);
            }
        }

        // provision
        ProvisionTO provisionTO = processProvisionRequest(userTO.getDomainId(), svcDefList);

        // update user product status
        if (null != svcNoDefList && svcNoDefList.size() > 0) {
            for (int i = 0; i < svcNoDefList.size(); i++) {
                IsvProvisionServiceTO isvProvisionServiceTO = svcNoDefList.get(i);
                
                Domain2ProductTO domain2ProductTO = isvProvisionServiceTO.getDomain2ProductTO();
                Domain2PackageTO domain2PackageTO = new Domain2PackageTO();
                domain2PackageTO.setDomainPackageId(domain2ProductTO.getDomainPackageId());
                domain2PackageTO = domain2PackageService.getDomain2Package(domain2PackageTO);
                UserProductTO userProductTO = new UserProductTO();
                String userProductID = SequenceUUID.getInstance().getUUID();
                userProductTO.setUserProductId(userProductID);
                userProductTO.setUserId(userTO == null ? null : userTO.getUserId());
                userProductTO.setDomainProductId(domain2ProductTO.getDomainProductId());
                userProductTO.setPackageId(domain2PackageTO == null ? domain2ProductTO.getPackageId() : domain2PackageTO.getPackageId()); //updated for bulk assign user
                userProductTO.setProductId(domain2ProductTO.getProductId());
                userProductTO.setServiceId(domain2ProductTO.getServiceId());
                userProductTO.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN);
                userProductTO.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_ACTIVE);
                userProductTO.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_NO);
                userProductTO.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_SUCCESS);
                userProductTO.setProTxId(isvProvisionServiceTO.getIsvServiceId());
                userProductService.createUserProduct(userProductTO);
                userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProductTO);
                noProvsionList.add(userProductID);
            }
        }

        if (null != svcDefList && svcDefList.size() > 0) {
            for (int i = 0; i < svcDefList.size(); i++) {
                IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
                Domain2ProductTO domain2ProductTO = isvProvisionServiceTO.getDomain2ProductTO();
                Domain2PackageTO domain2PackageTO = new Domain2PackageTO();
                domain2PackageTO.setDomainPackageId(domain2ProductTO.getDomainPackageId());
                domain2PackageTO = domain2PackageService.getDomain2Package(domain2PackageTO);
                UserProductTO userProductTO = new UserProductTO();
                String userProductID = SequenceUUID.getInstance().getUUID();
                userProductTO.setUserProductId(userProductID);
                userProductTO.setUserId(userTO == null ? null : userTO.getUserId());
                userProductTO.setDomainProductId(domain2ProductTO.getDomainProductId());
                userProductTO.setPackageId(domain2PackageTO == null ? domain2ProductTO.getPackageId() : domain2PackageTO.getPackageId()); //updated for bulk assign user
                userProductTO.setProductId(domain2ProductTO.getProductId());
                userProductTO.setServiceId(domain2ProductTO.getServiceId());
                userProductTO.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN);
                userProductTO.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_INACTIVE);
                userProductTO.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_NO);
                userProductTO.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_INPROGRESS);
                userProductTO.setProTxId(isvProvisionServiceTO.getIsvServiceId());
                
                userProductService.createUserProduct(userProductTO);
                userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProductTO);
            }
        }

        // no provsion need.
        if(provisionTO == null){
            return null;
        }
        return provisionTO.getReqId();
    }
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String assignProvisionUserAndDevice(List<String> serviceIds, List<Domain2ProductTO> domainProductList,Map<String,Map<Integer, UserDeviceTO>> deviceMap, List<String[]> jspList, String svcDefCatetroy, String svcDefOperation,UserTO userTO, List<String> noProvsionList){
       
    	if (serviceIds == null || jspList == null || serviceIds.size() != jspList.size()) {
            throw new IllegalArgumentException("[SaaSconnect]Error occurrd when validate serviceIds and jspList.");
        }
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }

        List<IsvProvisionServiceTO> svcDefList = new ArrayList<IsvProvisionServiceTO>();
        List<IsvProvisionServiceTO> svcNoDefList = new ArrayList<IsvProvisionServiceTO>();

        for (int i = 0; i < serviceIds.size(); i++) {
            String serviceId = serviceIds.get(i);
            ServiceTO serviceParamTO = new ServiceTO();
            serviceParamTO.setServiceId(serviceId);
            ServiceTO serviceTO = service.getService(serviceParamTO);
            if (serviceTO == null) {
                throw new RuntimeException("[SaaSconnect]Error occurrd get Service by serviceID: " + serviceId);
            }
            IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
            isvProvisionServiceTO.setServiceId(serviceId);
            isvProvisionServiceTO.setDomain2ProductTO(domainProductList.get(i));

            if (StringUtils.isEmpty(serviceTO.getServiceDefName())) {
                svcNoDefList.add(isvProvisionServiceTO);
            } else {
                isvProvisionServiceTO.setJspArray(jspList.get(i));
                isvProvisionServiceTO.setServiceDefCategory(svcDefCatetroy);
                isvProvisionServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                isvProvisionServiceTO.setServiceDefName(serviceTO.getServiceDefName());
                isvProvisionServiceTO.setSvcDerfOperation(svcDefOperation);

                svcDefList.add(isvProvisionServiceTO);
            }
        }

        // provision
        ProvisionTO provisionTO = processProvisionRequest(userTO.getDomainId(), svcDefList);

        // update user product status
        if (null != svcNoDefList && svcNoDefList.size() > 0) {
            for (int i = 0; i < svcNoDefList.size(); i++) {
                IsvProvisionServiceTO isvProvisionServiceTO = svcNoDefList.get(i);
                
                Domain2ProductTO domain2ProductTO = isvProvisionServiceTO.getDomain2ProductTO();
                Domain2PackageTO domain2PackageTO = new Domain2PackageTO();
                domain2PackageTO.setDomainPackageId(domain2ProductTO.getDomainPackageId());
                domain2PackageTO = domain2PackageService.getDomain2Package(domain2PackageTO);
                UserProductTO userProductTO = new UserProductTO();
                String userProductID = SequenceUUID.getInstance().getUUID();
                userProductTO.setUserProductId(userProductID);
                userProductTO.setUserId(userTO == null ? null : userTO.getUserId());
                userProductTO.setDomainProductId(domain2ProductTO.getDomainProductId());
                userProductTO.setPackageId(domain2PackageTO == null ? domain2ProductTO.getPackageId() : domain2PackageTO.getPackageId()); //updated for bulk assign user
                userProductTO.setProductId(domain2ProductTO.getProductId());
                userProductTO.setServiceId(domain2ProductTO.getServiceId());
                userProductTO.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN);
                userProductTO.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_ACTIVE);
                userProductTO.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_NO);
                userProductTO.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_SUCCESS);
                userProductTO.setProTxId(isvProvisionServiceTO.getIsvServiceId());

                //add for device
                String userDeviceMapId = SequenceUUID.getInstance().getUUID();
                userProductTO.setUserDeviceMapId(userDeviceMapId);
                
                userProductService.createUserProduct(userProductTO);
                userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProductTO);
                
                
                Map<Integer, UserDeviceTO> userDeviceMap = deviceMap.get(domain2ProductTO.getDomainProductId());
                if(userDeviceMap!=null&&userDeviceMap.size()>0){
                	for (Map.Entry<Integer, UserDeviceTO> entry : userDeviceMap.entrySet()) {
                		UserDeviceTO userDeviceTO = entry.getValue();
                        String userDeviceId = SequenceUUID.getInstance().getUUID();
                        userDeviceTO.setUserDeviceId(userDeviceId);
                        userDeviceTO.setUserId(userTO == null ? null : userTO.getUserId());
                        userDeviceTO.setUserDeviceMapId(userProductTO.getUserDeviceMapId());
                        userDeviceTO.setDeviceSeq(entry.getKey());
                        userDeviceTO.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_INPROGRESS);
                        userDeviceTO.setDeviceStatus(IAppsConstants.DEVICE_STATUS_ACTIVE);
                        userDeviceTO.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN);
//                        userDeviceService.createUserDevice(userDeviceTO);
                	}
                }
                
                
                noProvsionList.add(userProductID);
            }
        }

        if (null != svcDefList && svcDefList.size() > 0) {
            for (int i = 0; i < svcDefList.size(); i++) {
                IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
                Domain2ProductTO domain2ProductTO = isvProvisionServiceTO.getDomain2ProductTO();
                Domain2PackageTO domain2PackageTO = new Domain2PackageTO();
                domain2PackageTO.setDomainPackageId(domain2ProductTO.getDomainPackageId());
                domain2PackageTO = domain2PackageService.getDomain2Package(domain2PackageTO);
                UserProductTO userProductTO = new UserProductTO();
                String userProductID = SequenceUUID.getInstance().getUUID();
                userProductTO.setUserProductId(userProductID);
                userProductTO.setUserId(userTO == null ? null : userTO.getUserId());
                userProductTO.setDomainProductId(domain2ProductTO.getDomainProductId());
                userProductTO.setPackageId(domain2PackageTO == null ? domain2ProductTO.getPackageId() : domain2PackageTO.getPackageId()); //updated for bulk assign user
                userProductTO.setProductId(domain2ProductTO.getProductId());
                userProductTO.setServiceId(domain2ProductTO.getServiceId());
                userProductTO.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN);
                userProductTO.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_INACTIVE);
                userProductTO.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_NO);
                userProductTO.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_INPROGRESS);
                userProductTO.setProTxId(isvProvisionServiceTO.getIsvServiceId());
                
                //add for device
                String userDeviceMapId = SequenceUUID.getInstance().getUUID();
                userProductTO.setUserDeviceMapId(userDeviceMapId);
                
                userProductService.createUserProduct(userProductTO);
                userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProductTO);
                
                Map<Integer, UserDeviceTO> userDeviceMap = deviceMap.get(domain2ProductTO.getDomainProductId());
                if(userDeviceMap!=null&&userDeviceMap.size()>0){
                	for (Map.Entry<Integer, UserDeviceTO> entry : userDeviceMap.entrySet()) {
                		UserDeviceTO userDeviceTO = entry.getValue();
                        String userDeviceId = SequenceUUID.getInstance().getUUID();
                        userDeviceTO.setUserDeviceId(userDeviceId);
                        userDeviceTO.setUserId(userTO == null ? null : userTO.getUserId());
                        userDeviceTO.setUserDeviceMapId(userProductTO.getUserDeviceMapId());
                        userDeviceTO.setDeviceSeq(entry.getKey());
                        userDeviceTO.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_INPROGRESS);
                        userDeviceTO.setDeviceStatus(IAppsConstants.DEVICE_STATUS_ACTIVE);
                        userDeviceTO.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_ASSIGN);
//                        userDeviceService.createUserDevice(userDeviceTO);
                	}
                }
                
            }
        }

        // no provsion need.
        if(provisionTO == null){
            return null;
        }
        return provisionTO.getReqId();
    }
    // for webservice, if call unAssignProvisionUser directlly from deleteadaptor, will cannot found the request via request id.
    public String autoUnAssignProvisionUser(List<String> serviceIds, List<String> user2ProductIds, String svcDefCatetroy, String svcDefOperation, UserTO userTO, List<String> noProvsionList){
        return unAssignProvisionUser(serviceIds, user2ProductIds, svcDefCatetroy, svcDefOperation, userTO, noProvsionList);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String unAssignProvisionUser(List<String> serviceIds, List<String> user2ProductIds, String svcDefCatetroy, String svcDefOperation, UserTO userTO, List<String> noProvsionList) {
        if (serviceIds == null || user2ProductIds == null || serviceIds.size() != user2ProductIds.size()) {
            throw new IllegalArgumentException("[SaaSconnect]Error occurrd when validate serviceIds and user2ProductIds.");
        }
        if (appContext == null) {
            appContext = SpringApplicationContextHolder.get();
        }
        
        List<IsvProvisionServiceTO> svcDefList = new ArrayList<IsvProvisionServiceTO>();
        List<IsvProvisionServiceTO> svcNoDefList = new ArrayList<IsvProvisionServiceTO>();
        
        for (int i = 0; i < serviceIds.size(); i++) {
            String serviceId = serviceIds.get(i);
            ServiceTO serviceParamTO = new ServiceTO();
            serviceParamTO.setServiceId(serviceId);
            ServiceTO serviceTO = service.getService(serviceParamTO);
            if (serviceTO == null) {
                throw new RuntimeException("[SaaSconnect]Error occurrd get Service by serviceID: " + serviceId);
            }
            IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
            isvProvisionServiceTO.setServiceId(serviceId);
            isvProvisionServiceTO.setUser2ProductId(user2ProductIds.get(i));
            if (StringUtils.isEmpty(serviceTO.getServiceDefName())) {
                svcNoDefList.add(isvProvisionServiceTO);
            } else {
                isvProvisionServiceTO.setServiceDefCategory(svcDefCatetroy);
                isvProvisionServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                isvProvisionServiceTO.setServiceDefName(serviceTO.getServiceDefName());
                isvProvisionServiceTO.setSvcDerfOperation(svcDefOperation);
                
                svcDefList.add(isvProvisionServiceTO);
            }
        }
        
        // provision
        ProvisionTO provisionTO = processProvisionRequest(userTO.getDomainId(), svcDefList);
        
        // update user product status
        if (null != svcNoDefList && svcNoDefList.size() > 0) {
            for (int i = 0; i < svcNoDefList.size(); i++) {
                IsvProvisionServiceTO isvProvisionServiceTO = svcNoDefList.get(i);
                UserProductTO userProduct = new UserProductTO();
                userProduct.setUserProductId(isvProvisionServiceTO.getUser2ProductId());

                userProduct = userProductService.getUserProduct(userProduct);
                userProduct.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_UNASSIGN);
                userProduct.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_YES);
                userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_SUCCESS);
                userProduct.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_TERMINATED);
                userProductService.updateUserProduct(userProduct);
                userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProduct);
                noProvsionList.add(userProduct.getUserProductId());
            }
        }
        
        if (null != svcDefList && svcDefList.size() > 0) {
            for (int i = 0; i < svcDefList.size(); i++) {
                IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
                UserProductTO userProduct = new UserProductTO();
                userProduct.setUserProductId(isvProvisionServiceTO.getUser2ProductId());

                userProduct = userProductService.getUserProduct(userProduct);
                userProduct.setStatusType(IAppsConstants.ASSIGN_STATUS_TYPE_UNASSIGN);
                userProduct.setUserProductLock(IAppsConstants.USER_PRODUCT_LOCK_STATUS_NO);
                userProduct.setProDescCodeId(IAppsConstants.PRO_DES_CODE_ID_INPROGRESS);
                userProduct.setUserProductStatus(IAppsConstants.USER_PRODUCT_STATUS_ACTIVE);
                userProduct.setProTxId(isvProvisionServiceTO.getIsvServiceId());
                
                userProductService.updateUserProduct(userProduct);
                userAssignmentService.createUserAssignment(SequenceUUID.getInstance().getUUID(), userProduct);
            }
        }
        
        // no provsion need.
        if(provisionTO == null){
            return null;
        }
        return provisionTO.getReqId();
    }
    

    private ProvisionTO processProvisionRequest(String domainId, List<IsvProvisionServiceTO> svcDefList) {
        // provision
        List<IsvSvc> isvSvcList = new ArrayList<IsvSvc>();
        if(svcDefList == null || svcDefList.size() == 0){
            return null;
        }
        for (int i = 0; i < svcDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
            IsvSvcImpl isvSvc = new IsvSvcImpl(isvProvisionServiceTO.getServiceDefName(), isvProvisionServiceTO
                    .getServiceDefCategory(), isvProvisionServiceTO.getSvcDerfOperation(), isvProvisionServiceTO
                    .getServiceDefVersion());
            isvSvc.prepareIsvSvcDefParameter(isvProvisionServiceTO.getJspArray());
            isvSvcList.add(isvSvc);
        }
        ProvisionTO provisionTO = IsvSvcBuilder.populateProvision(domainId, isvSvcList);
        provisionService.createProvisionRequest(provisionTO);

        for (int i = 0; i < svcDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
            isvProvisionServiceTO.setIsvServiceId(provisionTO.getIsvServiceList().get(i).getIsvServiceId());
        }
        return provisionTO;

    }

    private List<String[]> processValidateForServiceId(List<IsvProvisionServiceTO> svcDefList) {
        // check if same items in the list
        List<String[]> errorMsgList = new ArrayList<String[]>();
        for (int i = 0; i < svcDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
            if (IsvSvc.SERVICE_DEF_OPERATION_CREATE.equals(isvProvisionServiceTO.getSvcDerfOperation())
                    && StringUtils.isNotEmpty(isvProvisionServiceTO.getReferenceId())) {
                for (int j = i + 1; j < svcDefList.size(); j++) {
                    IsvProvisionServiceTO compareTO = svcDefList.get(j);
                    if (StringUtils.isNotEmpty(compareTO.getReferenceId())
                            && compareTO.getReferenceId().equals(isvProvisionServiceTO.getReferenceId())
                            && compareTO.getServiceId().equals(isvProvisionServiceTO.getServiceId())) {
                        errorMsgList.add(new String[] { config.getPropertyAsString(IAppsConstants.SAAS_PROVISION,
                                IAppsConstants.PROVISION_ERROR_SAME_REFID_SERVICEID, "") });
                        break;

                    }
                }
            }
        }
        return errorMsgList;
    }

    private void processReferenceId(String domainId, List<IsvProvisionServiceTO> svcDefList) {
        // handle reference id.
        for (int i = 0; i < svcDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
            PackageOrderTO packageOrderTO = new PackageOrderTO();
            packageOrderTO.setPackageOrderId(isvProvisionServiceTO.getPackageOrderId());
            packageOrderTO = packageOrderService.getPackageOrder(packageOrderTO);
            String referenceId = null;
            if (StringUtils.isEmpty(packageOrderTO.getOldDomainPackageId())) {
                ValidateAdaptorService validateAdaptorService = (ValidateAdaptorService) appContext.getBean(isvProvisionServiceTO.getValidateAdaptorBean());
                referenceId = validateAdaptorService.getReferenceId(new HashMap<String, String>(), isvProvisionServiceTO.getJspArray());
            }else{
                Domain2PackageTO domain2PackageTO = new Domain2PackageTO();
                domain2PackageTO.setDomainPackageId(packageOrderTO.getOldDomainPackageId());
                domain2PackageTO = domain2PackageService.getDomain2Package(domain2PackageTO);
                if(domain2PackageTO == null){
                    //TODO
                }
                
                Domain2ProductTO domain2ProductTO = new Domain2ProductTO();
                domain2ProductTO.setDomainPackageId(domain2PackageTO.getDomainPackageId());
                domain2ProductTO.setServiceId(isvProvisionServiceTO.getServiceId());
                domain2ProductTO.setDomainProductStatus(IAppsConstants.PRODUCT_STATUS_ACTIVE);
                List<Domain2ProductTO> domain2ProductList = domain2ProductService.getDomain2ProductList(domain2ProductTO);
                if(domain2ProductList.size() != 1){
                    //TODO
                }else{
                    domain2ProductTO = domain2ProductList.get(0);
                }
                referenceId = domain2ProductTO.getDomainServiceRefId();
            }
            
            isvProvisionServiceTO.setReferenceId(referenceId);
            if (StringUtils.isEmpty(referenceId)) {
                isvProvisionServiceTO.setSvcDerfOperation(IsvSvc.SERVICE_DEF_OPERATION_CREATE);
            } else {
                Domain2ProductTO domain2ProductParamTO = new Domain2ProductTO();
                domain2ProductParamTO.setServiceId(isvProvisionServiceTO.getServiceId());
                domain2ProductParamTO.setDomainServiceRefId(referenceId);
                domain2ProductParamTO.setDomainProductStatus(IAppsConstants.PRODUCT_STATUS_ACTIVE);
                domain2ProductParamTO.setDomainId(domainId);
                List<Domain2ProductTO> domain2ProductList = domain2ProductService
                        .getDomain2ProductList(domain2ProductParamTO);
                if (domain2ProductList.size() > 0) {
                	Domain2PackageTO domain2Package =  new Domain2PackageTO();
                	domain2Package.setDomainPackageId(domain2ProductList.get(0).getDomainPackageId());
                	domain2Package = domain2PackageService.getDomain2Package(domain2Package);
                	if(null!=domain2Package && IAppsConstants.PACKAGE_STATUS_ACTIVE.equalsIgnoreCase(domain2Package.getDomainPackageStatus())){
                		isvProvisionServiceTO.setSvcDerfOperation(IsvSvc.SERVICE_DEF_OPERATION_UPDATE);
                	}else{
                		isvProvisionServiceTO.setSvcDerfOperation(IsvSvc.SERVICE_DEF_OPERATION_CREATE);
                	}
                } else {
                    isvProvisionServiceTO.setSvcDerfOperation(IsvSvc.SERVICE_DEF_OPERATION_CREATE);
                }
            }
        }
    }

    private List<String[]> processValidate(List<IsvProvisionServiceTO> svcDefList) {
        List<String[]> errorMessageList = new ArrayList<String[]>();
        // validate jsp fields.
        for (int i = 0; i < svcDefList.size(); i++) {
            IsvProvisionServiceTO isvProvisionServiceTO = svcDefList.get(i);
            PackageOrderTO packageOrderTO = new PackageOrderTO();
            packageOrderTO.setPackageOrderId(isvProvisionServiceTO.getPackageOrderId());
            packageOrderTO = packageOrderService.getPackageOrder(packageOrderTO);
            Map<String, String> sysParamMap = new HashMap<String, String>();
            sysParamMap.put(IAppsConstants.PROVISION_VALIDATION_SYSMAP_PACKAGE_ORDER_ID, packageOrderTO.getPackageOrderId());
            if (StringUtils.isEmpty(packageOrderTO.getOldDomainPackageId())) {
                ValidateAdaptorService validateAdaptorService = (ValidateAdaptorService) appContext
                        .getBean(isvProvisionServiceTO.getValidateAdaptorBean());
                String[] errorMessageArray = validateAdaptorService.execute(sysParamMap,
                        isvProvisionServiceTO.getJspArray());
                if (errorMessageArray != null) {
                    errorMessageList.add(errorMessageArray);
                }
            }else{
                if(StringUtils.isNotEmpty(isvProvisionServiceTO.getUpdateValidateAdaptorBean())){
                    ValidateAdaptorService validateAdaptorService = (ValidateAdaptorService) appContext.getBean(isvProvisionServiceTO.getUpdateValidateAdaptorBean());
                    String[] errorMessageArray = validateAdaptorService.execute(sysParamMap,isvProvisionServiceTO.getJspArray());
                    if (errorMessageArray != null) {
                        errorMessageList.add(errorMessageArray);
                    }
                }
            }

        }
        return errorMessageList;
    }

    public void processService(List<String> serviceIds, List<String[]> jspList, List<String> product2OrderIds, List<String> packageOrderIds,
            List<String> user2ProductIds, String svcDefCatetroy, String svcDefOperation,
            List<IsvProvisionServiceTO> svcDefList, List<IsvProvisionServiceTO> svcNoDefList) {
        for (int i = 0; i < serviceIds.size(); i++) {
            String serviceId = serviceIds.get(i);
            ServiceTO serviceParamTO = new ServiceTO();
            serviceParamTO.setServiceId(serviceId);
            ServiceTO serviceTO = service.getService(serviceParamTO);
            if (serviceTO == null) {
                throw new RuntimeException("Error occurrd get Service by serviceID: " + serviceId);
            }
            IsvProvisionServiceTO isvProvisionServiceTO = new IsvProvisionServiceTO();
            isvProvisionServiceTO.setServiceId(serviceId);
            isvProvisionServiceTO.setPackageOrderId(packageOrderIds.get(i));
            if (product2OrderIds != null) {
                isvProvisionServiceTO.setProduct2OrderId(product2OrderIds.get(i));
            }
            if (user2ProductIds != null) {
                isvProvisionServiceTO.setUser2ProductId(user2ProductIds.get(i));
            }
            if (StringUtils.isEmpty(serviceTO.getServiceDefName())) {
                svcNoDefList.add(isvProvisionServiceTO);
            } else {
                isvProvisionServiceTO.setJspArray(jspList.get(i));
                isvProvisionServiceTO.setServiceDefCategory(svcDefCatetroy);
                isvProvisionServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                isvProvisionServiceTO.setServiceDefName(serviceTO.getServiceDefName());

                if (!StringUtils.isEmpty(svcDefOperation)) {
                    isvProvisionServiceTO.setSvcDerfOperation(svcDefOperation);
                }

                IsvServiceTO paramIsvServiceTO = new IsvServiceTO();
                paramIsvServiceTO.setServiceName(serviceTO.getServiceDefName());
                paramIsvServiceTO.setServiceCategory(svcDefCatetroy);
                paramIsvServiceTO.setServiceOperation(IsvSvc.SERVICE_DEF_OPERATION_VALIDATE);
                paramIsvServiceTO.setServiceDefVersion(serviceTO.getServiceDefVersion());
                // get validate adapter
                IsvServiceDefTO validateIsvServiceDefTO = provisionService.getIsvServiceDef(paramIsvServiceTO);
                if (validateIsvServiceDefTO == null) {
                    throw new RuntimeException("Error occurrd get get validate adapter: "
                            + paramIsvServiceTO.getServiceName() + "," + paramIsvServiceTO.getServiceCategory() + ","
                            + paramIsvServiceTO.getServiceOperation() + "," + paramIsvServiceTO.getServiceDefVersion());
                }
                IsvAdaptorTO validateIsvAdaptorTO = provisionService.getSvcAdaptor(validateIsvServiceDefTO
                        .getIsvProvAdaptorId());

                // get data transfer adapter
                paramIsvServiceTO.setServiceOperation(IsvSvc.SERVICE_DEF_OPERATION_DATATRANSFER);
                IsvServiceDefTO dataTranIsvServiceDefTO = provisionService.getIsvServiceDef(paramIsvServiceTO);
                if (dataTranIsvServiceDefTO == null) {
                    throw new RuntimeException("Error occurrd get data transfer adapter: "
                            + paramIsvServiceTO.getServiceName() + "," + paramIsvServiceTO.getServiceCategory() + ","
                            + paramIsvServiceTO.getServiceOperation() + "," + paramIsvServiceTO.getServiceDefVersion());
                }
                IsvAdaptorTO dataTranIsvAdaptorTO = provisionService.getSvcAdaptor(dataTranIsvServiceDefTO
                        .getIsvProvAdaptorId());
                
                //update service validator
                paramIsvServiceTO.setServiceOperation(IsvSvc.SERVICE_DEF_OPERATION_UPDATEVALIDATE);
                IsvServiceDefTO updateValidateIsvServiceDefTO = provisionService.getIsvServiceDef(paramIsvServiceTO);
                if(updateValidateIsvServiceDefTO != null){
                    IsvAdaptorTO updateValidateIsvAdaptorTO = provisionService.getSvcAdaptor(updateValidateIsvServiceDefTO
                            .getIsvProvAdaptorId());
                    isvProvisionServiceTO.setUpdateValidateAdaptorBean(updateValidateIsvAdaptorTO.getIsvAdaptorEndpoint());
                }
                isvProvisionServiceTO.setValidateAdaptorBean(validateIsvAdaptorTO.getIsvAdaptorEndpoint());
                isvProvisionServiceTO.setDataTransferAdaptorBean(dataTranIsvAdaptorTO.getIsvAdaptorEndpoint());
                svcDefList.add(isvProvisionServiceTO);
            }
        }
    }

    public void setProductOrderDAO(ProductOrderDAO productOrderDAO) {
        this.productOrderDAO = productOrderDAO;
    }

    public ProductOrderDAO getProductOrderDAO() {
        return productOrderDAO;
    }

    public UserProductService getUserProductService() {
        return userProductService;
    }

    public void setUserProductService(UserProductService userProductService) {
        this.userProductService = userProductService;
    }

    public int updateProductOrderStatusByProTxId(String proTxId, String productOrderStatus) {
        return this.productOrderDAO.updateProductOrderStatusByProTxId(proTxId, productOrderStatus);
    }

    public UserAssignmentService getUserAssignmentService() {
        return userAssignmentService;
    }

    public void setUserAssignmentService(UserAssignmentService userAssignmentService) {
        this.userAssignmentService = userAssignmentService;
    }

    public Domain2PackageService getDomain2PackageService() {
        return domain2PackageService;
    }

    public void setDomain2PackageService(Domain2PackageService domain2PackageService) {
        this.domain2PackageService = domain2PackageService;
    }

    public PackageOrderService getPackageOrderService() {
        return packageOrderService;
    }

    public void setPackageOrderService(PackageOrderService packageOrderService) {
        this.packageOrderService = packageOrderService;
    }
}