package com.csb.platform.provision.saas.service;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csb.common.util.Encodes;
import com.csb.core.platform.entity.Plan;

@Service
public class DefaultSaaSProvisionService implements SaaSProvisionService {

	private static Logger logger = LoggerFactory.getLogger(DefaultSaaSProvisionService.class);

	@Override
	public Map<String, String> createSubscripiton(Plan plan) {
		String saasURL = "http://localhost:8080/csb-mall/example/provision";
		String eventURL = "http://localhost:8080/csb-mall/api/integration/events/" + plan.getEventId();
		String provisionURL = saasURL+"?url="+eventURL;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(provisionURL);

			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
			    if (entity != null) {
			        long len = entity.getContentLength();
			        if (len != -1 && len < 2048) {
			        	logger.debug(EntityUtils.toString(entity));
			        } else {
			        	logger.debug("Stream content out");
			        }
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

		return null;
	}

	@Override
	public Map<String, String> updateSubscripiton(String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> cancelSubscripiton(String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> notify(String eventId) {
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
	public Map<String, String> validate(String eventId) {
		// TODO Auto-generated method stub
		return null;
	}

}
