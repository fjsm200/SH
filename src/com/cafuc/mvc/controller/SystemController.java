package com.cafuc.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cafuc.mvc.domain.People;
import com.cafuc.mvc.manager.PeopleManagerImpl;
import com.seeyon.v3x.utils.UUIDLong;

public class SystemController  implements Controller{
	private static final Log log = LogFactory.getLog(SystemController.class);
	private PeopleManagerImpl peopleManagerImpl;
	
	
	public void setPeopleManagerImpl(PeopleManagerImpl peopleManagerImpl) {
		this.peopleManagerImpl = peopleManagerImpl;
	}

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
	
	public ModelAndView testSave(HttpServletRequest arg0,HttpServletResponse arg1) throws Exception {
		ModelAndView modelAndView = new ModelAndView("first");
		 log.info("进入testSave方法..");
		 People people = new People();  
         people.setId(UUIDLong.getLong());
         people.setName("张四");  
         people.setPassword("1234");
         peopleManagerImpl.savePeople(people);
         log.info("保存成功");
         return modelAndView;
	}
	
}
