package com.csb.mall.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.DocumentType;

import com.csb.common.constant.MediaTypes;
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
import com.csb.core.rest.to.PocIaaSInfoTO;
import com.csb.parser.component.model.CompanyInfo;
import com.csb.parser.component.model.CreatorInfo;
import com.csb.parser.component.model.IaaSInfo;
import com.csb.parser.component.model.SaaSInfo;
import com.csb.parser.component.model.SaaSPlanInfo;
import com.csb.parser.component.model.SaaSPlanItemInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.parser.component.model.SubscriptionStatus;
import com.csb.platform.controller.ControllerService;

/**
 * Task的Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/v1")
public class SubscriptionController {

	private static Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

	@Autowired
	public ControllerService controllerService;

	@Autowired
	private Validator validator;

	@RequestMapping(value = "/iaas/{id}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
	@ResponseBody
	public PocIaaSInfoTO get(@PathVariable("id") Long id) {
		PocIaaSInfoTO iaas = new PocIaaSInfoTO();
		iaas.setCpus(1);
		iaas.setInstanceName("test1");
		iaas.setImageName("Debian-with-passwd");
		iaas.setMemory("1G");
		iaas.setStorage("10G");
		return iaas;
	}

	@RequestMapping(value = "/iaas/create",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> createIaaS(@RequestBody PocIaaSInfoTO iaas) {
		SubscriptionInfo s = new SubscriptionInfo();

		s.setTraceId("IaaS-00001");
		s.setAppPlanId("iaas-plan-00001");
		s.setCategory("IAAS");

		IaaSInfo iaasInfo = new IaaSInfo();
		iaasInfo.setProvider("openstack");
		iaasInfo.setAction("CREATE");
		// 1
		iaasInfo.setCpus(iaas.getCpus());
		// name
		iaasInfo.setInstanceName(iaas.getInstanceName());
		// 1G
		iaasInfo.setMemory(iaas.getMemory().toLowerCase() + "b");
		// Debian-with-passwd
		iaasInfo.setImageName(iaas.getImageName());
		// 10G
		iaasInfo.setStorage(iaas.getStorage().toLowerCase() + "b");
		// m1.1gb.1cpu.10gb
		iaasInfo.setFlavor("m1." + iaasInfo.getMemory() + "." + iaasInfo.getCpus() + "cpu." + iaasInfo.getStorage());
		s.setIaasInfo(iaasInfo);
		SubscriptionResult result = controllerService.createSubscription(s);

		if (result.getEventId() != null) {
			controllerService.broke(result.getEventId());
		}

		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/iaas/manifest/create",method = RequestMethod.GET)
        @ResponseBody
        public ResponseEntity<?> createManifestIaaS() {
	    try {
	            // Path path =
	            // FileSystems.getDefault().getPath("/Users/yanliang/dev/saas-base-workspace",
	            // "xwiki.xml");

	            // String manifestStr = new String(Files.readAllBytes(path));

	            CordsManifest manifest = null;
	            JAXBContext jc;

	            jc = JAXBContext.newInstance(com.csb.common.manifest.ObjectFactory.class);

	            Unmarshaller unmarshaller = jc.createUnmarshaller();
	           
	            Resource resource = new ClassPathResource("manifest/iaas-manifest.xml");
	            manifest = (CordsManifest) ((JAXBElement<DocumentType>) unmarshaller.unmarshal(resource.getInputStream())).getValue();
	            System.out.println(manifest);
	            CordsNode node = manifest.getNode().get(0);
	            String provider = node.getProvider();
	            CordsImage image = node.getImage();
	            String instanceName = node.getName();
	            CordsInfrastructure infra = node.getInfrastructure();
	            SubscriptionInfo s = new SubscriptionInfo();

	            s.setTraceId("IaaS-00002");
	            s.setAppPlanId("iaas-plan-00002");
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
	                controllerService.broke(result.getEventId());
	            }
	            String returnBody = "{" + "\"success\": \"true\"," + "\"message\": \""+instanceName+ "订购成功\""
	                    + "}";
	            return new ResponseEntity<String>(returnBody,HttpStatus.CREATED);

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	   
        }

	@RequestMapping(value = "/saas/create",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> createSaaS() {
		SubscriptionInfo s = new SubscriptionInfo();
		s.setTraceId("saas-00001");
		s.setAppPlanId("saas-plan-00001");
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
		SubscriptionStatus status = controllerService.getSubscriptionStatus(result.getEventId());
		
		return new ResponseEntity<String>(status.getRaw(),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/saas/manifest/create",method = RequestMethod.GET)
        @ResponseBody
        public ResponseEntity<?> createManifestSaaS() {

	        try {
	            // Path path =
	            // FileSystems.getDefault().getPath("/Users/yanliang/dev/saas-base-workspace",
	            // "xwiki.xml");

	            // String manifestStr = new String(Files.readAllBytes(path));
	            logger.debug("Provision SaaS Manifest Start...");
	            SaasManifest manifest = null;
	            JAXBContext jc;

	            jc = JAXBContext.newInstance(com.csb.common.saas.manifest.ObjectFactory.class);

	            Resource resource = new ClassPathResource("manifest/saas-manifest.xml");
	            Unmarshaller unmarshaller = jc.createUnmarshaller();
	            manifest = (SaasManifest) ((JAXBElement<DocumentType>) unmarshaller.unmarshal(resource.getInputStream())).getValue();
	            
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
	            s.setTraceId("saas-00002");
	            s.setAppPlanId("saas-plan-00002");
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
	           
	            SubscriptionStatus status = controllerService.getSubscriptionStatus(result.getEventId());
	            logger.debug("Provision SaaS Manifest End ...");
	            return new ResponseEntity<String>(status.getRaw(),HttpStatus.CREATED);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
                
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
                
        }

}
