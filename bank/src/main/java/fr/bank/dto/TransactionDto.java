package fr.bank.dto;

public class TransactionDto {

	private String transactionId;
	private double transactionAmount;  
	private String compteId;
	private String transactionType;
	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public TransactionDto() { 
	}
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getCompteId() {
		return compteId;
	}
	public void setCompteId(String compteId) {
		this.compteId = compteId;
	}

	@Override
	public String toString() {
		return "TransactionDto [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", compteId=" + compteId + "]";
	}	
	

	
}
