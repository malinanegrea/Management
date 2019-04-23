package com.proj.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	final static Logger logger = Logger.getLogger(MainController.class);
    @GetMapping("/")
    public String root() {
    	logger.info("Entering the root method");
        return "index";
    }
    

}