package com.crud.command;

import java.util.List;

import com.crud.model.Personne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConnexionCommand {
	
	private int idCommand ;
	
	private List<PersonneCommand> personnesCommand;
	
	private String usernameCommand ;
	
	private String passwordCommand ; 
	
}
