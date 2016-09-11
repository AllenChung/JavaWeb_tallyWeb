package com.allen.dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/tally";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private Connection connection;
	
	public DatabaseConnection() throws Exception {
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void close() throws Exception {
		try {
			connection.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
