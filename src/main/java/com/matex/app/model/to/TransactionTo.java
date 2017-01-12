package com.matex.app.model.to;

public class TransactionTo {
	
	private long id;
	
	private UsersTo debtor;
	
	
	private UsersTo creditor;
	
	
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
	public TransactionTo(UsersTo Debtor, UsersTo Creditor, Double Debt, String description, long id)
	{
		this.debtor = Debtor;
		this.creditor = Creditor;
		this.debt = Debt;
		this.description = description;
		this.setId(id);
	}	
	public TransactionTo(UsersTo Debtor, UsersTo Creditor, Double Debt, String description)
	{
		this.debtor = Debtor;
		this.creditor = Creditor;
		this.debt = Debt;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TransactionTo()
	{
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
