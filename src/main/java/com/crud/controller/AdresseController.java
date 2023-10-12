package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.command.AdresseCommand;
import com.crud.model.Adresse;
import com.crud.representation.AdresseRepresentation;
import com.crud.service.IAdresseService;


@RestController
@RequestMapping("/adresses") 
@CrossOrigin(origins = "http://localhost:3000")
public class AdresseController {
	
	@Autowired 
	private IAdresseService iAdresseService;
	
//	  @GetMapping
//	    public List<AdresseRepresentation> getAllAdresse() {
//	        return iAdresseService.getAllAdresses();
//	    }
	
	@GetMapping
    public Page<AdresseRepresentation> getAllAdresses(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size , @RequestParam(defaultValue = "id") String columnSort){
        return iAdresseService.getAllAdresses(page, size , columnSort);
    }
	
	

	  @GetMapping("/{id}")
	    public AdresseRepresentation getAdresseById(@PathVariable int id) {
	        return iAdresseService.getAdresseById(id);

	    }
	  
	  
	  
	  @PostMapping
	    public Adresse createAdresse(@RequestBody  AdresseCommand adresseCommand) {
	        return iAdresseService.createAdresse(adresseCommand);
	    }
	  
	  

	  @PutMapping("/modifier")
	    public Adresse updateAdresse(@RequestBody AdresseCommand adresseCommand) {
	        return iAdresseService.updateAdresse(adresseCommand);
	    }
	  
	  
	  
	  @PatchMapping("/patch")
	    public Adresse patchAdresse(@RequestBody AdresseCommand adresseCommand) {
	        return iAdresseService.patchAdresse(adresseCommand);
	    }
	  
	  
	  
	  @DeleteMapping("/supprimer/{id}")
	    public void deleteAdresse(@PathVariable int id) {
	    	iAdresseService.deleteAdresse(id);
	    }
	  
	  
}
