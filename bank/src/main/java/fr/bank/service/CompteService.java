package fr.bank.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bank.dto.CompteDto;
import fr.bank.model.Bussiness;
import fr.bank.model.Courant;
import fr.bank.model.Epargne;
import fr.bank.model.Particuler;
import fr.bank.model.Person;
import fr.bank.repository.BusinnessRepository;
import fr.bank.repository.CompteRepository;
import fr.bank.repository.ParticulierRepository;

@Service
@Transactional
public class CompteService {
	@Autowired
	private ParticulierRepository particulierRepository;
	
	@Autowired
	BusinnessRepository businnessRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	public CompteDto save(CompteDto p) {
		if(p.getType().equalsIgnoreCase("P")) {
			Particuler particuler = new Particuler();			
			particuler.setPersonId(p.getPersonId());
			particuler.setFullName(p.getPersonName());
			particuler.setEmail(p.getPersonEmail()); 			
			particulierRepository.save(particuler); 
			saveCompte(p, particuler);
		} else if (p.getType().equalsIgnoreCase("B")) {

			Bussiness bussiness = new Bussiness();			
			bussiness.setPersonId(p.getPersonId());
			bussiness.setFullName(p.getPersonName());
			bussiness.setEmail(p.getPersonEmail()); 			
			businnessRepository.save(bussiness); 
			saveCompte(p, bussiness);
		}
				
		System.out.println(p);
		return p;
	}
	private void saveCompte(CompteDto p,Person particulier) {
		if(p.getType().equalsIgnoreCase("C")) {
			Courant courant =new Courant();
			courant.setAccountId(p.getNumeroCompte());
			courant.setPerson(particulier);
			courant.setAccountAmount(0);
			courant.setCreateDate(new Date ());
			compteRepository.save(courant);
		}
		if(p.getTypeCompte().equalsIgnoreCase("E")) {
			Epargne epargne=new Epargne();
			epargne.setAccountId(p.getNumeroCompte());
			epargne.setPerson(particulier);
			epargne.setAccountAmount(200);
			epargne.setCreateDate(new Date());
			compteRepository.save(epargne);
		}	
	}
	
}
