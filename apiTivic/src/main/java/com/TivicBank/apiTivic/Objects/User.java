package com.TivicBank.apiTivic.Objects;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String name;
	private String email;
	private Float balance;
	
	
	public User() {
		super();
	}
	
	public User(String name, String email, Float balance) {
		this.name = name;
		this.email = email;
		this.balance = balance;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	
}
