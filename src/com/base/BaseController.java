package com.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

public class BaseController extends MultiActionController {
	private static final Log log = LogFactory.getLog(BaseController.class);
	
	
	Map<String, Object> urlMap = new HashMap<String, Object>();

	
	public BaseController(){
	}
	
	/**
	* @Description:对多动作器进行重写，无该方法时候，跳转到这边进行处理
	* @param request
	* @param response
	* @return
	* @throws Exception
	* @return ModelAndView
	* @throws
	* @author xiew
	* @date 2013年12月31日 下午8:53:19
	*/
	@Override
	protected ModelAndView handleNoSuchRequestHandlingMethod(NoSuchRequestHandlingMethodException ex,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String methodStr = request.getParameter("method");
		log.info(methodStr + " ：没有找到该方法");
		return super.handleNoSuchRequestHandlingMethod(ex, request, response);
	}

	/**
	* @Description:对多动作器进行重写，是之能进行进行控制跳转
	* @param request
	* @param response
	* @return
	* @throws Exception
	* @return ModelAndView
	* @throws
	* @author xiew
	* @date 2013年12月31日 下午8:53:19
	*/
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//获取request参数中的method方法
		String methodStr = request.getParameter("method");
		//获取request参数url
		String action = request.getRequestURI();
		//获取多动作器策略对象
		SimpleUrlHandlerMapping sum = ApplicationBeanHolder.getBean("urlMapping");
		Object ob ;
		
		if(sum != null){
			ob = sum.getHandlerMap().get("/system.do");
			//获取方法对象
			Method method = ob.getClass().getMethod(methodStr,HttpServletRequest.class,HttpServletResponse.class);
			
			//获得方法对象的参数个数
			Class[] paramTypes = method.getParameterTypes();
            List<Object> params = new ArrayList<Object>(4);
            params.add(request);
            params.add(response);
            
            //如果方法参数超过3个，且第三各是Session参数，则加入SeSSion
            if (paramTypes.length >= 3 && paramTypes[2].equals(HttpSession.class)) {
                 HttpSession session = request.getSession(false);
                 if (session == null) {
                      throw new HttpSessionRequiredException("Pre-existing session required for handler method '" + methodStr + "'");
                 }
                 params.add(session);
            }

            //执行该方法，即跳转到该方法中
            Object returnValue = method.invoke(ob.getClass().newInstance(), params.toArray(new Object[params.size()]));
            return massageReturnValueIfNecessary(returnValue);
		}
		
		return  null;
	}
	
	 /**
	* @Description: 返回必要的值，即跳转页面
	* @param returnValue
	* @return
	* @return ModelAndView
	* @throws
	* @author xiew
	* @date 2013年12月31日 下午8:52:03
	*/
	private ModelAndView massageReturnValueIfNecessary(Object returnValue) {
         if (returnValue instanceof ModelAndView) {
                 return (ModelAndView) returnValue;
         }
         else if (returnValue instanceof Map) {
                 return new ModelAndView().addAllObjects((Map) returnValue);
         }
         else if (returnValue instanceof String) {
                 return new ModelAndView((String) returnValue);
         }
         else {
                 return null;
         }
 }
	
}
