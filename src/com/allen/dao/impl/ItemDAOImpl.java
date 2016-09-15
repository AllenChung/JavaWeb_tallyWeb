package com.allen.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.allen.dao.ItemDAO;
import com.allen.vo.Item;

public class ItemDAOImpl implements ItemDAO {
	private Connection connection;

	public ItemDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public boolean doAdd(Item item) throws Exception {
		boolean flag = false;
		String sql = "insert into item(date, location, detail, amount, user_id) values (?, ?, ?, ?, ?)";
		try (PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setDate(1, new Date(item.getDate().getTime()));
			preparedstatement.setString(2, item.getLocation());
			preparedstatement.setString(3, item.getDetail());
			preparedstatement.setDouble(4, item.getAmount());
			preparedstatement.setInt(5, item.getUser_id());
			if (preparedstatement.executeUpdate() > 0) 
				flag = true;
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
