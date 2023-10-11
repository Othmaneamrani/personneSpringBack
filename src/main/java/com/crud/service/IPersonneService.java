package com.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.crud.command.PersonneCommand;
import com.crud.command.PersonneLightCommand;
import com.crud.model.Personne;
import com.crud.representation.PersonneRepresentation;

public interface IPersonneService {
	
//    public List<PersonneRepresentation> getAllPersonnes();
	
	public Page<PersonneRepresentation> getAllPersonnes(int page, int size, String columnSort, String like);

	public PersonneRepresentation getPersonneById(int id);

	public String createPersonne(PersonneCommand personneCommand );
	
	public Personne patchPersonne(PersonneCommand personneCommand);

	public Personne updateLightPersonne(PersonneLightCommand personneLightCommand);
	
	public Personne updatePersonne(PersonneCommand personneCommand);

	public void deletePersonne(int id);

}
