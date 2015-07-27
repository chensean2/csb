package com.csb.platform.provision.iaas.openstack.service;

import java.util.List;
import java.util.Map;

import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.image.Image;
import org.openstack4j.openstack.OSFactory;
import org.springframework.stereotype.Service;

import com.csb.core.platform.entity.IaaSPlan;
import com.csb.core.platform.entity.Plan;
import com.csb.platform.provision.iaas.service.IaaSProvisionService;

@Service("openstackIaaSProvisionService")
public class OpenstackIaaSProvisionService implements IaaSProvisionService {

	public static void main(String[] args) {
		OSClient os = OSFactory.builder().endpoint("http://os.enocloud.com:5000/v2.0")
				.credentials("jamie.marshall", "aiquahre").tenantName("prologue").authenticate();
		/*
		 * List<? extends User> users = os.identity().users().list(); for (User
		 * user : users) { System.out.println(user.getEmail() + " " +
		 * user.getTenantId()); }
		 */

//		Flavor flavor = os.compute().flavors()
//				.create(Builders.flavor().vcpus(1).disk(10).ram(1048).build());
		Flavor flavor = null;
		List<? extends Flavor> flavors = os.compute().flavors().list();
		for(Flavor xflavor : flavors){
			if("m1.1gb.1cpu.10gb".equals(xflavor.getName())){
				flavor = xflavor;
				break;
			}
		}
		
		//Flavor flavor = os.compute().flavors().list();
		// Create and Boot a new Server (minimal builder options shown in
		// example)
		
		List<? extends Image> images =  os.images().list();
		Image image = null;
		for(Image ximage : images){
			if("Ubuntu 14.04 x86_64".equals(ximage.getName())){
				image = ximage;
				break;
			}
		}
		Server server = os.compute().servers()
				.boot(Builders.server().name("CSBServer-GJ1").flavor(flavor.getId()).image(image.getId()).build());

	}

	@Override
	public Map<String, String> createServer(Plan plan) {

		IaaSPlan iaasPlan = plan.getIaasPlan();
		OSClient os = OSFactory.builder().endpoint("http://os.enocloud.com:5000/v2.0")
				.credentials("jamie.marshall", "aiquahre").tenantName("prologue").authenticate();
		/*
		 * List<? extends User> users = os.identity().users().list(); for (User
		 * user : users) { System.out.println(user.getEmail() + " " +
		 * user.getTenantId()); }
		 */

//		Flavor flavor = os.compute().flavors()
//				.create(Builders.flavor().vcpus(1).disk(10).ram(1048).build());
		Flavor flavor = null;
		List<? extends Flavor> flavors = os.compute().flavors().list();
		for(Flavor xflavor : flavors){
			if(iaasPlan.getFlavor().equals(xflavor.getName())){
				flavor = xflavor;
				break;
			}
		}
		
		//Flavor flavor = os.compute().flavors().list();
		// Create and Boot a new Server (minimal builder options shown in
		// example)
		
		List<? extends Image> images =  os.images().list();
		Image image = null;
		for(Image ximage : images){
			if(iaasPlan.getImageName().equals(ximage.getName())){
				image = ximage;
				break;
			}
		}
		Server server = os.compute().servers()
				.boot(Builders.server().name(iaasPlan.getInstanceName()).flavor(flavor.getId()).image(image.getId()).build());

		return null;
	}

	@Override
	public Map<String, String> cancelServer(String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> assign(String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> unAssign(String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> startServer(String serverId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> stopServer(String serverId) {
		// TODO Auto-generated method stub
		return null;
	}

}
