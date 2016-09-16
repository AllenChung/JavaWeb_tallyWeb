package com.allen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.factory.DAOFactory;
import com.allen.vo.User;

public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 4333117949536844953L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setAttribute("items", DAOFactory.getItemDAOInstance().findAll(((User)req.getSession().getAttribute("user")).getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("/Delete.jsp").forward(req, resp);
	}

}
