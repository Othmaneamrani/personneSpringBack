package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.command.ConnexionCommand;
import com.crud.model.Connexion;
import com.crud.repository.IConnexionRepository;

@Service
public class ConnexionServiceImpl implements IConnexionService {

	@Autowired
	IConnexionRepository iConnexionRepository ;
	
	
	
	@Override
	public Boolean checkConnexion(ConnexionCommand connexionCommand) {
		List <Connexion> connexions = iConnexionRepository.findAll();
    	for(Connexion connexion : connexions) {
        if (connexion.getUsername().equals(connexionCommand.getUsernameCommand()) && connexion.getPassword().equals(connexionCommand.getPasswordCommand())) 
            return true;
    	}
		return false;
	}

}
