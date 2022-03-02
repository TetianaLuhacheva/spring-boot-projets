package fr.bank.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Transaction implements Serializable{
	
	@Id
	@Column(name="TRANSACTION_ID")
	private String transactionId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TRANSACTION_DATA")
	private Date transactionDate = new Date();
	
	@Column(name="TRANSACTION_AMOUNT")
	private double amount;

	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID")
	private Compte compte;
	
	public Transaction() { 
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}	

}
