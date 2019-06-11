package com.identicum.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DefaultController {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @GetMapping({"/", "/home"})
    public String home() {
        return "/home";
    }

    @GetMapping("/user")
    public String user(Model model, OAuth2Authentication auth ) {
    	
    	try {
    		logger.debug("Auth recibido: " + new ObjectMapper().writeValueAsString(auth));
    	} catch(JsonProcessingException jpe) {
    		logger.error("Error found: " + jpe.getMessage());
    	}
    	@SuppressWarnings("unchecked")
		Map<String, Object> details = (HashMap<String, Object>) auth.getUserAuthentication().getDetails();
    	model.addAttribute("sub", details.get("sub").toString());
    	model.addAttribute("userInfoMap", details);
    	model.addAttribute("name", auth.getName());
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

}
