package com.crud.representation;

import java.util.List;

import com.crud.model.Personne;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ConnexionRepresentation {
	
	
	private int idRepresentation;
	
	private String usernameRepresentation ;
	
	private String passwordRepresentation ;	
	
	
}
