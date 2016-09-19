package com.allen.dao.proxy;

import com.allen.dao.UserDAO;
import com.allen.dao.impl.UserDAOImpl;
import com.allen.dbc.DatabaseConnection;
import com.allen.vo.User;

public class UserDAOProxy implements UserDAO {
	private DatabaseConnection dbc;
	private UserDAO dao;

	public UserDAOProxy() throws Exception {
		dbc = new DatabaseConnection();
		dao = new UserDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flag = false;
		try {
			flag = dao.doCreate(user);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
		return flag;
	}

	@Override
	public boolean exist(String userName, String password) throws Exception {
		boolean flag = false;
		try {
			flag = dao.exist(userName, password);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
		return flag;
	}

	@Override
	public boolean exist(String userName) throws Exception {
		boolean flag = false;
		try {
			flag = dao.exist(userName);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
		return flag;
	}

	@Override
	public int findId(User user) throws Exception {
		try {
			return dao.findId(user);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.close();
		}
	}



}
