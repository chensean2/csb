package com.csb.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.csb.parser.component.model.IaaSInfo;
import com.csb.parser.component.model.SubscriptionInfo;
import com.csb.parser.component.model.SubscriptionResult;
import com.csb.platform.broker.component.service.BrokerService;
import com.csb.platform.controller.ControllerService;

@ContextConfiguration(locations = { "classpath:app-test-context-platform-controller.xml" })
public class PlatformControllerTest extends BaseIT {

	@Autowired
	public ControllerService controllerService;

	@Autowired
	private BrokerService csbBrokerService;

	@Test
	public void testAppPackage() {
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
		iaasInfo.setFlavor(
				"m1." + iaasInfo.getMemory() + "gb." + iaasInfo.getCpus() + "cpu." + iaasInfo.getStorage() + "gb");
		s.setIaasInfo(iaasInfo);
		SubscriptionResult result = controllerService.createSubscription(s);

		if(result.getEventId() != null){
			csbBrokerService.broke(result.getEventId());
		}
	}

}
