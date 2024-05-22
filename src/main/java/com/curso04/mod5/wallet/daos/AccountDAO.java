package com.curso04.mod5.wallet.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso04.mod5.wallet.dbconnection.MysqlConnectionClass;
import com.curso04.mod5.wallet.model.Account;

public class AccountDAO {

	private Connection connection;

	/*
	 * create MySql connection (Singleton pattern implemented)
	 */
	public AccountDAO() {
		try {
			connection = MysqlConnectionClass.getInstance().getConnection();
			// MysqlConnectionClass mysqlConnectionClass =
			// MysqlConnectionClass.getInstance();
			// connection = mysqlConnectionClass.getConnection();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// insert account into DB
	public boolean accountInsert(Account account) {
		// Account ---> dataBase table
		String sql_statement = "INSERT INTO Account (accountNumber, accountHolder, accountBalance) VALUE (?,?,?)";

		try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			// account parameters
			statement.setInt(1, account.getAccountNumber());
			statement.setString(2, account.getAccountHolder());
			statement.setDouble(3, account.getAccountBalance());
			int insertedRows = statement.executeUpdate();
			return insertedRows > 0;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// show list with all accounts
	public List<Account> accountList() {
		List<Account> accountList = new ArrayList<Account>();
		// Account ---> dataBase table
		String sql_statement = "SELECT * FROM Account";
		try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				// from dataBase table accountNumber|accountHolder|accountBalance|
				int accountNumber = rs.getInt("accountNumber");
				String accountHolder = rs.getString("accountHolder");
				double accountBalance = rs.getDouble("accountBalance");
				Account account = new Account(accountNumber, accountHolder, accountBalance);
				accountList.add(account);
			}
			return accountList;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return accountList;
		}
	}

	// search all account that belong to an user
	public List<Account> accountSearchHolder(String holder) {
		List<Account> accountSearchHolder = new ArrayList<Account>();
		String sql_statement = "SELECT * FROM Account WHERE accountHolder = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			// account parameters
			statement.setString(1, holder);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				// from dataBase table accountNumber|accountHolder|accountBalance|
				int accountNumber = rs.getInt("accountNumber");
				String accountHolder = rs.getString("accountHolder");
				double accountBalance = rs.getDouble("accountBalance");
				Account account = new Account(accountNumber, accountHolder, accountBalance);
				accountSearchHolder.add(account);
			}
			return accountSearchHolder;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return accountSearchHolder;
		}
	}

	// search an account by account number
	public Account accountSearchNumber(int number) {
		String sql_statement = "SELECT * FROM Account WHERE accountNumber = ?";
		Account account = null;

		try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			// query account parameters
			statement.setInt(1, number);

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					// from dataBase table accountNumber|accountHolder|accountBalance|
					int accountNumber = rs.getInt("accountNumber");
					String accountHolder = rs.getString("accountHolder");
					double accountBalance = rs.getDouble("accountBalance");
					// Account instance
					account = new Account(accountNumber, accountHolder, accountBalance);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	// update account
	public boolean accountUpdate(Account account) {
		boolean updateCompleted = false;
		String sql_statement = "UPDATE Account SET accountHolder = ?, accountBalance = ? where accountNumber = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			statement.setString(1, account.getAccountHolder());
			statement.setDouble(2, account.getAccountBalance());
			statement.setInt(3, account.getAccountNumber());
			if (statement.executeUpdate() > 0) {
				updateCompleted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCompleted;
	}

	// delete account
	public boolean accountDelete(int number) {
		boolean isDeleted = false;
		String sql_statement = "DELETE FROM Account where accountNumber = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql_statement)) {
			statement.setInt(1, number);
			if (statement.executeUpdate() > 0) {
				isDeleted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

}
