package com.hncares.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CodingFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println(11);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		HttpServletRequest request1 = (HttpServletRequest) request;  
//        HttpServletResponse response1 = (HttpServletResponse) response; 
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(11);
	}

}
