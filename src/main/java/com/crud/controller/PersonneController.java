package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.crud.command.PersonneCommand;
import com.crud.command.PersonneLightCommand;
import com.crud.model.Personne;
import com.crud.representation.PersonneRepresentation;
import com.crud.service.IPersonneService;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
	@Autowired
    private IPersonneService iPersonneService;

//    @GetMapping("/list")
//    public List<PersonneRepresentation> getAllPersonnes() {
//        return iPersonneService.getAllPersonnes();
//    }
	
	@GetMapping
	public Page<PersonneRepresentation> getAllPersonnes(@RequestParam(defaultValue = "1")int page, @RequestParam  (defaultValue = "10") int size , @RequestParam(defaultValue = "id")   String columnSort){
		return iPersonneService.getAllPersonnes(page,size,columnSort); 
		
	}
	

    
    @GetMapping("/{id}")
    public PersonneRepresentation getPersonneById(@PathVariable int id) {
        return  iPersonneService.getPersonneById(id);
    	
    }
    
    
    
    @PostMapping
    public Personne createPersonne(@RequestBody PersonneCommand personneCommand) {
        return iPersonneService.createPersonne(personneCommand);
    }
    
    

    @PutMapping("/modifierLight")
    public Personne updatePersonneLight(@RequestBody PersonneLightCommand personneLightCommand) {
        return iPersonneService.updateLightPersonne(personneLightCommand);
    }
    
    
    
    @PutMapping("/modifier")
    public Personne updatePersonne(@RequestBody PersonneCommand personneCommand) {
        return iPersonneService.updatePersonne(personneCommand);
    }
    
    
    
    @PatchMapping("/patch")
    public Personne patchAdresse(@RequestBody PersonneCommand personneCommand) {
        return iPersonneService.patchPersonne(personneCommand);
    }
    
    

    @DeleteMapping("/supprimer/{id}")
    public void deletePersonne(@PathVariable int id) {
    	iPersonneService.deletePersonne(id);
    }
    

}
