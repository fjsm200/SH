package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RightFilter implements Filter {
	private boolean ignore = false;


	@Override
	public void doFilter(ServletRequest  request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("进入过滤器RightFilter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//获得url中具体的参数值
		String ignoreStr2 = req.getParameter("src_order_no");
		System.out.println("ignoreStr2:"+ignoreStr2);
		//获得项目根路径
		String path = req.getContextPath();
		//获得url的参数
		System.out.println(req.getQueryString());
		//获得不带参数的url
		String url = req.getRequestURI();
		url = url.substring(url.indexOf(path)+path.length(), url.length());
		System.out.println("url:"+url);
		//继续执行request
		chain.doFilter(req,res);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String ignoreStr = filterConfig.getInitParameter("ignore");
		
		if(ignoreStr.endsWith("true")){
			ignore = true;
		}

	}
	@Override
	public void destroy() {
		ignore = false;

	}

}
