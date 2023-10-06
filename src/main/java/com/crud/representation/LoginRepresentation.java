package com.crud.representation;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class LoginRepresentation{	
	
	@JsonIgnore
	private int idRepresentation;
		
	private String usernameRepresentation;
		
	private String passwordRepresentation;
		
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateDeNaissanceRepresentation ;
	
	private String gmailRepresentation ;
	
}
	
