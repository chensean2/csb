package com.csb.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.w3c.dom.DocumentType;

import com.csb.common.manifest.CordsImage;
import com.csb.common.manifest.CordsInfrastructure;
import com.csb.common.manifest.CordsManifest;
import com.csb.common.manifest.CordsNode;
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
		iaasInfo.setFlavor(
				"m1." + iaasInfo.getMemory() + "gb." + iaasInfo.getCpus() + "cpu." + iaasInfo.getStorage() + "gb");
		s.setIaasInfo(iaasInfo);
		SubscriptionResult result = controllerService.createSubscription(s);

		if (result.getEventId() != null) {
			controllerService.broke(result.getEventId());
		}
	}

	@Test
	public void textManifest() {

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
			manifest = (CordsManifest) ((JAXBElement<DocumentType>) unmarshaller
					.unmarshal(new File("C:\\Users\\gengjun\\Downloads\\xwiki.xml"))).getValue();
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
			iaasInfo.setFlavor(
					"m1." + iaasInfo.getMemory() + "." + iaasInfo.getCpus() + "cpu." + iaasInfo.getStorage());
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

}
