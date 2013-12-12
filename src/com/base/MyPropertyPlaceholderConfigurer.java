package com.base;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**  
* @Description: 用于读取配置property文件
* @author xiew  
* @date 2013年12月12日 下午10:51:56
* @version V1.0  
*/ 
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	public Properties property;

	/* 
	* @Description: 
	* @param beanFactoryToProcess
	* @param props
	* @throws BeansException
	* @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory, java.util.Properties)
	* @author xiew
	* @date 2013年12月12日 下午10:58:37
	*/
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		this.property = props;
	}

	/**
	* @Description: 根据Key获得property文件相应的值
	* @param key
	* @return
	* @return Object
	* @throws
	* @author xiew
	* @date 2013年12月12日 下午11:00:58
	*/
	public Object getProperty(String key){
		return property.getProperty(key);
	}
}
