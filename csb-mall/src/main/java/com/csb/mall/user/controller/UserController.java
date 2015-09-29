package com.csb.mall.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csb.core.entity.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody User user) {
		return null;
	}
	
	@RequestMapping(value = "/active", method = RequestMethod.GET)
        @ResponseBody
        public ResponseEntity<?> active(@RequestBody User user) {
                return null;
        }

}
