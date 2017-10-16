package com.visual.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TomcatFormFilter implements Filter{

	/**
	* Request.java
	* �� HttpServletRequestWrapper ��������, ��Ӱ��ԭ���Ĺ��ܲ����ṩ��
	�е�HttpServletRequest
	* �ӿ��еĹ���. ������ͳһ�Ķ� Tomcat Ĭ�������µ�����������н����ֻ
	��Ҫ���µ�Request �����滻ҳ���е�
	* request ���󼴿�.
	*/
	
	class Request extends HttpServletRequestWrapper{

		public Request(HttpServletRequest request) {
			super(request);
			// TODO Auto-generated constructor stub
		}
		
		/**
		* ת���ɱ���ȡ�����ݵ�����.
		* �� ISO �ַ�ת�� UTF-8.
		*/
		public String toChi(String input) {
		try {
		byte[] bytes = input.getBytes("ISO8859-1");
//		return new String(bytes, "GBK");
		return new String(bytes, "UTF-8");
		}
		catch (Exception ex) {
		}
		return null;
		}
		/**
		* Return the HttpServletRequest holded by this object.
		*/
		private HttpServletRequest getHttpServletRequest()
		{
		return (HttpServletRequest)super.getRequest();
		}
		/**
		* ��ȡ���� -- ��������������.
		*/
		public String getParameter(String name)
		{
		return
		toChi(getHttpServletRequest().getParameter(name));
		}
		/**
		* ��ȡ�����б�- ��������������.
		*/
		public String[] getParameterValues(String name)
		{
		String values[] =
		getHttpServletRequest().getParameterValues(name);
		if (values != null) {
		for (int i = 0; i < values.length; i++) {
		values[i] = toChi(values[i]);
		}
		}
		return values;
		}
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpreq = (HttpServletRequest) request;  

		if(httpreq.getMethod().equals("POST")) {
	//		request.setCharacterEncoding("GBK");
			request.setCharacterEncoding("UTF-8");
		} else {
			request = new Request(httpreq);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
