package fr.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bank.model.Particuler;
import fr.bank.model.Person;
import fr.bank.repository.ParticulierRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParticularService extends Person {

	@Autowired
	private ParticulierRepository particularRepository ;
	
	public Particuler save(Particuler particular) {
		
		return particularRepository.save(particular);
	}
	
	public List<Particuler> findAll(){
		return (List<Particuler>) particularRepository.findAll();
	}
	
	public Particuler findById (String value) {
		Optional<Particuler> optional = particularRepository.findById(value);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
}
