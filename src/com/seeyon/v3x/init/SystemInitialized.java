package com.seeyon.v3x.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.seeyon.v3x.common.Log4JConfigurator;

public class SystemInitialized implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	//系统初始化
	public void contextInitialized(ServletContextEvent even) {
		String rootPath = even.getServletContext().getRealPath("");
		System.setProperty("A8ApplicationRoot", rootPath);
		System.setProperty("ApplicationContextPath", "/seeyon");
		
		
		
		//日志系统初始化
		Log4JConfigurator.initialized();
		System.out.println("SystemInitialized---over....");
		
	}

}
