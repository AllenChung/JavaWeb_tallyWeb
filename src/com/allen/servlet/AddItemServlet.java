package com.allen.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.allen.factory.DAOFactory;
import com.allen.vo.Item;
import com.allen.vo.User;

public class AddItemServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Item item = new Item();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			item.setDate(new Date(format.parse(req.getParameter("date")).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		item.setLocation(req.getParameter("location"));
		item.setDetail(req.getParameter("detail"));
		item.setAmount(Double.parseDouble(req.getParameter("amount")));
		item.setUser_id(((User)req.getSession().getAttribute("user")).getId());
		try {
			if (DAOFactory.getItemDAOInstance().doAdd(item)) {
				req.setAttribute("result", "记账成功");
			} else {
				req.setAttribute("result", "记账失败");
			}
			req.getRequestDispatcher("/add.jsp").forward(req, resp);;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
