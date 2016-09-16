package com.allen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.factory.DAOFactory;
import com.allen.vo.User;

public class CheckServlet extends HttpServlet {

	private static final long serialVersionUID = -3656084028539199563L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("items", DAOFactory.getItemDAOInstance().findAll(((User)req.getSession().getAttribute("user")).getId()));
			req.getRequestDispatcher("/check.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
