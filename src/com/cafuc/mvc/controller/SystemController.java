package com.cafuc.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SystemController  implements Controller{
	private static final Log log = LogFactory.getLog(SystemController.class);
	
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("first");
		System.out.println("index");
		log.info("index");
		modelAndView.addObject("type", "success");
    	return modelAndView ;
	}

	public ModelAndView handleRequest(HttpServletRequest arg0,HttpServletResponse arg1) throws Exception {
		ModelAndView modelAndView = new ModelAndView("first");
		System.out.println("handleRequest");
		log.info("handleRequest");
		modelAndView.addObject("type", "success");
    	return modelAndView ;
	}
}
