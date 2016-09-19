package com.allen.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.allen.dao.ItemDAO;
import com.allen.pojo.showItem;
import com.allen.vo.Item;

public class ItemDAOImpl implements ItemDAO {
	private Connection connection;

	public ItemDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean doAdd(Item item) throws Exception {
		String sql = "insert into item(date, location, detail, amount, user_id) values (?, ?, ?, ?, ?)";
		try (PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setDate(1, new Date(item.getDate().getTime()));
			preparedstatement.setString(2, item.getLocation());
			preparedstatement.setString(3, item.getDetail());
			preparedstatement.setDouble(4, item.getAmount());
			preparedstatement.setInt(5, item.getUser_id());
			if (preparedstatement.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			throw e;
		}
		return false;
	}

	@Override
	public List<showItem> findAll(int user_id) throws Exception {
		List<showItem> all = new ArrayList<>();
		String sql = "select date as date, location as location, detail as detail, amount as amount, id as id from item where user_id=? order by date desc";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			preparedStatement.setInt(1, user_id);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				showItem item = new showItem();
				item.setDate(result.getString(1));
				item.setLocation(result.getString(2));
				item.setDetail(result.getString(3));
				item.setAmount(result.getString(4));
				item.setId(result.getString(5));
				all.add(item);
			}
			return all;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean doDelete(int id) throws Exception {
		String sql = "delete from item where id=?";
		try (PreparedStatement preparedstatement = connection.prepareStatement(sql)) {
			preparedstatement.setInt(1, id);
			if (preparedstatement.executeUpdate() > 0)
				return true;
		} catch (Exception e) {
			throw e;
		}
		return false;
	}
	
	@Override
	public boolean exist(int id) throws Exception {
		String sql = "select * from item where id=?";
		try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
			prepareStatement.setInt(1, id);
			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			throw e;
		}
	}

}
