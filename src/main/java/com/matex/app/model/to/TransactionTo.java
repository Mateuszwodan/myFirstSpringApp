package com.matex.app.model.to;

public class TransactionTo {
	
	private long id;
	
	private UsersTo debtor;
	
	
	private UsersTo creditor;
	
	
	private Double debt;
	
	public Double getDebt()
	{
		return debt;
	}
	public void setDebt(Double Debt)
	{
		this.debt = Debt;
	}
	public TransactionTo(UsersTo Debtor, UsersTo Creditor, Double Debt)
	{
		this.debtor = Debtor;
		this.creditor = Creditor;
		this.debt = Debt;
	}	
	public void setDebtor(UsersTo Debtor)
	{
		this.debtor = Debtor;
	}
	public void setCreditor(UsersTo Creditor)
	{
		this.creditor = Creditor;
	}
	public UsersTo getDebtor()
	{
		return this.debtor;
	}
	public UsersTo getCreditor()
	{
		return this.creditor;
	}
}
