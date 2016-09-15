package com.allen.factory;

import com.allen.dao.ItemDAO;
import com.allen.dao.UserDAO;
import com.allen.dao.proxy.ItemDAOProxy;
import com.allen.dao.proxy.UserDAOProxy;

public class DAOFactory {
	public static UserDAO getUserDAOInstance() throws Exception {
		return new UserDAOProxy();
	}
	
	public static ItemDAO getItemDAOInstance() throws Exception {
		return new ItemDAOProxy();
	}
}
