package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crud.command.ConnexionCommand;
import com.crud.mapper.IConnexionMapper;
import com.crud.model.Connexion;
import com.crud.model.Personne;
import com.crud.repository.IConnexionRepository;
import com.crud.repository.IPersonneRepository;
import com.crud.representation.ConnexionRepresentation;

@Service
public class ConnexionServiceImpl implements IConnexionService {

	@Autowired
	IConnexionRepository iConnexionRepository ;
	
	@Autowired
	IPersonneRepository iPersonneRepository ;
	
	
	@Autowired
	IPersonneService iPersonneService ;
	
	@Autowired
	IConnexionMapper iConnexionMapper ;
	
	
	@Override
	public Connexion checkConnexion(ConnexionCommand connexionCommand) {
		List <Connexion> connexions = iConnexionRepository.findAll();
    	for(Connexion connexion : connexions) {
        if (connexion.getUsername().equals(connexionCommand.getUsernameCommand()) && connexion.getPassword().equals(connexionCommand.getPasswordCommand())) 
            return connexion;
    	}
    	return null;
	}



	@Override
	public Page<ConnexionRepresentation> getAllConnexions(int page, int size, String columnSort) {
		Sort sort = Sort.by(Sort.Order.asc(columnSort));
		PageRequest pageable = PageRequest.of(page -1, size,sort);
		Page <Connexion> connexionPage = iConnexionRepository.findAll(pageable);
		Page<ConnexionRepresentation> connexionRepresentationPage = connexionPage.map(connexion -> iConnexionMapper.convertEntityToRepresentation(connexion));
		return connexionRepresentationPage;
	}



	@Override
	public void viderConnexion(int id) {
		
		List<Personne> personnes = iPersonneRepository.findAllByConnexionId(id);
		for (Personne personne : personnes) {
			iPersonneService.deletePersonne(personne.getId());
		}		
	}



	@Override
	public Connexion createConnexion(ConnexionCommand connexionCommand) {
		Connexion connexion = iConnexionMapper.convertCommandToEntity(connexionCommand);
		return iConnexionRepository.save(connexion);
	}

}
