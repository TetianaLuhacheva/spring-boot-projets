package fr.bank.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_COURANT")
@PrimaryKeyJoinColumn(name = "ACCOUNT_ID")
public class Courant extends Compte {
	
}
