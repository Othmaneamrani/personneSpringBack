package com.crud.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.crud.command.AdresseCommand;
import com.crud.mapper.IAdresseMapper;
import com.crud.model.Adresse;
import com.crud.repository.IAdresseRepository;
import com.crud.representation.AdresseRepresentation;

@Service
public class AdresseServiceImpl implements IAdresseService {

	@Autowired
	private IAdresseRepository iAdresseRepository;

	@Autowired
	private IAdresseMapper iAdresseMapper;
	

//	@Override
//	public List<AdresseRepresentation> getAllAdresses() {	
//		return iAdresseMapper.convertListEntityToListRepresentation(iAdresseRepository.findAll());
//	}
	
	@Override
	public Page<AdresseRepresentation> getAllAdresses(int page, int size , String columnSort) {
		Sort sort = Sort.by(Sort.Order.asc(columnSort)) ; 
		PageRequest pageable = PageRequest.of(page-1, size, sort );
	    Page<Adresse> adressePage = iAdresseRepository.findAll(pageable);
	    Page<AdresseRepresentation> adresseRepresentationPage = adressePage.map(adresse -> iAdresseMapper.convertEntityToRepresentation(adresse));
	    return adresseRepresentationPage;
	}

	
	
	
	
	
	
	@Override
	public AdresseRepresentation getAdresseById(int id) {
		AdresseRepresentation adresseRepresentation = iAdresseMapper.convertEntityToRepresentation(iAdresseRepository.findById(id).get());
		return adresseRepresentation;
	}

	
	
	
	
	
	@Override
	public Adresse createAdresse(AdresseCommand adresseCommand) {
		Adresse adresse = iAdresseMapper.convertCommandToEntity(adresseCommand);
		return iAdresseRepository.save(adresse);
	}

	
	
	
	
	
	
	@Override
	public Adresse updateAdresse(AdresseCommand adresseCommand) {
		Adresse adresse = iAdresseMapper.convertCommandToEntity(adresseCommand);
		Adresse adresseKey = iAdresseRepository.findById(adresseCommand.getIdCommand()).get();
		adresse.setPersonne(adresseKey.getPersonne());
		return iAdresseRepository.save(adresse);
	}
	
	
	
	
	
	
	@Override
	public void deleteAdresse(int id) {
		iAdresseRepository.deleteById(id);	
	}

	
	
	
	
	@Override
	public Adresse patchAdresse(AdresseCommand adresseCommand) {

		Adresse adresse = iAdresseRepository.findById(adresseCommand.getIdCommand()).get();
		if (adresseCommand.getRueCommand() != null) {
	        adresse.setRue(adresseCommand.getRueCommand());
	    }
		if (adresseCommand.getNumeroMaisonCommand() != null) {
		        adresse.setNumeroMaison(adresseCommand.getNumeroMaisonCommand());
		    }
		return iAdresseRepository.save(adresse);
	}
	
	
	
}
	
