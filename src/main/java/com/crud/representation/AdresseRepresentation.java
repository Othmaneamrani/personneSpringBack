package com.crud.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AdresseRepresentation {
	

	private int idRepresentation;
	
	private String rueRepresentation;
	
	private String numeroMaisonRepresentation;
	
}
