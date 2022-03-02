package fr.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bank.model.Particuler;
import fr.bank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>  {

}
