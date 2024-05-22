package com.curso04.mod5.wallet.services;

import java.util.ArrayList;
import java.util.List;

import com.curso04.mod5.wallet.daos.AccountDAO;
import com.curso04.mod5.wallet.model.Account;

public class AccountServices {

	public boolean insertAccount(Account account) {

		AccountDAO accountDAO = new AccountDAO();
		boolean insertion = accountDAO.accountInsert(account);
		return insertion;
	}

	public List<Account> listAccount() {
		List<Account> listAccount = new ArrayList<>();
		AccountDAO accountDAO = new AccountDAO();
		listAccount = accountDAO.accountList();
		return listAccount;
	}

	public List<Account> searchAccountHolder(String holder) {
		List<Account> searchAccount = new ArrayList<>();
		AccountDAO accountDAO = new AccountDAO();
		searchAccount = accountDAO.accountSearchHolder(holder);
		return searchAccount;
	}

	public Account searchAccountNumber(int number) {
		AccountDAO accountDAO = new AccountDAO();
		Account searchAccount = accountDAO.accountSearchNumber(number);
		return searchAccount;
	}

	public boolean updateAccount(Account account) {
		AccountDAO accountDAO = new AccountDAO();
		boolean completed = accountDAO.accountUpdate(account);
		return completed;
	}

	public boolean deleteAccount(int number) {
		AccountDAO accountDAO = new AccountDAO();
		boolean isDeleted = accountDAO.accountDelete(number);
		return isDeleted;
	}

}
