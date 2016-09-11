package com.allen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.factory.DAOFactory;
import com.allen.vo.User;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			if (DAOFactory.getUserDAOInstance().exist(req.getParameter("userName"), req.getParameter("password")))
				req.getRequestDispatcher("/Missing.jsp").forward(req, resp);
			else {
				req.setAttribute("errorMessage", "用户名或密码错误");
				req.getRequestDispatcher("/Index.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
