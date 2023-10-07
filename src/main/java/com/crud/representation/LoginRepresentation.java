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
		
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateDeNaissanceRepresentation ;
	
	private String gmailRepresentation ;
	
}
	
