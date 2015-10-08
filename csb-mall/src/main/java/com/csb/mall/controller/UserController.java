package com.csb.mall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csb.common.constant.DevelopConstant;
import com.csb.common.constant.PlatformConstant;
import com.csb.core.model.User;
import com.csb.core.service.RoleService;
import com.csb.core.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
        private RoleService roleService;
	    
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> register() {
	    //TODO remove later after , now default user as Active first
	    //Prepare user
	    User user = new User();
	    StandardPasswordEncoder passwordEncoder = new StandardPasswordEncoder();
	    user.setEmail(DevelopConstant.USER_EMAIL);
	    user.setPassword(passwordEncoder.encode(DevelopConstant.USER_PASSWORD));
	    user.setMobilenumber(DevelopConstant.USER_MOBILE);
	    user.setAccountstatus(PlatformConstant.ACCOUNT_STATUS_ACTIVE);
	    user.setUserType(PlatformConstant.USER_TYPE_PROVIDER);
	    
	    userService.register(user);
	    
	    s = userService.findByUniqueKey(s);
	    return new ResponseEntity(s,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/active", method = RequestMethod.GET)
        @ResponseBody
        public ResponseEntity<?> active(@RequestBody User user) {
                return null;
        }

}
