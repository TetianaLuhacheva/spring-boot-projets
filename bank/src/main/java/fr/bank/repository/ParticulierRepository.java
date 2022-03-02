package fr.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bank.model.Particuler;

public interface ParticulierRepository extends JpaRepository<Particuler, String> { 
	
}
