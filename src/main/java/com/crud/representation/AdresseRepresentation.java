package com.crud.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AdresseRepresentation {
	
	@JsonIgnore
	private int idRepresentation;
	
	private String rueRepresentation;
	
	private int numeroMaisonRepresentation;
	
}
