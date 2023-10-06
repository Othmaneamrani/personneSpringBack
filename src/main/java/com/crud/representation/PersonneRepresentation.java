package com.crud.representation;

import java.util.List;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class PersonneRepresentation {
	

	private String nomRepresentation;
	
	private String prenomRepresentation;
	
	private List <AdresseRepresentation> adressesRepresentation;

}
