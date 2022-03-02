package fr.bank.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity 
@DiscriminatorValue(value = "PARTICULIER")
	
public class Particuler extends Person {

}
