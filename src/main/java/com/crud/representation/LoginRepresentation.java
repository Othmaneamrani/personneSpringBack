package com.crud.representation;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class LoginRepresentation{	
		
	private ConnexionRepresentation connexionRepresentation;
		
	private Date dateDeNaissanceRepresentation ;
	
	private String gmailRepresentation ;
	
}
	
