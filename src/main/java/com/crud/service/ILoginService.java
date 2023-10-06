package com.crud.service;

import org.springframework.data.domain.Page;

import com.crud.command.LoginCommand;
import com.crud.model.Login;
import com.crud.representation.LoginRepresentation;

public interface ILoginService {
	
	
	public Page<LoginRepresentation> getAllLogins (int page , int size , String columnSort);
	
	public Login createLogin (LoginCommand loginCommand);
 
	public void supprimerLogin (int id);
}
