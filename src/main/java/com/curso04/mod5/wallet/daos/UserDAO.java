package com.curso04.mod5.wallet.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.curso04.mod5.wallet.dbconnection.MysqlConnectionClass;
import com.curso04.mod5.wallet.model.User;

public class UserDAO {
	
	private Connection connection;

	public UserDAO() throws SQLException {
		try {
			connection = MysqlConnectionClass.getInstance().getConnection();
			//MysqlConnectionClass mysqlConnectionClass = MysqlConnectionClass.getInstance();
			//connection = mysqlConnectionClass.getConnection();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean userValidation(User user) {
		String sql_statement = "SELECT * FROM Users WHERE user=? AND password =?";
		try(PreparedStatement statement = connection.prepareStatement(sql_statement)){
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			try(ResultSet result = statement.executeQuery()){
				return result.next();
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
