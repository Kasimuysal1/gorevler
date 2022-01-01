package com.example.banking.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public class Customer {
	private final String identity;
	private String fullName;
	private Map<String, Account> accounts = new HashMap<String, Account>();
	

	public Customer(String identity, String fullName) {
		this.identity = identity;
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdentity() {
		return identity;
	}

	@SuppressWarnings("unchecked")
	public void addAccount(Account account) {
		((Collection<Account>) accounts).add(account);
	}
	
	public Optional<Account> removeAccount(int index) {
		return Optional.empty();
	}
	
	public Optional<Account> removeAccount(String iban) {
		Account foundAccount = null;
		
		for (var account1 : account) {
			if (((Account) account1).getIban().equals(iban)) {
				foundAccount = (Account) account1;	break;
			}
		}
		if (Objects.nonNull(foundAccount)) {
			accounts.remove(foundAccount);
		}
		return Optional.ofNullable(foundAccount);
	}
	
	public Map<String,Account> getAccounts(){
		return (Map<String, Account>) Collections.unmodifiableMap(accounts);
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullName=" + fullName + ", accounts=" + accounts + "]";
	}
	
}


