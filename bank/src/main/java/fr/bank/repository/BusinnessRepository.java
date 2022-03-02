package fr.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.bank.model.Bussiness;
import fr.bank.model.Particuler;

@Repository
public interface BusinnessRepository extends JpaRepository<Bussiness, String> {

}
