package fr.bank.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="T_EPARGNE")
@PrimaryKeyJoinColumn(name = "ACCOUNT_ID")
public class Epargne extends Compte {
	
}
