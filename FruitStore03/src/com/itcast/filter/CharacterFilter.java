package com.itcast.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
//@WebFilter("/*")
public class CharacterFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)requ;
		HttpServletResponse response=(HttpServletResponse)resp;
		request.setCharacterEncoding("utf-8");
		System.out.println("filter run ...");
		response.setContentType("text/html;charset=utf-8");
		//对request进行包装
		CharacterRequest characterRequest=new CharacterRequest(request);
		chain.doFilter(characterRequest, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
//统一编码的类
class CharacterRequest extends HttpServletRequestWrapper{
	@SuppressWarnings("unused")
	private HttpServletRequest request;
	public CharacterRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		this.request=request;
	}
	public String getParameter(String name) {
		String value=super.getParameter(name);
		if(value==null)
			return null;
		String method=super.getMethod();
		if("get".equalsIgnoreCase(method)) {
			try {
				value=new String(value.getBytes("iso-8859-1"),"utf-8");
			}
			catch(UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return value;
	}
	
}