package fr.bank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)	
@Table(name="T_Compte")
public abstract class Compte {
	@Id
	@Column(name = "ACCOUNT_ID")
	private String accountId;
	
	@Column(name = "ACCOUNT_AMOUNT")
	private double accountAmount;
	
	@Column(name = "ACCOUNT_DATE")
	private Date createDate = new Date();
	
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private Person person;

	public Compte() { 
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getAccountAmount() {
		return accountAmount;
	}

	public void setAccountAmount(double accountAmount) {
		this.accountAmount = accountAmount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
}
