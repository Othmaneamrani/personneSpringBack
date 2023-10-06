package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.command.ConnexionCommand;
import com.crud.service.IConnexionService;

@RestController
@RequestMapping("/connexion") 
public class ConnexionController {

	
	@Autowired
	private IConnexionService iConnexionService ;
	
	@PostMapping
	public Boolean checkLogin (@RequestParam ConnexionCommand connexionCommand) {
	return iConnexionService.checkConnexion(connexionCommand);
}
}