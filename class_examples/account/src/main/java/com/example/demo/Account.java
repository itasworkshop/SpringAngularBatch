package com.example.demo;

import java.math.BigDecimal;

public class Account {
	
	private Integer accountId;
	private String accountType;
	private BigDecimal balance;
	
	public Account() {
		
	}

	public Account(Integer accountId, String accountType, BigDecimal balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
