package com.allen.dao;

import com.allen.vo.User;

public interface UserDAO {
	
	public boolean doCreate(User user) throws Exception;
	
	public boolean exist(String userName, String password) throws Exception;
	
	public boolean exist(String userName) throws Exception;
	
	public int findId(User user) throws Exception;
}
