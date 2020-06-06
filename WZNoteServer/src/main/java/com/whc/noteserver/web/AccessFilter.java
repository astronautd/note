package com.whc.noteserver.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		System.out.println(path);
		if (path.endsWith("login.html") || path.endsWith("register.html")) {
			chain.doFilter(request, response);
			return;
		}
		HttpSession session = req.getSession();
		Object id = session.getAttribute("id");
		if (id == null) {
			// System.out.println("用户没有登录");
			String contextPath = req.getContextPath();
			// System.out.println("contextPath:"+contextPath);
			res.sendRedirect(contextPath + "/login.html");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
