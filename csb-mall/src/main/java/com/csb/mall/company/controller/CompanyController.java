package com.csb.mall.company.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {

	private static Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register() {
		return null;
	}

}