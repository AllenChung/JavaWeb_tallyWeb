package com.allen.pojo;

import java.util.HashMap;
import java.util.Map;

import com.allen.factory.DAOFactory;
import com.allen.vo.User;

public class Register {
	private Map<String, String> errors;
	private User user;
	
	public Register() {}
	
	public Register(User user) {
		this.errors = new HashMap<>();
		this.user = user;
	}
	
	public boolean doCreate() throws Exception {
		if (isValidate()) {
			DAOFactory.getUserDAOInstance().doCreate(user);
			return true;
		} else
			return false;
	}
	
	public boolean isValidate() throws Exception {
		if (DAOFactory.getUserDAOInstance().exist(user.getUserName())) {
			errors.put("errorName", "用户名已存在");
			return false;
		}
		else
			return true;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
}
