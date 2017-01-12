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
	private Users debtor;
	
	@NotNull
	@ManyToOne
	private Users creditor;
	
	@NotNull
	private Double debt;
	
	private String description;
	
	public Double getDebt()
	{
		return debt;
	}
	public void setDebt(Double Debt)
	{
		this.debt = Debt;
	}
	public Transaction(Users Debtor, Users Creditor, Double Debt, String description)
	{
		this.debtor = Debtor;
		this.creditor = Creditor;
		this.debt = Debt;
		this.description = description;
	}
	public void setDebtor(Users Debtor)
	{
		this.debtor = Debtor;
	}
	public void setCreditor(Users Creditor)
	{
		this.creditor = Creditor;
	}
	public Users getDebtor()
	{
		return this.debtor;
	}
	public Users getCreditor()
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
}
