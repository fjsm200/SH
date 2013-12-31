package com.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**  
* @Description: 根据bean的名称获取相应的bean对象
* @author xiew  
* @date 2013年12月12日 下午11:13:16
* @version V1.0  
*/ 
@Component
public class ApplicationBeanHolder implements ApplicationContextAware {
	public static ApplicationContext ac;
	

	//实现ApplicationContextAware接口，会自动调用该setApplicationContext方法。
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ApplicationBeanHolder.ac = context;
	}
	
	public ApplicationContext getApplicationContext(){
		return ac;
	}
	
	//从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型
	public static <T> T getBean(String beanName){
		if( ac != null){
			return (T) ac.getBean(beanName);
		}else{
			return null;
		}
	}
	
	
}
