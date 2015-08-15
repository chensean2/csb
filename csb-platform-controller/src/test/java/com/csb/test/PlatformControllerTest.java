package com.csb.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.w3c.dom.DocumentType;

import com.csb.common.manifest.CordsImage;
import com.csb.common.manifest.CordsInfrastructure;
import com.csb.common.manifest.CordsManifest;
import com.csb.common.manifest.CordsNode;
import com.csb.common.saas.manifest.AccountType;
import com.csb.common.saas.manifest.CompanyType;
import com.csb.common.saas.manifest.CreatorType;
import com.csb.common.saas.manifest.CustomeAttributeType;
import com.csb.common.saas.manifest.CustomeAttributesType;
import com.csb.common.saas.manifest.ItemType;
import com.csb.common.saas.manifest.ModuleType;
import com.csb.common.saas.manifest.ModulesType;
import com.csb.common.saas.manifest.OrderType;
import com.csb.common.saas.manifest.PackageType;
import com.csb.common.saas.manifest.SaasManifest;
import com.csb.common.util.UUIDUtil;
import com.csb.parser.component.model.CompanyInfo;
import com.csb.parser.component.model.CreatorInfo;
import com.csb.parser.component.model.IaaSInfo;
import com.csb.parser.component.model.SaaSInfo;
import com.csb.parser.component.model.SaaSPlanInfo;
import com.csb.parser.component.model.SaaSPlanItemInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.platform.broker.component.service.BrokerService;
import com.csb.platform.controller.ControllerService;

@ContextConfiguration(locations = { "classpath:app-test-context-platform-controller.xml" })
public class PlatformControllerTest extends BaseIT {

    private static Logger logger = LoggerFactory.getLogger(PlatformControllerTest.class);
    @Autowired
    public ControllerService controllerService;

    @Autowired
    private BrokerService csbBrokerService;

    // @Test
    public void testIaaSSubscription() {
        SubscriptionInfo s = new SubscriptionInfo();
        s.setTraceId("00001");
        s.setAppPlanId("iaas-plan-00001");
        s.setCategory("IAAS");

        IaaSInfo iaasInfo = new IaaSInfo();
        iaasInfo.setProvider("openstack");
        iaasInfo.setAction("CREATE");
        iaasInfo.setCpus(1);
        iaasInfo.setInstanceName("CSB-testGJ2");
        iaasInfo.setMemory(String.valueOf(1));
        iaasInfo.setImageName("Ubuntu 14.04 x86_64");
        iaasInfo.setStorage("10");
        // m1.1gb.1cpu.10gb
        iaasInfo.setFlavor("m1." + iaasInfo.getMemory() + "gb." + iaasInfo.getCpus() + "cpu." + iaasInfo.getStorage() + "gb");
        s.setIaasInfo(iaasInfo);
        SubscriptionResult result = controllerService.createSubscription(s);

        if (result.getEventId() != null) {
            controllerService.broke(result.getEventId());
        }
    }

