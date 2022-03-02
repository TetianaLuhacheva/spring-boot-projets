package fr.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import fr.bank.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {
	
}
