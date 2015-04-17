/*
 *  =========================================================================
 * Program Name: package com.saas.pckge.service.Domain2ProductServiceImpl
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
package com.saas.pckge.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.saas.common.ConcurrentUpdateException;
import com.saas.common.ConfigProperties;
import com.saas.common.DaoRunTimeException;
import com.saas.common.IAppsConstants;
import com.saas.common.exception.SCServiceException;
import com.saas.pckge.dao.Domain2ProductDAO;
import com.saas.pckge.dao.PackageDAO;
import com.saas.pckge.to.Domain2PackageTO;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.pckge.to.PackageOrderTO;
import com.saas.pckge.to.PackageTO;
import com.saas.product.dao.ProductOrderDAO;
import com.saas.product.to.ProductOrderTO;

public class Domain2ProductServiceImpl implements Domain2ProductService {

    private Domain2ProductDAO domain2ProductDAO;
    private PackageDAO packageDAO;
    private ProductOrderDAO productOrderDAO;
    private PackageService packageService;
    

	public ProductOrderDAO getProductOrderDAO() {
		return productOrderDAO;
	}

	public void setProductOrderDAO(ProductOrderDAO productOrderDAO) {
		this.productOrderDAO = productOrderDAO;
	}

	public PackageDAO getPackageDAO() {
		return packageDAO;
	}

	public void setPackageDAO(PackageDAO packageDAO) {
		this.packageDAO = packageDAO;
	}

	public void createDomain2Product(Domain2ProductTO domain2Product) {
        domain2ProductDAO.createDomain2Product(domain2Product);
    }

    public PackageService getPackageService() {
        return packageService;
    }

    public void setPackageService(PackageService packageService) {
        this.packageService = packageService;
    }

    public void updateDomain2Product(Domain2ProductTO domain2Product) {
        try {
            int result = domain2ProductDAO.updateDomain2Product(domain2Product);

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

    public void deleteDomain2Product(Domain2ProductTO domain2Product) {
        try {
            int result = domain2ProductDAO.deleteDomain2Product(domain2Product);
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
    //changed the serviceCategory with package level
//    public List<Domain2ProductTO> getDomainProductListByDomainPackageIdAndServiceCategory(String domainPackageId, String serviceCategory) {
//    	return domain2ProductDAO.getDomainProductListByDomainPackageIdAndServiceCategory(domainPackageId, serviceCategory);
//    }
    
    public Domain2ProductTO getMainDomainProduct(String domainPackageId){
        List<Domain2ProductTO> mainDomainProductList = domain2ProductDAO.getMainDomainProduct(domainPackageId);
        if (null != mainDomainProductList && !mainDomainProductList.isEmpty()) {
            return mainDomainProductList.get(0);
        } else {
            return null;
        }
    }
    
    public Domain2ProductTO getMainDomainProductByDomainPackageId(Domain2PackageTO domain2Package) {
        // get main domain product list by domain package id
        List<Domain2ProductTO> domain2productList = getDomain2ProductListByDomainPackageIdAndUserId(domain2Package.getDomainPackageId(), null, null);
        Domain2ProductTO mainDomainProduct = null;
        if (null != domain2productList && !domain2productList.isEmpty()) {
            PackageTO packageTO = new PackageTO();
            packageTO.setPackageId(domain2productList.get(0).getPackageId());
            packageTO = packageService.getPackage(packageTO);
            for (Domain2ProductTO domain2productItem : domain2productList) {
                if (domain2productItem.getServiceId().equalsIgnoreCase(packageTO.getMainServiceId())) {
                    domain2Package.setTotalLicenseLeft(domain2productItem.getTotalLicenseLeft());
                    domain2Package.setTotalLicenseAssigned(domain2productItem.getTotalLicenseAssigned());
                    domain2Package.setTotalLicensePurchased(domain2productItem.getTotalLicensePurchased());
                    domain2Package.setMainProductServiceId(domain2productItem.getServiceId());
                    mainDomainProduct = domain2productItem;
                    break;
                }
            }
        }
        return mainDomainProduct;

    }
    
    public ProductOrderTO getMainProductOrderByPackageOrderId(String packageOrderId){
    	
    	List<ProductOrderTO> productOrderList = productOrderDAO.getMainProductOrderByPackageOrderId(packageOrderId);
    	
		if (null != productOrderList && !productOrderList.isEmpty()) {
			return productOrderList.get(0);
		} else {
			return null;
		}
    } 
    
    public void prepareExtMailByDomainPackage(List<Domain2PackageTO> domain2PackageList, StringBuffer packageNameBuffer, StringBuffer extMailBuffer) {

        // sort the package list
        //PaginationSortOrderData data = PaginationContext.getPaginationSortOrderData();
        //data.setShowAll(true);
       // data.setSortValue("packageName");
       // data.setAscending(true);
        //PaginationContext.setPaginationSortOrderData(IConstants.DEFAULT_COOKIE_NAME, data);
        //domain2PackageList = PaginationEnabler.paginationForList(domain2PackageList);
        //PaginationContext.clearPaginationSortOrderData();

        packageNameBuffer.append("<ul>");
        String emailExt = ConfigProperties.getInstance().getPropertyAsString(IAppsConstants.SAAS_CONFIG, "mail.ext.content.backup.mobilesecurity", "");
        StringBuffer sb = new StringBuffer();
        List<PackageTO> specialPackage = new ArrayList<PackageTO>();
        List<Domain2PackageTO> specialPackageOrder = new ArrayList<Domain2PackageTO>();
        for (int i = 0; i < domain2PackageList.size(); i++) {
            Domain2PackageTO domain2Package = domain2PackageList.get(i);
            getMainDomainProductByDomainPackageId(domain2Package);

            PackageTO packageTO = new PackageTO();
            packageTO.setPackageId(domain2Package.getPackageId());
            packageTO = packageDAO.getPackage(packageTO);

            // prepare package name
            packageNameBuffer.append("<li>");
            packageNameBuffer.append(domain2Package.getPackageName());// totalLicensePurchased
            if (!StringUtils.isEmpty(packageTO.getMailPackageNameExt())) {
                packageNameBuffer.append(" ");
                packageNameBuffer.append(replaceTempalte(packageTO.getMailPackageNameExt(), domain2Package));
            }
            packageNameBuffer.append("</li>");

            // prepare extra mail content
            if (!StringUtils.isEmpty(packageTO.getMailContentExt())) {
                Domain2ProductTO domainProduct = getMainDomainProductByDomainPackageId(domain2Package);
                if (domainProduct != null) {
                    if ((domainProduct.getServiceId().equals("svc_fsecure_backup"))) {
                        specialPackage.add(packageTO);
                        specialPackageOrder.add(domain2Package);
                        emailExt = emailExt.replace("${backup}", domain2Package.getPackageName());
                        continue;
                    } else if (domainProduct.getServiceId().equals("svc_fsecure_mobile")) {
                        specialPackage.add(packageTO);
                        specialPackageOrder.add(domain2Package);
                        emailExt = emailExt.replace("${mobilesecurity}", domain2Package.getPackageName());
                        continue;
                    }
                }

                extMailBuffer.append(replaceTempalte(packageTO.getMailContentExt(), domain2Package));
                sb.append("<br/><br/>");
            }
        }
        if (specialPackage.size() > 0) {
            if (specialPackage.size() == 1) {
                sb.append(replaceTempalte(specialPackage.get(0).getMailContentExt(), specialPackageOrder.get(0)));
                sb.append("<br/><br/>");
            } else if (specialPackage.size() == 2) {
                sb.append(emailExt);
                sb.append("<br/><br/>");
            }
        }
        String tempEmailExt = sb.toString();
        if (StringUtils.isNotEmpty(tempEmailExt)) {
            tempEmailExt = tempEmailExt.substring(0, tempEmailExt.lastIndexOf("<br/>"));
            extMailBuffer.append(tempEmailExt);
        }
        packageNameBuffer.append("</ul>");
    }

    public void prepareExtMailByPackageOrder(List<PackageOrderTO> packageOrderList, StringBuffer packageNameBuffer, StringBuffer extMailBuffer) {

        // sort the package list
//        PaginationSortOrderData data = PaginationContext.getPaginationSortOrderData();
//        data.setShowAll(true);
//        data.setSortValue("packageName");
//        data.setAscending(true);
//        PaginationContext.setPaginationSortOrderData(IConstants.DEFAULT_COOKIE_NAME, data);
//        packageOrderList = PaginationEnabler.paginationForList(packageOrderList);
//        PaginationContext.clearPaginationSortOrderData();

        packageNameBuffer.append("<ul>");
        String emailExt = ConfigProperties.getInstance().getPropertyAsString(IAppsConstants.SAAS_CONFIG, "mail.ext.content.backup.mobilesecurity", "");
        StringBuffer sb = new StringBuffer();
        List<PackageTO> specialPackage = new ArrayList<PackageTO>();
        List<PackageOrderTO> specialPackageOrder = new ArrayList<PackageOrderTO>();
        for (int i = 0; i < packageOrderList.size(); i++) {
            PackageOrderTO packageOrder = packageOrderList.get(i);
            PackageTO packageTO = new PackageTO();
            packageTO.setPackageId(packageOrder.getPackageId());
            packageTO = packageDAO.getPackage(packageTO);

            // tbl_ss_product2order

            // prepare package name
            packageNameBuffer.append("<li>");
            packageNameBuffer.append(packageOrder.getPackageName());// totalLicensePurchased
            if (!StringUtils.isEmpty(packageTO.getMailPackageNameExt())) {
                packageNameBuffer.append(" ");
                packageNameBuffer.append(replaceTempalte(packageTO.getMailPackageNameExt(), packageOrder));
            }

            packageNameBuffer.append("</li>");

            // prepare extra mail content
            if (!StringUtils.isEmpty(packageTO.getMailContentExt())) {
                ProductOrderTO productOrderTO = getMainProductOrderByPackageOrderId(packageOrder.getPackageOrderId());
                if (productOrderTO != null) {
                    if ((productOrderTO.getServiceId().equals("svc_fsecure_backup"))) {
                        specialPackage.add(packageTO);
                        specialPackageOrder.add(packageOrder);
                        emailExt = emailExt.replace("${backup}", packageOrder.getPackageName());
                        continue;
                    } else if (productOrderTO.getServiceId().equals("svc_fsecure_mobile")) {
                        specialPackage.add(packageTO);
                        specialPackageOrder.add(packageOrder);
                        emailExt = emailExt.replace("${mobilesecurity}", packageOrder.getPackageName());
                        continue;
                    }
                }

                sb.append(replaceTempalte(packageTO.getMailContentExt(), packageOrder));
                sb.append("<br/><br/>");
            }
        }
        if (specialPackage.size() > 0) {
            if (specialPackage.size() == 1) {
                sb.append(replaceTempalte(specialPackage.get(0).getMailContentExt(), specialPackageOrder.get(0)));
                sb.append("<br/><br/>");
            } else if (specialPackage.size() == 2) {
                sb.append(emailExt);
                sb.append("<br/><br/>");
            }
        }
        String tempEmailExt = sb.toString();
        if (StringUtils.isNotEmpty(tempEmailExt)) {
            tempEmailExt = tempEmailExt.substring(0, tempEmailExt.lastIndexOf("<br/>"));
            extMailBuffer.append(tempEmailExt);
        }
        packageNameBuffer.append("</ul>");
    }
    
    private String replaceTempalte(String contentExt,PackageOrderTO packageOrder){
    	ConfigProperties conf = ConfigProperties.getInstance();
    	String totalLicensePurchased = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG, IAppsConstants.PARAMETER_TOTAL_LICENSE, "");
    	String packageName = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG, IAppsConstants.PARAMETER_PACKAGE_NAME, "");
    	
    	ProductOrderTO productOrderTO= getMainProductOrderByPackageOrderId(packageOrder.getPackageOrderId());
    	
    	contentExt = contentExt.replace(totalLicensePurchased, String.valueOf(packageOrder.getQuantityPurchased()*productOrderTO.getUsageQuantity()));
    	contentExt = contentExt.replace(packageName, packageOrder.getPackageName());
    	return contentExt;
    }
    
    private String replaceTempalte(String contentExt,Domain2PackageTO domain2Package){
    	ConfigProperties conf = ConfigProperties.getInstance();
    	String totalLicensePurchased = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG, IAppsConstants.PARAMETER_TOTAL_LICENSE, "");
    	String packageName = conf.getPropertyAsString(IAppsConstants.SAAS_CONFIG, IAppsConstants.PARAMETER_PACKAGE_NAME, "");
    	contentExt = contentExt.replace(totalLicensePurchased, domain2Package.getTotalLicensePurchased());
    	contentExt = contentExt.replace(packageName, domain2Package.getPackageName());
    	return contentExt;
    }
    
    public Domain2ProductTO getDomain2Product(Domain2ProductTO domain2Product) {
        return domain2ProductDAO.getDomain2Product(domain2Product);
    }

    public List<Domain2ProductTO> getDomain2ProductList(Domain2ProductTO domain2Product) {
        return domain2ProductDAO.getDomain2ProductList(domain2Product);
    }
    
    public List<Domain2ProductTO> getDomain2ProductListByDomainPackageIdAndUserId(String domainPackageId, String domainProductId, String userId){
        return domain2ProductDAO.getDomain2ProductListByDomainPackageIdAndUserId(domainPackageId, domainProductId, userId);
    }
    
    public Integer getLicenseAssigned(String domainPackageId, String domainProductId, String userId){
    	return domain2ProductDAO.getLicenseAssigned(domainPackageId, domainProductId, userId);
    }

    public List<Domain2ProductTO> searchDomain2ProductList(Domain2ProductTO domain2Product) {
        return domain2ProductDAO.searchDomain2ProductList(domain2Product);
    }

    public void setDomain2ProductDAO(Domain2ProductDAO domain2ProductDAO) {
        this.domain2ProductDAO = domain2ProductDAO;
    }

    public Domain2ProductDAO getDomain2ProductDAO() {
        return domain2ProductDAO;
    }

    public boolean checkUnCompletedService(String domainId, String serviceId) {
        return domain2ProductDAO.checkUnCompletedService(domainId, serviceId);
    }
    
    public boolean checkOrderStatus(String domainId, String serviceId, String orderType, String orderStatus, String packageOrderStatus, String productOrderStatus){
        return domain2ProductDAO.checkOrderStatus( domainId, serviceId, orderType, orderStatus, packageOrderStatus, productOrderStatus, null);
    }
    
    public boolean checkOrderStatusExcludeProTxId(String domainId, String serviceId, String orderType, String orderStatus, String packageOrderStatus, String productOrderStatus, String excluedProTxId){
        return domain2ProductDAO.checkOrderStatus( domainId, serviceId, orderType, orderStatus, packageOrderStatus, productOrderStatus, excluedProTxId);
    }
    
    public List<Domain2ProductTO> getActiveDomain2ProductList(Domain2ProductTO domain2Product) {
        return domain2ProductDAO.getActiveDomain2ProductList(domain2Product);
    }
    
    public List<Domain2ProductTO> getActiveDomain2ProductsByDomainId(Domain2ProductTO domain2Product){
        return domain2ProductDAO.getActiveDomain2ProductsByDomainId(domain2Product);
    }
    public boolean checkActiveService(String domainId, String serviceId) {
    	  Domain2ProductTO domain2Product = new Domain2ProductTO();
          domain2Product.setDomainId(domainId);
          domain2Product.setServiceId(serviceId);
          List<Domain2ProductTO> domain2ProdList = domain2ProductDAO.getActiveDomain2ProductsByDomainId(domain2Product);
          if(domain2ProdList != null && domain2ProdList.size() > 0){
        	  return true;
          }
        return false;
    }
}