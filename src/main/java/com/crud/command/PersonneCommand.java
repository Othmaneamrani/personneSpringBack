package com.crud.command;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonneCommand {
	
	private int idCommand;
	
	private String nomCommand;
	
	private String prenomCommand;
	
	private ConnexionCommand connexionCommand ;
	
	private List <AdresseCommand> adressesCommand;
    
    private Boolean listCommand ;
    
    private Boolean epingleCommand ;
}
