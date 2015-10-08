package com.csb.sample.saas.controller;

import java.util.List;

import org.openstack4j.api.Builders;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Flavor;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.image.Image;
import org.openstack4j.openstack.OSFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csb.parser.component.model.IaaSInfo;

@RestController
@EnableAutoConfiguration
public class IaaSController {

    private static Logger logger = LoggerFactory.getLogger(IaaSController.class);

    @RequestMapping(value = "/provision", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ResponseEntity<String> post(@RequestBody IaaSInfo iaas) {

        OSClient os = OSFactory.builder().endpoint("http://os.enocloud.com:5000/v2.0").credentials("jamie.marshall", "aiquahre").tenantName("prologue").authenticate();
        /*
         * List<? extends User> users = os.identity().users().list(); for (User user : users) {
         * System.out.println(user.getEmail() + " " + user.getTenantId()); }
         */

        // Flavor flavor = os.compute().flavors()
        // .create(Builders.flavor().vcpus(1).disk(10).ram(1048).build());
        Flavor flavor = null;
        List<? extends Flavor> flavors = os.compute().flavors().list();
        for (Flavor xflavor : flavors) {
            if (iaas.getFlavor().equals(xflavor.getName())) {
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
            if (iaas.getImageName().equals(ximage.getName())) {
                image = ximage;
                break;
            }
        }
        Server server = os
                .compute()
                .servers()
                .boot(Builders.server().name(iaas.getInstanceName()).flavor(flavor.getId()).image(image.getId()).keypairName("gjtest1").addSecurityGroup("default")
                        .addAdminPass("nosupportnow").build());
        ;
        String serverId = server.getId();
        // FloatingIP ip = null;
        // List<? extends FloatingIP> ips = os.compute().floatingIps().list();
        // for(FloatingIP mIP : ips){
        // if(mIP.getInstanceId() == null){
        // ip=mIP;
        // }
        // }
        // int tryCount = 20;
        // while(!os.compute().servers().get(server.getId()).getVmState().equals("active")){
        // if(tryCount-- ==0){
        // break;
        // }
        // try {
        // Thread.sleep(10*1000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // break;
        // }
        // }
        // ActionResponse r = os.compute().floatingIps().addFloatingIP(server, ip.getFloatingIpAddress());
        // System.out.println(r.getCode());
        String returnBody = "{" + "\"success\": \"true\"," + "\"message\": \"IaaS Order successfully\"," + "\"accountId\": \"" + serverId + "\"" + "}";

        return new ResponseEntity<String>(returnBody, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/get", method = { RequestMethod.GET})
    @ResponseBody
    public ResponseEntity<String> getStatus(@RequestParam("id") String id) {

        OSClient os = OSFactory.builder().endpoint("http://os.enocloud.com:5000/v2.0").credentials("jamie.marshall", "aiquahre").tenantName("prologue").authenticate();
       
        Server server = os
                .compute()
                .servers().get(id);
        String status = server.getStatus().toString();
        
        String returnBody = "{" + "\"success\": \"true\"," + "\"message\": \"successfully\"," + "\"status\": \"" + status + "\"" + "}";

        return new ResponseEntity<String>(returnBody, HttpStatus.OK);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(IaaSController.class, args);
    }

}
