package com.allen.filter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.vo.User;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		User user = (User)((HttpServletRequest)req).getSession().getAttribute("user");
		Path path = Paths.get(((HttpServletRequest)req).getRequestURI());
		if (path.endsWith("Index.jsp") || path.endsWith("Register.jsp") || path.endsWith("Login") || path.endsWith("Register")) {
			filterChain.doFilter(req, resp);
			return;
		}
		if (user == null) {
			((HttpServletResponse)resp).sendRedirect(((HttpServletRequest)req).getContextPath() + "/Index.jsp");
		} else {
			filterChain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
