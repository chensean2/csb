package com.csb.mall.controller;

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
import com.csb.core.rest.to.PocIaaSInfoTO;
import com.csb.parser.component.model.IaaSInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.platform.controller.ControllerService;

/**
 * Task的Restful API的Controller.
 * 
 */
@Controller
@RequestMapping(value = "/api/v1/iaas/provision")
public class IaaSSubscriptionController {

	private static Logger logger = LoggerFactory.getLogger(IaaSSubscriptionController.class);
	
	@Autowired
	public ControllerService controllerService;
	
	@Autowired
	private Validator validator;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaTypes.JSON_UTF_8)
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
	@RequestMapping(method = RequestMethod.POST, consumes = MediaTypes.JSON)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody PocIaaSInfoTO iaas) {
		SubscriptionInfo s = new SubscriptionInfo();

		s.setTraceId("00001");
		s.setAppPlanId("iaas-plan-00001");
		s.setCategory("IAAS");

		IaaSInfo iaasInfo = new IaaSInfo();
		iaasInfo.setProvider("openstack");
		iaasInfo.setAction("CREATE");
		//1
		iaasInfo.setCpus(iaas.getCpus());
		//name
		iaasInfo.setInstanceName(iaas.getInstanceName());
		//1G
		iaasInfo.setMemory(iaas.getMemory().toLowerCase() + "b");
		//Debian-with-passwd
		iaasInfo.setImageName(iaas.getImageName());
		//10G
		iaasInfo.setStorage(iaas.getStorage().toLowerCase() + "b");
		// m1.1gb.1cpu.10gb
		iaasInfo.setFlavor(
				"m1." + iaasInfo.getMemory() + "." + iaasInfo.getCpus() + "cpu." + iaasInfo.getStorage());
		s.setIaasInfo(iaasInfo);
		SubscriptionResult result = controllerService.createSubscription(s);

		if (result.getEventId() != null) {
			controllerService.broke(result.getEventId());
		}

		return new ResponseEntity( HttpStatus.CREATED);
	}

	
}
