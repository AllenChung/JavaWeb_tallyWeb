package com.allen.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.factory.DAOFactory;
import com.allen.vo.User;

public class DeleteItemServlet extends HttpServlet {

	private static final long serialVersionUID = -7316473128900302573L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			if (!(DAOFactory.getItemDAOInstance().exist(id))) {
				req.setAttribute("deleteMessage", "ÊäÈë´íÎó");

			} else if (DAOFactory.getItemDAOInstance().doDelete(Integer.parseInt(req.getParameter("id"))))
				req.setAttribute("deleteMessage", "É¾³ý³É¹¦");

			else
				req.setAttribute("deleteMessage", "É¾³ýÊ§°Ü");

			req.setAttribute("items",
					DAOFactory.getItemDAOInstance().findAll(((User) req.getSession().getAttribute("user")).getId()));
			req.getRequestDispatcher("/Delete.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
