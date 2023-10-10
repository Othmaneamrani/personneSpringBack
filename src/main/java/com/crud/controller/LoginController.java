package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.command.LoginCommand;
import com.crud.model.Login;
import com.crud.repository.ILoginRepository;
import com.crud.representation.LoginRepresentation;
import com.crud.service.ILoginService;

@RestController
@RequestMapping("/logins") 
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	
	@Autowired
	private ILoginService iLoginService;
	
	@Autowired
	private ILoginRepository iLoginRepository;
	
	
	
	@GetMapping 
	public Page<LoginRepresentation> getAllLogins (@RequestParam(defaultValue="1")  int page ,@RequestParam(defaultValue="10") int size , @RequestParam(defaultValue="id") String columnSort ){
	return iLoginService.getAllLogins(page,size,columnSort);
	}


//	@PostMapping
//	public Login createLogin(@RequestBody LoginCommand loginCommand) {
//		return iLoginService.createLogin(loginCommand);
//	}
	
	
	@DeleteMapping("/supprimer/{id}")
	public void supprimerLogin (@PathVariable int id) {
		iLoginService.supprimerLogin(id);
	}
	
	
	
	
	
	 @PostMapping("/signup")
	    public String signUp(@RequestBody LoginCommand loginCommand) {
		  List <Login> logins = iLoginRepository.findAll();
	    	for(Login login : logins) {
	        if (login.getConnexion().getUsername().equals(loginCommand.getConnexionCommand().getUsernameCommand())) 
	            return "name";
	        if (login.getGmail().equals(loginCommand.getGmailCommand())) 
	            return "gmail";
	        if (!loginCommand.getConnexionCommand().getPasswordCommand().matches(".*\\d.*") || !loginCommand.getConnexionCommand().getPasswordCommand().matches(".*[A-Z].*") || loginCommand.getConnexionCommand().getPasswordCommand().length() < 6)
	            return "mdp";
	    	}
	    	iLoginService.createLogin(loginCommand);
	    	return loginCommand.getConnexionCommand().getUsernameCommand();
	    }
	
	 
	 
	 

	 
}