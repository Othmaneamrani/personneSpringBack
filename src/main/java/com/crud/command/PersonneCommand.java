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
	
	private List <AdresseCommand> adressesCommand;
    
    private Boolean listCommand = false ;
    
    private Boolean epingleCommand = false ;
}
