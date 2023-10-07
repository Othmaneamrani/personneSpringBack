package com.crud.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ConnexionRepresentation {
	
	@JsonIgnore
	private int idRepresentation;
	
	private String usernameRepresentation ;
	
	private String passwordRepresentation ;
	
	
	
}
