package com.crud.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.crud.command.PersonneCommand;
import com.crud.model.Personne;
import com.crud.representation.PersonneRepresentation;

@Mapper(componentModel = "spring", uses = IAdresseMapper.class)
public interface IPersonneMapper {

	@Mappings({ 
		@Mapping(source = "idCommand", target = "id"),
		@Mapping(source = "nomCommand", target = "nom"),
		@Mapping(source = "prenomCommand", target = "prenom"),
		@Mapping(source = "listCommand", target = "list"),
		@Mapping(source = "epingleCommand", target = "epingle"),
		@Mapping(source = "adressesCommand", target = "adresses")

	})
	Personne convertCommandToEntity(PersonneCommand personneCommand);
	
	
	
	

	@Mappings({
		@Mapping(source = "id", target = "idRepresentation"),
		@Mapping(source = "nom", target = "nomRepresentation"),
		@Mapping(source = "prenom", target = "prenomRepresentation"),
		@Mapping(source = "list", target = "listRepresentation"),
		@Mapping(source = "epingle", target = "epingleRepresentation"),
		@Mapping(source = "adresses", target = "adressesRepresentation")
	})
	PersonneRepresentation convertEntityToRepresentation(Personne personne);
	
	
	
	
	
	@Mappings({
		@Mapping(source = "nom", target = "nomPersonne"),
		@Mapping(source = "prenom", target = "prenomPersonne"),
		@Mapping(source = "adresses", target = "adressesPersonne")
})
	List<PersonneRepresentation>convertListEntityToListRepresentation(List <Personne> personne);
	
	
	
	

}
