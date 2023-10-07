package com.crud.command;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class LoginCommand {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommand;
	
	private ConnexionCommand connexionCommand ;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateDeNaissanceCommand ;
	
	private String gmailCommand ;

	
}
