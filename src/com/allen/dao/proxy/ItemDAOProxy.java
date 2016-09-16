package com.allen.dao.proxy;

import java.util.List;

import com.allen.dao.ItemDAO;
import com.allen.dao.impl.ItemDAOImpl;
import com.allen.dbc.DatabaseConnection;
import com.allen.pojo.showItem;
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

	@Override
	public List<showItem> findAll(int user_id) throws Exception {
		try {
			return dao.findAll(user_id);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}

}
