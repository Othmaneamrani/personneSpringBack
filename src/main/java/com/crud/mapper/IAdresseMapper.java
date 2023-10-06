package com.crud.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.crud.command.AdresseCommand;
import com.crud.model.Adresse;
import com.crud.representation.AdresseRepresentation;

@Mapper(componentModel = "spring" , uses = IPersonneMapper.class)
public interface IAdresseMapper {
	
	@Mappings({
		@Mapping(source="idCommand" , target="id"),
		@Mapping(source="rueCommand" , target="rue"),
		@Mapping(source="numeroMaisonCommand" , target="numeroMaison")
	})
	Adresse convertCommandToEntity(AdresseCommand adresseCommand);
	
	
	
	
	@Mappings({
		@Mapping(source="rue" , target="rueRepresentation"),
		@Mapping(source="numeroMaison" , target="numeroMaisonRepresentation")
	})
	AdresseRepresentation convertEntityToRepresentation(Adresse adresse);
	
	
	
	
	

	@Mappings({
		@Mapping(source ="id", target="idRepresentation"),
		@Mapping(source ="rue", target="rueRepresentation"),
		@Mapping(source ="numeroMaison", target="numeroMaisonRepresentation")
})
	List<AdresseRepresentation>convertListEntityToListRepresentation(List<Adresse> adresse);
	
	
	
}
