package com.matex.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@ManyToOne
	private User debtor;
	
	@NotNull
	@ManyToOne
	private User creditor;
	
	@NotNull
	private Integer debt;
	
	private String description;
	
	public Integer getDebt()
	{
		return debt;
	}
	public void setDebt(Integer Debt)
	{
		this.debt = Debt;
	}
	public void setDebtor(User Debtor)
	{
		this.debtor = Debtor;
	}
	public void setCreditor(User Creditor)
	{
		this.creditor = Creditor;
	}
	public User getDebtor()
	{
		return this.debtor;
	}
	public User getCreditor()
	{
		return this.creditor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Transaction()
	{
		
	}
	public Transaction(User debtor, User creditor, Integer debt, String description) {
		super();
		this.debtor = debtor;
		this.creditor = creditor;
		this.debt = debt;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
