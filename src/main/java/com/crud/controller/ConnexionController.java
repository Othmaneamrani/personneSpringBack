package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.command.ConnexionCommand;
import com.crud.model.Connexion;
import com.crud.representation.ConnexionRepresentation;
import com.crud.service.IConnexionService;

@RestController
@RequestMapping("/connexions") 
@CrossOrigin(origins = "http://localhost:3000")
public class ConnexionController {

	
	@Autowired
	private IConnexionService iConnexionService ;
	
	
	@PostMapping("/connexion")
	public Boolean checkConnexion (@RequestBody ConnexionCommand connexionCommand) {
	if (connexionCommand.getUsernameCommand().equals(connexionCommand.getUsernameCommand()) &&  connexionCommand.getPasswordCommand().equals(connexionCommand.getPasswordCommand()))
		return true;
		
	return false;
	}
	
	
	
	
	@GetMapping
    public Page<ConnexionRepresentation> getAllConnexion(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size , @RequestParam(defaultValue = "id") String columnSort){
        return iConnexionService.getAllConnexions(page, size , columnSort);
    }	
	
	
	
	
	  @DeleteMapping("/supprimer/{id}")
	    public void deleteConnexion(@PathVariable int id) {
	    	iConnexionService.deleteConnexion(id);
	    }
	
	  
	  @PostMapping
	  public Connexion createConnexion (@RequestBody ConnexionCommand connexionCommand) {
		  return iConnexionService.createConnexion(connexionCommand);
	  }
	
}