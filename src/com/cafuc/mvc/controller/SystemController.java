package com.cafuc.mvc.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.cafuc.mvc.domain.People;
import com.cafuc.mvc.manager.PeopleManagerImpl;

public class SystemController extends MultiActionController{
	private static final Log log = LogFactory.getLog(SystemController.class);
	private PeopleManagerImpl peopleManagerImpl;

	public void setPeopleManagerImpl(PeopleManagerImpl peopleManagerImpl) {
		this.peopleManagerImpl = peopleManagerImpl;
	}

	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("first");
		System.out.println("my-index");
		log.info("index");
		modelAndView.addObject("type", "success");
    	return modelAndView ;
	}

	public ModelAndView testSave(HttpServletRequest arg0,HttpServletResponse arg1) throws Exception {
		ModelAndView modelAndView = new ModelAndView("first");
		 log.info("进入testSave方法..");
		 People people = new People();  
         //people.setId(UUIDLong.getLong());
         people.setName("张四");  
         people.setPassword("1234");
         peopleManagerImpl.savePeople(people);
         log.info("保存成功");
         return modelAndView;
	}
	
	/**
	 * 文件上传工功能展示页
	 * @param arg0
	 * @param arg1
	 * @return
	 * @throws Exception
	 */
	public ModelAndView showFileUpAndDown(HttpServletRequest arg0,HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView("fileoper/showFileUpAndDown");
		return mav;
	
	}

	
	/**
	 * 文件上传
	 * @param req
	 * @param repose
	 * @return
	 * @throws Exception
	 */
	public ModelAndView upLoaderFile(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView("/sucess");
		
		return mav;
	}
	
	/**
	 * 文件下载
	 * @param req
	 * @param repose
	 * @return
	 * @throws Exception
	 */
	public ModelAndView downLoaderFile(HttpServletRequest req,HttpServletResponse repose) throws Exception{
		ModelAndView mav = new ModelAndView("/sucess");
		System.out.println("downLoaderFile...");
		return mav;
	}
	
	
	
}
