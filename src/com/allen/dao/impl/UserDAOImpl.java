package com.allen.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.allen.dao.UserDAO;
import com.allen.vo.User;

public class UserDAOImpl implements UserDAO {
	private Connection connection;

	public UserDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flag = false;
		String sql = "insert into user(userName, password) values (?, ?)";
		try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getPassword());
			if (prepareStatement.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean exist(String userName, String password) throws Exception {
		boolean flag = false;
		String sql = "select userName, password from user where userName=? and password=?";
		try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
			prepareStatement.setString(1, userName);
			prepareStatement.setString(2, password);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next())
				flag = true;
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	@Override
	public boolean exist(String userName) throws Exception {
		boolean flag = false;
		String sql = "select userName, password from user where userName=?";
		try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
			prepareStatement.setString(1, userName);
			ResultSet resultSet = prepareStatement.executeQuery();
			if (resultSet.next())
				flag = true;
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
}
