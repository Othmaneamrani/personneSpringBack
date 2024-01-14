package com.crud.command;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class LoginCommand {

	private int idCommand;
	
	private ConnexionCommand connexionCommand ;
	
	private Date dateDeNaissanceCommand ;
	
	private String gmailCommand ;

	
}
