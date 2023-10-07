package com.crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.crud.command.LoginCommand;
import com.crud.model.Login;
import com.crud.representation.LoginRepresentation;

@Mapper(componentModel="spring",  uses = IConnexionMapper.class)
public interface ILoginMapper {

	
	@Mappings({
		@Mapping(source="connexion" , target ="connexionRepresentation"),
		@Mapping(source="dateDeNaissance" , target ="dateDeNaissanceRepresentation"),
		@Mapping(source="gmail" , target ="gmailRepresentation")
	})
	LoginRepresentation convertEntityToRepresentation (Login login	);
	
	
	
	
	@Mappings({
		@Mapping(source="idCommand" , target ="id"),
		@Mapping(source="connexionCommand" , target ="connexion"),
		@Mapping(source="dateDeNaissanceCommand" , target ="dateDeNaissance"),
		@Mapping(source="gmailCommand" , target ="gmail")
	})
	Login convertCommandToEntity  (LoginCommand loginCommand);
	
	
}
