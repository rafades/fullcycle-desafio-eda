package com.consumer.balance.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "balance")
@Builder
public class Balance {

	private Long id;
	private String accountId;
	private Double balance;

	public Balance() {
		super();
	}

	public Balance(Long id, String accountId, Double balance) {
		this();
		this.id = id;
		this.accountId = accountId;
		this.balance = balance;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
}
