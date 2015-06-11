package com.saas.provision.service;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.csb.common.ConfigProperties;
import com.csb.common.IAppsConstants;
import com.csb.common.SpringApplicationContextHolder;

import org.slf4j.*;

import com.saas.common.to.UserTO;
import com.saas.pckge.service.Domain2ProductService;
import com.saas.pckge.service.PackageOrderService;
import com.saas.pckge.to.Domain2ProductTO;
import com.saas.pckge.to.PackageOrderTO;
import com.saas.product.to.ProductOrderTO;
import com.saas.product.to.UserProductTO;
import com.saas.provision.util.IsvSvc;

public abstract class DeleteAdaptor extends BaseAdaptor implements AdaptorService {
    private static Logger log = LoggerFactory.getLogger(DeleteAdaptor.class);

    @Override
    public Map<String, Object> execute(Map<String, String> paraMap, Map<String, String> serviceMap) {
        config = ConfigProperties.getInstance();
        if ("Y".equalsIgnoreCase(config.getPropertyAsString(IAppsConstants.SAAS_CONFIG, IAppsConstants.PACKAGE_AUTOUNASSIGN_INDICATOR, ""))) {
            String proTxId = serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID);
            try {
                log.info("[SaaSconnect] Delete Adaptor - Auto un-assign product, protxid: " + proTxId);
                String returnCode = IsvConstants.ISV_ADAP_SUCCESS;
                if (appContext == null) {
                    appContext = SpringApplicationContextHolder.get();
                }
                ProvisionService provisionService = (ProvisionService) appContext.getBean("provisionService");
                Domain2ProductService domain2ProductService = (Domain2ProductService) appContext.getBean("domain2ProductService");

                PackageOrderService packageOrderService = (PackageOrderService) appContext.getBean("packageOrderService");

                ProductOrderTO productOrder = productOrderService.getProductOrderByProTxId(proTxId);

                PackageOrderTO packageOrderTO = new PackageOrderTO();
                packageOrderTO.setPackageOrderId(productOrder.getPackageOrderId());
                packageOrderTO = packageOrderService.getPackageOrder(packageOrderTO);

                if (null != packageOrderTO) {
                    Integer license = domain2ProductService.getLicenseAssigned(packageOrderTO.getOldDomainPackageId(), "", "");
                    log.info("[SaaSconnect] Delete Adaptor - Auto un-assign product, license assigned: " + license + ", protxid: " + proTxId);
                    if (license > 0) {
                        UserTO userTO = new UserTO();
                        List<String> user2ProductIds = new ArrayList<String>();
                        List<String> serviceIds = new ArrayList<String>();

                        Domain2ProductTO domain2product = new Domain2ProductTO();
                        domain2product.setDomainPackageId(packageOrderTO.getOldDomainPackageId());
                        List<Domain2ProductTO> domain2productList = domain2ProductService.getDomain2ProductList(domain2product);

                        UserProductTO userProductParam;
                        List<UserProductTO> userProducts;
                        for (Domain2ProductTO domain2ProductItem : domain2productList) {
                            userProductParam = new UserProductTO();

                            userProductParam.setDomainProductId(domain2ProductItem.getDomainProductId());
                            userTO.setDomainId(domain2ProductItem.getDomainId());
                            userProducts = userProductService.getAllActiveAssignedUserProducts(userProductParam);
                            for (UserProductTO userProduct : userProducts) {
                                log.info("[SaaSconnect] Delete Adaptor - Auto un-assign product, user product id: " + userProduct.getUserProductId() + ", protxid: " + proTxId);
                                user2ProductIds.add(userProduct.getUserProductId());
                                serviceIds.add(userProduct.getServiceId());
                            }
                        }

                        if (serviceIds.size() > 0) {
                            List<String> noProvsionList = new ArrayList<String>();
                            String requestId = productOrderService.autoUnAssignProvisionUser(serviceIds, user2ProductIds, IsvSvc.SERVICE_DEF_CATEGORY_USER,
                                    IsvSvc.SERVICE_DEF_OPERATION_DELETE, userTO, noProvsionList);
                            if (StringUtils.isNotEmpty(requestId)) {
                                provisionService.provisionRequest(requestId);
                            }
                        }
                        if (domain2ProductService.getLicenseAssigned(packageOrderTO.getOldDomainPackageId(), "", "") > 0) {
                            log.info("[SaaSconnect] Delete Adaptor - Auto un-assign product, licenses have not beed unassign completelly. protxid: " + proTxId);
                            String returnDesc = config.getPropertyAsString("saas-provision", "error.deprovision.auto.unassign", "");
                            returnCode = IsvConstants.ISV_ADAP_ERROR_DEPROVISION_AUTO_UNASSIGN;
                            updateProductOrderStatus(serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID), IAppsConstants.PACKAGE_ORDER_STATUS_FAILED);
                            Map<String, Object> responseMap = new HashMap<String, Object>();
                            responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, returnCode);
                            responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, returnDesc);
                            responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_SERVICE_MSG, returnDesc);
                            return responseMap;
                        }
                        log.info("[SaaSconnect] Delete Adaptor - Auto un-assign product successfully, start to process de-provision logic protxid: " + proTxId);
                    }
                }
            } catch (Exception e) {
                log.info("[SaaSconnect] Delete Adaptor - Auto un-assign product, Error occurred, protxid: " + proTxId, e);
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                String returnMessage = sw.toString();
                try {
                    pw.close();
                    sw.close();
                } catch (Exception e1) {
                    if (log.isInfoEnabled()) {
                        log.info("[SaaSconnect] Delete Adaptor - Auto un-assign product, Error Closing Printwriter and String Writer, protxid: " + proTxId);
                    }
                }
                updateProductOrderStatus(serviceMap.get(IAppsConstants.SERVICE_MAP_SERVICE_ID), IAppsConstants.PACKAGE_ORDER_STATUS_FAILED);
                String returnDesc = config.getPropertyAsString("saas-provision", "error.deprovision.auto.unassign", "");
                Map<String, Object> responseMap = new HashMap<String, Object>();
                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_CODE, IsvConstants.ISV_ADAP_ERROR_DEPROVISION_AUTO_UNASSIGN);
                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_MSG, returnMessage);
                responseMap.put(IAppsConstants.ISV_ADAPTOR_RETURN_DETAIL_SERVICE_MSG, returnDesc);

                return responseMap;
            }
        }

        return executeProductLogic(paraMap, serviceMap);
    }

    public abstract Map<String, Object> executeProductLogic(Map<String, String> paraMap, Map<String, String> serviceMap);
}
