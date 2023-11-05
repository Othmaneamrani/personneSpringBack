package com.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.crud.command.ConnexionCommand;
import com.crud.command.PasswordCommand;
import com.crud.model.Connexion;
import com.crud.representation.ConnexionRepresentation;

public interface IConnexionService {

	
	public Connexion checkConnexion (ConnexionCommand connexionCommand);
	
 	public Page<ConnexionRepresentation> getAllConnexions(int page,int size, String columnSort);

	public void viderConnexion(int id);
	
	public Connexion createConnexion (ConnexionCommand connexionCommand);
	
	public String changeUsername (int id , String usernameCommand);
	
	public String changePassword (int id , PasswordCommand passwordCommand );
		

}
