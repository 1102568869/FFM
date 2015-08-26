package net.longshasha.ffm.weixin.util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;

/**
 * Servlet Filter implementation class ParamFixFilter
 */
public class ParamFixFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ParamFixFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//支持跨域获取数据
		response.setHeader("Access-Control-Allow-Origin", "*");

		System.out.println("------------???");
		System.out.println(" :"+request.getQueryString());
		System.out.println(" :"+request.getRequestURL());
		System.out.println(" :"+request.getRequestURI());
		System.out.println(" :"+request.getRemoteHost());
		System.out.println("------------filter");
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
