package com.curso04.mod5.wallet.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.curso04.mod5.wallet.dbconnection.MysqlConnectionClass;
import com.curso04.mod5.wallet.model.Customer;

public class CustomerDAO {

	private Connection connection;

	public CustomerDAO() {
		try {
			connection = MysqlConnectionClass.getInstance().getConnection();
			// MysqlConnectionClass mysqlConnectionClass =
			// MysqlConnectionClass.getInstance();
			// connection = mysqlConnectionClass.getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// create a customer in DataBase
	public boolean customertInsert(Customer customer) {
		// Customer ---> dataBase table
		String sql_statement = "INSERT INTO Customer (name, accountNumber) VALUE (?,?)";

		try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			// account parameters
			statement.setString(1, customer.getName());
			statement.setInt(2, customer.getAccountNumber());

			int insertedRows = statement.executeUpdate();
			return insertedRows > 0;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
