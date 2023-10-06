package com.crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.crud.command.PersonneLightCommand;
import com.crud.model.Personne;


@Mapper(componentModel = "spring")
public interface IPersonneLightMapper {
	@Mappings({
		@Mapping(source = "idCommand", target = "id"),
	    @Mapping(source = "nomCommand", target = "nom"),
	    @Mapping(source = "prenomCommand", target = "prenom")
	})
	Personne convertCommandToEntity(PersonneLightCommand personneLightCommand);
}
