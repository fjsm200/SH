package com.base;

/**  
* @Description: 用于读取property文件的参数
* @author xiew  
* @date 2013年12月12日 下午9:44:51
* @version V1.0  
*/ 
public class ConfigProperty {
	public static MyPropertyPlaceholderConfigurer properties = ApplicationBeanHolder.getBean("myPropertyPlaceholderConfigurer");
	
	/**
	* @Description: 据key得到value
	* @param key
	* @return
	* @return Object
	* @throws
	* @author xiew
	* @date 2013年12月12日 下午11:13:57
	*/
	public static Object getPropertyValue(String key){
		return properties.getProperty(key);
	}
}
