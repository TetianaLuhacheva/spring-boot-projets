package fr.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.bank.dto.CompteDto;
import fr.bank.dto.TransactionDto;
import fr.bank.model.Particuler;
import fr.bank.service.CompteService;
import fr.bank.service.ParticularService;
import fr.bank.service.TransactionService;

@RestController
public class ParticulerController {
	
	@Autowired
	CompteService compte;

	@Autowired
	TransactionService transactionService;
	
	
	@PostMapping("/compte/add")
	public ResponseEntity<CompteDto> save(@RequestBody CompteDto compteDto){
		System.out.println("====================");	
		System.out.println("==      DONE !    ==");
		System.out.println("====================");
		
		compte.save(compteDto);
		return new ResponseEntity<CompteDto>(compteDto, HttpStatus.OK);
	}
	
	@PostMapping("/transaction/add")
	public ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transactionDto){
		System.out.println("==================================================================");	
		System.out.println("==                            DONE !                            ==");
		System.out.println("==================================================================");		
		transactionService.doTransaction(transactionDto);		
		System.out.println("==================================================================");
		System.out.println("==================================================================");
		System.out.println("==================================================================");
		
		return new ResponseEntity<TransactionDto>(transactionDto, HttpStatus.OK);
	}
//	
//	@PostMapping("/particuler/add")
//	public ResponseEntity<Particuler> save (@RequestBody Particuler particuler){
//		particulerService.save(particuler);
//		return new ResponseEntity<Particuler>(particuler, HttpStatus.OK);
//	}
//	
//	@GetMapping("/particuler/findAll")
//	public ResponseEntity<List<Particuler>> findAll(){
//		List<Particuler> particulers = particulerService.findAll();
//		return new ResponseEntity<List<Particuler>>(particulers, HttpStatus.OK);
//	}
//
//	@GetMapping("/particuler/find/{personId}")
//	public ResponseEntity<Particuler> findById (@PathVariable("personId") String personId){
//		Particuler particuler = particulerService.findById(personId);
//		return new ResponseEntity<Particuler>(particuler, HttpStatus.OK);
//	}
	

	@GetMapping("/bonjour")
	public String bonjour(){ 
		return "Bonjour";
	}	
}
