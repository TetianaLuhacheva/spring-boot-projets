package fr.bank.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table; 

@Entity
@DiscriminatorValue(value = "BUSINESS") 

public class Bussiness extends Person  {
	
	@Column(name="FINANCIAL_FIRST_NAME")
	private String firstName;

	@Column(name="FINANCIAL_SECOND_NAME")
	private String lastName;
	
	@Column(name="FINANCIAL_PHONE")
	private String lastPhone;
	
	
}
