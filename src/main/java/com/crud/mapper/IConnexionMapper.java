package com.crud.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.crud.command.ConnexionCommand;
import com.crud.model.Connexion;
import com.crud.representation.ConnexionRepresentation;

@Mapper(componentModel="spring",  uses = IPersonneMapper.class)
public interface IConnexionMapper {
	
	
	@Mappings({
		@Mapping(source="idCommand" , target ="id"),
		@Mapping(source="usernameCommand" , target ="username"),
		@Mapping(source="passwordCommand" , target ="password"),
	})
	Connexion convertCommandToEntity (ConnexionCommand connexionCommand);
	
	
	
	
	
	
	@Mappings({
		@Mapping(source="id" , target ="idRepresentation"),
		@Mapping(source="username" , target ="usernameRepresentation"),
		@Mapping(source="password" , target ="passwordRepresentation"),
	})
	ConnexionRepresentation convertEntityToRepresentation (Connexion connexion);
	
	

}
