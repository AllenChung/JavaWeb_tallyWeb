package com.allen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.factory.DAOFactory;
import com.allen.vo.User;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 7283700532242964678L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			User user = new User();
			user.setPassword(req.getParameter("password"));
			user.setUserName(req.getParameter("userName"));
			if (DAOFactory.getUserDAOInstance().exist(user.getUserName(), user.getPassword())) {
				user.setId(DAOFactory.getUserDAOInstance().findId(user));
				req.getSession().setAttribute("user", user);
				req.getRequestDispatcher("/catalog.jsp").forward(req, resp);
			} else {
				req.setAttribute("errorMessage", "用户名或密码错误");
				req.getRequestDispatcher("/Index.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
