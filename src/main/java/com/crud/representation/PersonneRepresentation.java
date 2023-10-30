package com.crud.representation;

import java.util.List;

import com.crud.model.Connexion;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class PersonneRepresentation {
	
	private int idRepresentation;

	private String nomRepresentation;
	
	private String prenomRepresentation;
	
	@JsonIgnore
	private Connexion connexion ;
		
	private List <AdresseRepresentation> adressesRepresentation;
    
    private Boolean listRepresentation ;
    
    private Boolean epingleRepresentation ;
}
