package com.matex.app.model.DTO;

public class TransactionDTO {
	
	private long id;
	
	private UserDTO debtor;
		
	private UserDTO creditor;
		
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
	public TransactionDTO(UserDTO Debtor, UserDTO Creditor, Double Debt, String description, long id)
	{
		this.debtor = Debtor;
		this.creditor = Creditor;
		this.debt = Debt;
		this.description = description;
		this.setId(id);
	}	
	public TransactionDTO(UserDTO Debtor, UserDTO Creditor, Double Debt, String description)
	{
		this.debtor = Debtor;
		this.creditor = Creditor;
		this.debt = Debt;
		this.description = description;
	}	
	public void setDebtor(UserDTO Debtor)
	{
		this.debtor = Debtor;
	}
	public void setCreditor(UserDTO Creditor)
	{
		this.creditor = Creditor;
	}
	public UserDTO getDebtor()
	{
		return this.debtor;
	}
	public UserDTO getCreditor()
	{
		return this.creditor;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TransactionDTO()
	{
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
