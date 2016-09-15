package com.allen.dao.proxy;

import com.allen.dao.ItemDAO;
import com.allen.dao.impl.ItemDAOImpl;
import com.allen.dbc.DatabaseConnection;
import com.allen.vo.Item;

public class ItemDAOProxy implements ItemDAO {
	private DatabaseConnection dbc;
	private ItemDAO dao;
	
	public ItemDAOProxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new ItemDAOImpl(dbc.getConnection());
	}
	
	@Override
	public boolean doAdd(Item item) throws Exception {
		boolean flag = false;
		try {
			flag = dao.doAdd(item);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
		return flag;
	}

}