    // @Test
    public void testIaaSManifest() {

        try {
            // Path path =
            // FileSystems.getDefault().getPath("/Users/gengjun/dev/saas-base-workspace",
            // "xwiki.xml");

            // String manifestStr = new String(Files.readAllBytes(path));

            CordsManifest manifest = null;
            JAXBContext jc;

            jc = JAXBContext.newInstance(com.csb.common.manifest.ObjectFactory.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            // manifest = (CordsManifest)((JAXBElement<DocumentType>)
            // unmarshaller.unmarshal(new
            // File("/Users/gengjun/dev/saas-base-workspace/xwiki.xml"))).getValue();
            manifest = (CordsManifest) ((JAXBElement<DocumentType>) unmarshaller.unmarshal(new File("C:\\Users\\gengjun\\Downloads\\xwiki.xml"))).getValue();
            System.out.println(manifest);
            CordsNode node = manifest.getNode().get(0);
            String provider = node.getProvider();
            CordsImage image = node.getImage();
            String instanceName = node.getName();
            CordsInfrastructure infra = node.getInfrastructure();
            SubscriptionInfo s = new SubscriptionInfo();

            s.setTraceId("00001");
            s.setAppPlanId("iaas-plan-00001");
            s.setCategory("IAAS");

            IaaSInfo iaasInfo = new IaaSInfo();
            iaasInfo.setProvider(provider);
            iaasInfo.setAction("CREATE");
            iaasInfo.setCpus(Integer.parseInt(infra.getCompute().getCores()));
            iaasInfo.setInstanceName(instanceName);
            iaasInfo.setMemory(infra.getCompute().getMemory().toLowerCase() + "b");
            iaasInfo.setImageName(image.getSystem().getName());
            iaasInfo.setStorage(infra.getStorage().getSize().toLowerCase() + "b");
            // m1.1gb.1cpu.10gb
            iaasInfo.setFlavor("m1." + iaasInfo.getMemory() + "." + iaasInfo.getCpus() + "cpu." + iaasInfo.getStorage());
            s.setIaasInfo(iaasInfo);
            SubscriptionResult result = controllerService.createSubscription(s);

            if (result.getEventId() != null) {
                csbBrokerService.broke(result.getEventId());
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // @Test
    public void testSaaSSubscription() {
        SubscriptionInfo s = new SubscriptionInfo();
        s.setTraceId("00001");
        s.setAppPlanId("iaas-plan-00001");
        s.setCategory("SAAS");

        SaaSInfo saasInfo = new SaaSInfo();
        saasInfo.setAction("CREATE");

        SaaSPlanInfo saasPlanInfo = new SaaSPlanInfo();
        saasPlanInfo.setPlanCode("advanced");

        List<SaaSPlanItemInfo> saasPlanItemInfoList = new ArrayList<SaaSPlanItemInfo>();
        SaaSPlanItemInfo saasPlanItemInfo = new SaaSPlanItemInfo();
        saasPlanItemInfo.setQuantity(10);
        saasPlanItemInfo.setUnit("User");
        saasPlanItemInfoList.add(saasPlanItemInfo);
        saasPlanInfo.setSaasPlanItemInfoList(saasPlanItemInfoList);
        saasInfo.setSaaSPlanInfo(saasPlanInfo);

        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setName("TestCompany");
        companyInfo.setPhoneNumber("18999999999");
        companyInfo.setUuid(UUIDUtil.generate());
        saasInfo.setCompanyInfo(companyInfo);

        CreatorInfo creatorInfo = new CreatorInfo();
        creatorInfo.setEmail("gengjun@outlook.com");
        creatorInfo.setFirstName("Jun");
        creatorInfo.setLastName("Geng");
        creatorInfo.setOpenId("http://openid.com/gengjun");
        saasInfo.setCreatorInfo(creatorInfo);

        s.setSaasInfo(saasInfo);
        SubscriptionResult result = controllerService.createSubscription(s);

        if (result.getEventId() != null) {
            controllerService.broke(result.getEventId());
        }
    }

    @Test
    public void testSaaSManifest() {

        try {
            // Path path =
            // FileSystems.getDefault().getPath("/Users/gengjun/dev/saas-base-workspace",
            // "xwiki.xml");

            // String manifestStr = new String(Files.readAllBytes(path));
            logger.debug("Provision SaaS Manifest Start...");
            SaasManifest manifest = null;
            JAXBContext jc;

            jc = JAXBContext.newInstance(com.csb.common.saas.manifest.ObjectFactory.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            manifest = (SaasManifest) ((JAXBElement<DocumentType>) unmarshaller.unmarshal(new File("/Users/gengjun/dev/saas-base-workspace/saas-manifest.xml"))).getValue();
            // manifest = (SaasManifest) ((JAXBElement<DocumentType>) unmarshaller
            // .unmarshal(new File("C:\\Users\\gengjun\\Downloads\\saas-manifest.xml"))).getValue();

            PackageType packageType = manifest.getPackage();
            String action = packageType.getAction();
            ModulesType modules = packageType.getModules();
            List<ModuleType> module = modules.getModule();
            CustomeAttributesType attributes = packageType.getCustomeAttributes();
            List<CustomeAttributeType> attr = attributes.getAttribute();

            OrderType order = manifest.getOrder();
            List<ItemType> orderItems = order.getItem();
            AccountType account = manifest.getAccount();

            CompanyType company = account.getCompany();
            CreatorType creator = account.getCreator();

            SubscriptionInfo s = new SubscriptionInfo();
            s.setTraceId("00001");
            s.setAppPlanId("iaas-plan-00002");
            s.setCategory("SAAS");

            SaaSInfo saasInfo = new SaaSInfo();
            saasInfo.setAction(action);

            SaaSPlanInfo saasPlanInfo = new SaaSPlanInfo();
            saasPlanInfo.setPlanCode(packageType.getEdition());

            List<SaaSPlanItemInfo> saasPlanItemInfoList = new ArrayList<SaaSPlanItemInfo>();
            for (ItemType item : orderItems) {
                SaaSPlanItemInfo saasPlanItemInfo = new SaaSPlanItemInfo();
                saasPlanItemInfo.setQuantity(item.getQuantity().intValue());
                saasPlanItemInfo.setUnit(item.getUnit());
                saasPlanItemInfoList.add(saasPlanItemInfo);
            }

            saasPlanInfo.setSaasPlanItemInfoList(saasPlanItemInfoList);
            saasInfo.setSaaSPlanInfo(saasPlanInfo);

            CompanyInfo companyInfo = new CompanyInfo();
            companyInfo.setName(company.getName());

            companyInfo.setUuid(company.getUuid());
            saasInfo.setCompanyInfo(companyInfo);

            CreatorInfo creatorInfo = new CreatorInfo();
            creatorInfo.setEmail(creator.getEmail());
            creatorInfo.setFirstName("");
            creatorInfo.setLastName(creator.getName());
            creatorInfo.setOpenId(creator.getOpenid());
            saasInfo.setCreatorInfo(creatorInfo);

            s.setSaasInfo(saasInfo);
            SubscriptionResult result = controllerService.createSubscription(s);

            if (result.getEventId() != null) {
                controllerService.broke(result.getEventId());
            }
            logger.debug("Provision SaaS Manifest End ...");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
