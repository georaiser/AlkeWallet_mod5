package com.curso04.mod5.wallet.services;

import java.sql.SQLException;

import com.curso04.mod5.wallet.daos.UserDAO;
import com.curso04.mod5.wallet.model.User;

public class UserServices {
	
	public boolean userValidation(User user) {
		boolean validUser = false;
		try {
			UserDAO userDAO = new UserDAO();
			validUser = userDAO.userValidation(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validUser;

	}

}
