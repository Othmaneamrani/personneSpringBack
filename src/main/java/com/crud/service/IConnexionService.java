package com.crud.service;

import org.springframework.data.domain.Page;

import com.crud.command.ConnexionCommand;
import com.crud.model.Connexion;
import com.crud.representation.ConnexionRepresentation;

public interface IConnexionService {

	
	public Boolean checkConnexion (ConnexionCommand connexionCommand);
	
 	public Page<ConnexionRepresentation> getAllConnexions(int page,int size, String columnSort);

	public void deleteConnexion(int id);
	
	public Connexion createConnexion (ConnexionCommand connexionCommand);
}
