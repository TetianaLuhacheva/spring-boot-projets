package fr.bank.service;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bank.dto.TransactionDto;
import fr.bank.model.Bussiness;
import fr.bank.model.Compte;
import fr.bank.model.TransactionRetrait;
import fr.bank.model.TransactionVersement;
import fr.bank.repository.CompteRepository;
import fr.bank.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private CompteRepository compteRepository;
	
	public TransactionDto doTransaction(TransactionDto tDto) {
		if(tDto.getTransactionType().equalsIgnoreCase("V")) {
			TransactionVersement tv = new TransactionVersement();
			tv.setTransactionId(tDto.getTransactionId());
			tv.setAmount(tDto.getTransactionAmount());
			tv.setTransactionDate(new Date());

			Optional<Compte> compte = compteRepository.findById(tDto.getCompteId());
			tv.setCompte(compte.get());
			
			Compte c = compte.get();
			c.setAccountAmount(c.getAccountAmount() + tDto.getTransactionAmount());
			
			compteRepository.save(c);			
			transactionRepository.save(tv);
		}  else if (tDto.getTransactionType().equalsIgnoreCase("R")) {

			Optional<Compte> compte = compteRepository.findById(tDto.getCompteId());
			
			if (compte.get().getAccountAmount() >= tDto.getTransactionAmount()) {
				TransactionRetrait retrait = new TransactionRetrait();			
				retrait.setTransactionId(tDto.getTransactionId());
				retrait.setAmount(tDto.getTransactionAmount());
				retrait.setTransactionDate(new Date());

				retrait.setCompte(compte.get());
				
				Compte c = compte.get();
				c.setAccountAmount(c.getAccountAmount() - tDto.getTransactionAmount());
				
				compteRepository.save(c);			
				transactionRepository.save(retrait);
			} else {
				System.out.println("Pas d'argent suffisant");
			}
			
		return tDto;
	}

}
