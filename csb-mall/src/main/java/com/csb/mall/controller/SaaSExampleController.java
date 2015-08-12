package com.csb.mall.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/example")
public class SaaSExampleController {

	private static Logger logger = LoggerFactory.getLogger(SaaSExampleController.class);


	@RequestMapping(value = "/provision", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> post(@RequestParam("url") String url) {
		
		String eventURL = url;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpPost = new HttpGet(eventURL);

			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
			    if (entity != null) {
			    	logger.debug(EntityUtils.toString(entity));
			    }
			} finally {
				response.close();
			}
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			try {
				httpclient.close();
			} catch (Exception e) {
				logger.error("", e);
			}
		}
		
		String returnBody = "{" + "\"success\": \"true\"," + "\"message\": \"SaaS ERP订购成功\","
				+ "\"accountId\": \"saas-erp-11111111111\"" + "}";

		return new ResponseEntity<String>(returnBody,HttpStatus.OK);
	}

}
