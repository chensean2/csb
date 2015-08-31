package com.csb.platform.provision.iaas.openstack.service;

import java.util.List;
import java.util.Map;

import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.FloatingIP;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.identity.Tenant;
import org.openstack4j.model.identity.User;
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
				 * List<? extends User> users = os.identity().users().list();
				 * for (User user : users) { System.out.println(user.getEmail()
				 * + " " + user.getTenantId()); }
				 */

		// Flavor flavor = os.compute().flavors()
		// .create(Builders.flavor().vcpus(1).disk(10).ram(1048).build());
		/*
		 * Flavor flavor = null; List<? extends Flavor> flavors =
		 * os.compute().flavors().list(); for(Flavor xflavor : flavors){
		 * if("m1.1gb.1cpu.10gb".equals(xflavor.getName())){ flavor = xflavor;
		 * break; } }
		 * 
		 * 
		 * List<? extends Image> images = os.images().list(); Image image =
		 * null; for(Image ximage : images){ if("Ubuntu 14.04 x86_64"
		 * .equals(ximage.getName())){ image = ximage; break; } } Server server
		 * = os.compute().servers()
		 * .boot(Builders.server().name("CSBServer-GJ1").flavor(flavor.getId()).
		 * image(image.getId()).build());
		 */
		Tenant tenant = os.identity().tenants().create(Builders.tenant().name("MyNewTenant").build());

		User user = os.identity().users()
				.create(Builders.user().name("testcords").password("Password1").tenant(tenant).build());
		
		List<? extends Server> servers = os.compute().servers().list();
		Server server = null;
		for(Server mserver : servers){
			if(mserver.getName().equals("test1")){
				server = mserver;
			}
		}

		List ips = os.compute().floatingIps().list();
		/*[NovaFloatingIP{id=808, floatingIpAddress=46.231.128.46, pool=nova, 
		}, NovaFloatingIP{id=814, floatingIpAddress=46.231.128.52, pool=nova, 
		}, NovaFloatingIP{id=864, floatingIpAddress=46.231.128.102, pool=nova, 
		}, NovaFloatingIP{id=867, floatingIpAddress=46.231.128.105, pool=nova, 
		}, NovaFloatingIP{id=888, floatingIpAddress=46.231.128.126, pool=nova, 
		}, NovaFloatingIP{id=890, floatingIpAddress=46.231.128.128, pool=nova, 
		}, NovaFloatingIP{id=892, floatingIpAddress=46.231.128.130, pool=nova, 
		}, NovaFloatingIP{id=926, floatingIpAddress=46.231.128.164, pool=nova, 
		}, NovaFloatingIP{id=990, instanceId=d8858a9b-6303-435c-8c9b-49aeb4de1d87, floatingIpAddress=46.231.128.228, fixedIpAddress=10.43.36.23, pool=nova, 
		}, NovaFloatingIP{id=991, floatingIpAddress=46.231.128.229, pool=nova, 
		}, NovaFloatingIP{id=997, floatingIpAddress=46.231.128.235, pool=nova, 
		}, NovaFloatingIP{id=999, floatingIpAddress=46.231.128.237, pool=nova, 
		}, NovaFloatingIP{id=1002, floatingIpAddress=46.231.128.240, pool=nova, 
		}, NovaFloatingIP{id=1049, floatingIpAddress=94.143.114.161, pool=nova, 
		}, NovaFloatingIP{id=1058, floatingIpAddress=94.143.114.170, pool=nova, 
		}, NovaFloatingIP{id=1063, floatingIpAddress=94.143.114.175, pool=nova, 
		}, NovaFloatingIP{id=1134, floatingIpAddress=46.231.128.169, pool=nova, 
		}, NovaFloatingIP{id=1135, floatingIpAddress=46.231.128.170, pool=nova, 
		}, NovaFloatingIP{id=1147, floatingIpAddress=46.231.128.65, pool=nova, 
		}, NovaFloatingIP{id=1160, floatingIpAddress=46.231.128.70, pool=nova, 
		}]*/
		//ActionResponse r = os.compute().floatingIps().addFloatingIP(server,  "46.231.128.52");
		System.out.println("Success");
		
	}

	@Override
	public Map<String, String> createServer(Plan plan) {

		IaaSPlan iaasPlan = plan.getIaasPlan();
		OSClient os = OSFactory.builder().endpoint("http://os.enocloud.com:5000/v2.0")
				.credentials("jamie.marshall", "aiquahre").tenantName("prologue").authenticate();
				/*
				 * List<? extends User> users = os.identity().users().list();
				 * for (User user : users) { System.out.println(user.getEmail()
				 * + " " + user.getTenantId()); }
				 */

		// Flavor flavor = os.compute().flavors()
		// .create(Builders.flavor().vcpus(1).disk(10).ram(1048).build());
		Flavor flavor = null;
		List<? extends Flavor> flavors = os.compute().flavors().list();
		for (Flavor xflavor : flavors) {
			if (iaasPlan.getFlavor().equals(xflavor.getName())) {
				flavor = xflavor;
				break;
			}
		}

		// Flavor flavor = os.compute().flavors().list();
		// Create and Boot a new Server (minimal builder options shown in
		// example)

		List<? extends Image> images = os.images().list();
		Image image = null;
		for (Image ximage : images) {
			if (iaasPlan.getImageName().equals(ximage.getName())) {
				image = ximage;
				break;
			}
		}
		Server server = os.compute().servers().boot(
				Builders.server().name(iaasPlan.getInstanceName()).flavor(flavor.getId()).image(image.getId()).keypairName("gjtest1").addSecurityGroup("default").addAdminPass("nosupportnow").build());

//		FloatingIP ip = null;
//		List<? extends FloatingIP> ips = os.compute().floatingIps().list();
//		for(FloatingIP mIP : ips){
//			if(mIP.getInstanceId() == null){
//				ip=mIP;
//			}
//		}
//		int tryCount = 20;
//		while(!os.compute().servers().get(server.getId()).getVmState().equals("active")){
//			if(tryCount-- ==0){
//				break;
//			}
//			try {
//				Thread.sleep(10*1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				break;
//			}
//		}
		//ActionResponse r = os.compute().floatingIps().addFloatingIP(server,  ip.getFloatingIpAddress());
		//System.out.println(r.getCode());
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
