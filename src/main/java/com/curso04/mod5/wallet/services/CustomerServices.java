package com.curso04.mod5.wallet.services;

import com.curso04.mod5.wallet.daos.CustomerDAO;
import com.curso04.mod5.wallet.model.Customer;

public class CustomerServices {

	public boolean insertCustomer(Customer customer) {

		CustomerDAO CustomerDAO = new CustomerDAO();
		boolean insertion = CustomerDAO.customertInsert(customer);
		return insertion;
	}

}
