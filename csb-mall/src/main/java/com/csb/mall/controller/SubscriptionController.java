package com.csb.mall.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csb.common.constant.MediaTypes;
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

	@RequestMapping(value = "/iaas/create}",method = RequestMethod.POST, consumes = MediaTypes.JSON)
	@ResponseBody
	public ResponseEntity<?> createIaaS(@RequestBody PocIaaSInfoTO iaas) {
		SubscriptionInfo s = new SubscriptionInfo();

		s.setTraceId("00001");
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

	@RequestMapping(value = "/saas/create",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> createSaaS() {
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
		
		return new ResponseEntity<String>(result.getEventId(),HttpStatus.CREATED);
	}

}
