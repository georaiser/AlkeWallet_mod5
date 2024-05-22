package com.curso04.mod5.wallet.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.curso04.mod5.wallet.constants.Constants;

/**
 * making a SQL connection with Singleton pattern implementation
 */
public class MysqlConnectionClass {
	
	//make a self instance of MysqlConnectionClass
	private static MysqlConnectionClass instance;
	private Connection connection;
	
	// private constructor for Singleton pattern
	private MysqlConnectionClass() throws SQLException {
		try {
			Class.forName(Constants.DRIVER_MYSQL);
			// mySQL database credentials
			connection = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
		}catch(ClassNotFoundException ex){
			throw new SQLException(ex);
		}
	}
	
	// public method Singleton pattern
	public static MysqlConnectionClass getInstance() throws SQLException {
		if(instance == null) {
			instance = new MysqlConnectionClass();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}

