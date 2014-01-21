package com.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.util.UrlPathHelper;

public class BaseController extends MultiActionController {
	private static final Log log = LogFactory.getLog(BaseController.class);

	protected ModelAndView handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String methodStr = request.getParameter("Method");
		log.info(methodStr + " :找不到该方法！");
		return super.handleNoSuchRequestHandlingMethod(ex, request, response);
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//从request中获取Method参数方法
		String methodStr = request.getParameter("method");
		//从request中获取url参数路径
		String urlPath = new UrlPathHelper().getLookupPathForRequest(request);
		
		//获得多动作策略对象
		SimpleUrlHandlerMapping sum = ApplicationBeanHolder.getBean("urlMapping");
		Object obClass;
		if(sum != null){
			obClass =  sum.getHandlerMap().get(urlPath);
			
			if(obClass != null){
				//判定方法是否是符合
				Method[] methods = obClass.getClass().getMethods();
				
				for(Method method : methods){
				   if(method.getName().equals(methodStr) && isHandlerMethod(method)){
		               //组装参数
		               List<Object> params = new ArrayList<Object>(2);
		               params.add(request);
		               params.add(response);
		               //执行方法
		               Object returnValue = method.invoke(obClass.getClass().newInstance(), params.toArray(new Object[params.size()]));
		                    
		               //返回对象ModelAndView
		               return massageReturnValueIfNecessary(returnValue);
				   }
	            }
			}
		}
		log.info(methodStr + " :找不到该方法！");
		return null;
	}

	private ModelAndView massageReturnValueIfNecessary(Object returnValue) {
		if (returnValue instanceof ModelAndView) {
			return (ModelAndView) returnValue;
		} else if (returnValue instanceof Map) {
			return new ModelAndView().addAllObjects((Map) returnValue);
		} else if (returnValue instanceof String) {
			return new ModelAndView((String) returnValue);
		} else {
			return null;
		}
	}
	
	/**
	* @Description: 判定方法是否是符合规范的
	* @param method
	* @return
	* @return boolean
	* @throws
	* @author xiew
	* @date 2013年12月31日 下午10:39:36
	*/
	private boolean isHandlerMethod(Method method) {
        Class returnType = method.getReturnType();
        if (ModelAndView.class.equals(returnType) || Map.class.equals(returnType) || String.class.equals(returnType) ||
                        void.class.equals(returnType)) {
                Class[] parameterTypes = method.getParameterTypes();
                return (parameterTypes.length >= 2 &&
                                HttpServletRequest.class.equals(parameterTypes[0]) &&
                                HttpServletResponse.class.equals(parameterTypes[1]) &&
                                !("handleRequest".equals(method.getName()) && parameterTypes.length == 2));
        }
        return false;
}

}
