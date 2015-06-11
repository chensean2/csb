package com.csb.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.csb.repository.AppGroupRepository;
import com.csb.repository.AppPackageRepository;
import com.csb.repository.AppProductRepository;
import com.csb.repository.AppServiceRepository;
import com.csb.repository.OrderRepository;
import com.csb.repository.ProvisionIsvServiceDefRepository;
import com.csb.repository.ProvisionRequestRepository;
import com.google.common.collect.Lists;
import com.saas.entity.AppPackage;
import com.saas.entity.AppProduct;
import com.saas.entity.Order;
import com.saas.entity.OrderPackage;
import com.saas.entity.OrderProduct;
import com.saas.entity.ProvisionIsvService;
import com.saas.entity.ProvisionIsvServiceDef;
import com.saas.entity.ProvisionIsvServiceParaDef;
import com.saas.entity.ProvisionRequest;
import com.saas.entity.ProvisionServiceResDetail;

public class EntityTest extends BaseIT {

    @Autowired
    public AppGroupRepository appGroupRepositoy;

    @Autowired
    public AppPackageRepository appPackageRepositoy;
    @Autowired
    public AppProductRepository appProductRepository;
    @Autowired
    public AppServiceRepository appServiceRepository;

    @Autowired
    public ProvisionIsvServiceDefRepository provisionIsvServiceDefRepository;

    @Autowired
    public ProvisionRequestRepository provisionRequestRepository;
    @Autowired
    public OrderRepository orderRepository;

    @Test
    public void testAppPackage() {
        List<AppPackage> appPackageList = Lists.newArrayList(appPackageRepositoy.findAll());
        for (AppPackage appPackage : appPackageList) {
            if (appPackage.getAppGroup() != null) {
                System.out.println("Group - " + appPackage.getAppGroup().getGroupName());
            }

            System.out.println("Package - " + appPackage.getPackageId());
            if (appPackage.getAppProductList().size() > 0) {
                for (AppProduct appProduct : appPackage.getAppProductList()) {
                    System.out.println("Product - " + appProduct.getProductId());
                    if (appProduct.getAppService() != null) {
                        System.out.println("Servcie - " + appProduct.getAppService().getServiceId());
                    }
                }

                System.out.println("----------------------------- ");
            }
        }
    }

    @Test
    public void testProvisionIsvServiceDef() {

        ProvisionIsvServiceDef provisionIsvServiceDef = provisionIsvServiceDefRepository.findOne(84L);
        if (provisionIsvServiceDef != null) {
            System.out.println("ISV Adaptor ID - " + provisionIsvServiceDef.getProvisionIsvAdaptor().getIsvAdaptorId());
            for (ProvisionIsvServiceParaDef provisionIsvServiceParaDef : provisionIsvServiceDef.getProvisionIsvServiceParaDefList()) {
                System.out.println("ISV Param ID - " + provisionIsvServiceParaDef.getIsvServiceParaDefId());
            }

        }

    }

    @Test
    public void testProvisionRequest() {

        ProvisionRequest provisionRequest = provisionRequestRepository.findOne(3679L);
        if (provisionRequest != null) {
            System.out.println("Provision Request - " + provisionRequest.getReqNo());
            for (ProvisionIsvService provisionIsvService : provisionRequest.getProvisionIsvServiceList()) {
                System.out.println("provisionIsvService name - " + provisionIsvService.getServiceName());
                if (provisionIsvService.getProvisionServiceRes() != null) {
                    System.out.println("getProvisionServiceRes- " + provisionIsvService.getProvisionServiceRes().getProvisionResMessage());
                    if (provisionIsvService.getProvisionServiceRes().getProvisionServiceResDetailList() != null) {
                        for (ProvisionServiceResDetail provisionServiceResDetail : provisionIsvService.getProvisionServiceRes().getProvisionServiceResDetailList()) {
                            System.out.println("provisionServiceResDetail - " + provisionServiceResDetail.getServiceResFieldName());
                        }
                    }
                }

            }

        }

    }

    @Test
    public void testOrder() {

        Order order = orderRepository.findOne(71L);
        if (order != null) {
            System.out.println("Orde - " + order.getOrderRefNum());
            for (OrderPackage orderPackage : order.getOrderPackageList()) {
                System.out.println("orderPackage - " + orderPackage.getAppPackage().getPackageId());
                if (orderPackage.getOrderProductList() != null) {
                    for (OrderProduct orderProduct : orderPackage.getOrderProductList()) {
                        System.out.println("orderProduct - " + orderProduct.getAppProduct().getProductId());
                    }
                }
            }

        }

    }

}
