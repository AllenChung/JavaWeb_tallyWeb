package com.allen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.pojo.Register;
import com.allen.vo.User;

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		User user = new User();
		user.setUserName(req.getParameter("userName"));
		user.setPassword(req.getParameter("password"));
		Register register = new Register(user);
		try {
			if (register.doCreate())
				req.getRequestDispatcher("/Index.jsp").forward(req, resp);
			else  {
				req.setAttribute("errors", register.getErrors());
				req.getRequestDispatcher("/Register.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
