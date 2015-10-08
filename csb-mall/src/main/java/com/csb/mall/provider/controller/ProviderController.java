package com.csb.mall.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

	private static Logger logger = LoggerFactory.getLogger(ProviderController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register() {
		return null;
	}

}
