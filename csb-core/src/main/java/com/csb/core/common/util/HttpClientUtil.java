package com.csb.core.common.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

public class HttpClientUtil {
    
    public static Map<String, String> getUrlParameters(String query) throws UnsupportedEncodingException {
		Map<String, String> params = new HashMap<String, String>();
		for (String param : query.split("&")) {
			String pair[] = param.split("=", 2);
			String key = URLDecoder.decode(pair[0], "UTF-8");
			String value = URLDecoder.decode(pair[1], "UTF-8");
			params.put(key, value);
		}
		return params;
	}
    
    public static Map<String, String> queryAndGetReturnParameter(String url) throws IOException {
    	HttpContext context = new BasicHttpContext();
    	DefaultHttpClient  httpclient = new DefaultHttpClient();
    	HttpGet httpGet = new HttpGet(url);
    	httpclient.execute(httpGet, context);
    	HttpUriRequest currentReq = (HttpUriRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
    	Map<String, String> paramMap = getUrlParameters(currentReq.getURI().getRawQuery());
		return paramMap;
    }
}
