package com.csb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.csb.core.model.CsbAppCategory;
import com.csb.core.model.CsbPlatformPlan;
import com.csb.core.service.AppCategoryService;
import com.csb.core.service.PlanService;

public class EntityTest extends BaseIT {

    // @Autowired
    // public AppGroupRepository appGroupRepositoy;
    //
    // @Autowired
    // public AppPackageRepository appPackageRepositoy;
    // @Autowired
    // public AppProductRepository appProductRepository;
    // @Autowired
    // public AppServiceRepository appServiceRepository;
    //
    // @Autowired
    // public ProvisionIsvServiceDefRepository provisionIsvServiceDefRepository;
    //
    // @Autowired
    // public ProvisionRequestRepository provisionRequestRepository;
    // //@Autowired
    // public OrderRepository orderRepository;

    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private PlanService planService;
    
    @Test
    public void testAppCategory() {
        CsbAppCategory appCategory = appCategoryService.selectById(1);
        System.out.println("-----------" + appCategory.getName());
    }

    @Test
    public void testPlan() {
        CsbPlatformPlan plan = planService.get(1L);
        System.out.println("-----------" + plan.getEventId());
    }

    @Test
    public void testAppPackage() {
        // List<AppPackage> appPackageList = Lists.newArrayList(appPackageRepositoy.findAll());
        // for (AppPackage appPackage : appPackageList) {
        // if (appPackage.getAppGroup() != null) {
        // System.out.println("Group - " + appPackage.getAppGroup().getGroupName());
        // }
        //
        // System.out.println("Package - " + appPackage.getPackageId());
        // if (appPackage.getAppProductList().size() > 0) {
        // for (AppPlan appPlan : appPackage.getAppProductList()) {
        // System.out.println("Product - " + appPlan.getProductId());
        // if (appPlan.getAppService() != null) {
        // System.out.println("Servcie - " + appPlan.getAppService().getServiceId());
        // }
        // }
        //
        // System.out.println("----------------------------- ");
        // }
        // }
    }

    @Test
    public void testProvisionIsvServiceDef() {
        //
        // ProvisionIsvServiceDef provisionIsvServiceDef = provisionIsvServiceDefRepository.findOne(84L);
        // if (provisionIsvServiceDef != null) {
        // System.out.println("ISV Adaptor ID - " + provisionIsvServiceDef.getProvisionIsvAdaptor().getIsvAdaptorId());
        // for (ProvisionIsvServiceParaDef provisionIsvServiceParaDef :
        // provisionIsvServiceDef.getProvisionIsvServiceParaDefList()) {
        // System.out.println("ISV Param ID - " + provisionIsvServiceParaDef.getIsvServiceParaDefId());
        // }
        //
        // }

    }

    @Test
    public void testProvisionRequest() {
        //
        // ProvisionRequest provisionRequest = provisionRequestRepository.findOne(3679L);
        // if (provisionRequest != null) {
        // System.out.println("Provision Request - " + provisionRequest.getReqNo());
        // for (ProvisionIsvService provisionIsvService : provisionRequest.getProvisionIsvServiceList()) {
        // System.out.println("provisionIsvService name - " + provisionIsvService.getServiceName());
        // if (provisionIsvService.getProvisionServiceRes() != null) {
        // System.out.println("getProvisionServiceRes- " +
        // provisionIsvService.getProvisionServiceRes().getProvisionResMessage());
        // if (provisionIsvService.getProvisionServiceRes().getProvisionServiceResDetailList() != null) {
        // for (ProvisionServiceResDetail provisionServiceResDetail :
        // provisionIsvService.getProvisionServiceRes().getProvisionServiceResDetailList()) {
        // System.out.println("provisionServiceResDetail - " + provisionServiceResDetail.getServiceResFieldName());
        // }
        // }
        // }
        //
        // }
        //
        // }

    }

    @Test
    public void testOrder() {
        //
        // Order order = orderRepository.findOne(71L);
        // if (order != null) {
        // System.out.println("Orde - " + order.getOrderRefNum());
        // for (OrderPackage orderPackage : order.getOrderPackageList()) {
        // System.out.println("orderPackage - " + orderPackage.getAppPackage().getPackageId());
        // if (orderPackage.getOrderProductList() != null) {
        // for (OrderProduct orderProduct : orderPackage.getOrderProductList()) {
        // System.out.println("orderProduct - " + orderProduct.getAppProduct().getProductId());
        // }
        // }
        // }
        //
        // }

    }

}
