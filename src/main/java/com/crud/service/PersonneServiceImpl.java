package com.crud.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crud.command.AdresseCommand;
import com.crud.command.PersonneCommand;
import com.crud.command.PersonneLightCommand;
import com.crud.mapper.IPersonneLightMapper;
import com.crud.mapper.IPersonneMapper;
import com.crud.model.Adresse;
import com.crud.model.Personne;
import com.crud.repository.IPersonneRepository;
import com.crud.representation.PersonneRepresentation;

@Service
public class PersonneServiceImpl implements IPersonneService {
	
	@Autowired
	private IPersonneRepository iPersonneRepository ;
	
	@Autowired
	private IAdresseService iAdresseService ;
	
	
	@Autowired
	private IPersonneMapper iPersonneMapper;
	
	@Autowired
	private IPersonneLightMapper iPersonneLightMapper;
	
	
	@Override
	public List<PersonneRepresentation> getAllPersonnesAll() {		
		return iPersonneMapper.convertListEntityToListRepresentation(iPersonneRepository.findAll());
	}
	
	@Override
	public Page<PersonneRepresentation> getAllPersonnes(int page , int size, String columnSort, String like){
		Sort sort = Sort.by(Sort.Order.asc(columnSort)) ;
//		Sort sort = null;
//		if (columnSort != null && !columnSort.isBlank()) {
//			 sort = Sort.by(Sort.Order.asc(columnSort));
//		} else {
//			 sort = Sort.by(Sort.Order.asc("id"));
//		}
  		PageRequest pageable = PageRequest.of(page-1,size, sort);
		
		 Page<Personne> personnePage;
		    if (like != null && !like.isBlank()) {
		    	 try {
		    		 int id = Integer.parseInt(like);
		             personnePage = iPersonneRepository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrId(like, like, id, pageable);
		         } catch (NumberFormatException e) {
		             personnePage = iPersonneRepository.findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCase(like, like, pageable);
		         }
		     } else {
		         personnePage = iPersonneRepository.findAll(pageable);
		     }
		
//		Page <Personne> personnePage = iPersonneRepository.findAll(pageable);
		Page<PersonneRepresentation> personneRepresentationPage = personnePage.map(personne-> iPersonneMapper.convertEntityToRepresentation(personne));
		return personneRepresentationPage;
	}


	
	
	
	@Override
	public PersonneRepresentation getPersonneById(int id) {
//		Optional <Personne> personneOptional = iPersonneRepository.findById(id);
//		if (!personneOptional.isPresent()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
		PersonneRepresentation personneRepresentation = iPersonneMapper.convertEntityToRepresentation(iPersonneRepository.findById(id).get());
		return personneRepresentation;
	}

	
	
	
	
	@Override
	public String createPersonne(PersonneCommand personneCommand) {
		Personne personne = iPersonneMapper.convertCommandToEntity(personneCommand);
		for(Adresse adresse : personne.getAdresses()) {
			adresse.setPersonne(personne);
		}
		iPersonneRepository.save(personne);
		return "ok";
	}

	
	
	
	
	@Override
	public Personne updateLightPersonne(PersonneLightCommand personneLightCommand) {
		Personne personne = iPersonneLightMapper.convertCommandToEntity(personneLightCommand);     
	            return iPersonneRepository.save(personne);
	}

	
	
	
	
	@Override
	public void deletePersonne(int id) {
		iPersonneRepository.deleteById(id);	
	}
	
	
	
	
	
	@Override
	public Personne updatePersonne(PersonneCommand personneCommand) {
		Personne personne = iPersonneMapper.convertCommandToEntity(personneCommand);    
		for(Adresse adresse : personne.getAdresses()) {
			adresse.setPersonne(personne);
		}
		return iPersonneRepository.save(personne);
	}


	
	
	
	
	@Override
	public Personne patchPersonne(PersonneCommand personneCommand) {
		Personne personne = iPersonneRepository.findById(personneCommand.getIdCommand()).get();
		if (personneCommand.getNomCommand()!=null) {
			personne.setNom(personneCommand.getNomCommand());
		}
		if (personneCommand.getPrenomCommand()!=null) {
			personne.setPrenom(personneCommand.getPrenomCommand());
		}
		if(personneCommand.getPrenomCommand()!=null && personneCommand.getNomCommand()!=null) {
			List<Adresse> list1 = new ArrayList<Adresse>();
			for(AdresseCommand adresseCommand : personneCommand.getAdressesCommand()) {
				list1.add(iAdresseService.patchAdresse(adresseCommand));
			}
			personne.setAdresses(list1);
		}
		return iPersonneRepository.save(personne);
	}

	
	
	
}
