package com.seeyon.v3x.utils;

import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;


public class ResourceLoadUtils {
	public static final String CLASSPATH_PREFIX =  "classpath*:";
	
	/**
	 * @param servletContext
	 * @param location
	 * @return
	 * @description 从WEB-INF下加载   /WEB-INF/conf/***.properties
	 * @version 1.0
	 * @author xiew
	 * @update 2013-7-24 上午10:02:00
	 */
	public static InputStream getFromServletContext(ServletContext servletContext,
			String location) {
		if(Strings.isBlank(location)){
			return null;
		}
		
		if (!location.startsWith("/")) {
			location = "/" + location;
		}
				
		return servletContext.getResourceAsStream(location);
	}
	/**
	 * @param location
	 * @return
	 * @description 从classpath下加载文件
	 * @version 1.0
	 * @author xiew
	 * @update 2013-7-24 上午10:02:19
	 */
	public static InputStream getFromClasspath(String location) {
		if(Strings.isBlank(location)){
			return null;
		}
		
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(location);
	}
	
	/**
	 * @param servletContext
	 * @param location
	 * @return
	 * @description 加载配置文件
	 * @version 1.0
	 * @author xiew
	 * @update 2013-7-24 上午10:26:58
	 */
	public static InputStream get(ServletContext servletContext, String location){
		if(Strings.isBlank(location)){
			return null;
		}
		
		if(location.startsWith(CLASSPATH_PREFIX)){
			return getFromClasspath(StringUtils.substringAfter(location, CLASSPATH_PREFIX));
		}
		else{
			return getFromServletContext(servletContext, location);
		}
	}
}
	
