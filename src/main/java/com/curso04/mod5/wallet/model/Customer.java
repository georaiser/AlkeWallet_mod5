package com.curso04.mod5.wallet.model;

public class Customer {

	private String name;
	private int accountNumber;

	public Customer(String name, int accountNumber) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
