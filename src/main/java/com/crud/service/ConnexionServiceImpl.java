package com.crud.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crud.command.ConnexionCommand;
import com.crud.command.PasswordCommand;
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
        if (connexion.getUsername().equals(connexionCommand.getUsernameCommand()) &&  BCrypt.checkpw(connexionCommand.getPasswordCommand(), connexion.getPassword()) )
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



	@Override
	public String changeUsername( int id ,String usernameCommand) {
		Connexion connexion = iConnexionRepository.findById(id).get();
		List<Connexion> connexions = iConnexionRepository.findAll();
		if(connexion.getUsername().equals(usernameCommand)) {
			return "deja";
		}
		for(Connexion con : connexions) {
			if(con.getUsername().equals(usernameCommand) ) {
				return "non";
			}
		}
		connexion.setUsername(usernameCommand);
		iConnexionRepository.save(connexion);
		return usernameCommand;
	}
	
	
	@Override
	public String changePassword( int id ,PasswordCommand passwordCommand) {
		Connexion connexion = iConnexionRepository.findById(id).get();

        if(!BCrypt.checkpw(passwordCommand.getPasswordCommand(), connexion.getPassword())) {
        	return "incompatibles";
        }else if(!passwordCommand.getNewPasswordCommand().matches(".*\\d.*") || !passwordCommand.getNewPasswordCommand().matches(".*[A-Z].*") || passwordCommand.getNewPasswordCommand().length() < 6 ) {
        	return "faible";
        }else if(passwordCommand.getNewPasswordCommand().equals(passwordCommand.getPasswordCommand())) {
        	return "aucun";
        }else {
    		connexion.setPassword(passwordCommand.getNewPasswordCommand());
    		iConnexionRepository.save(connexion);
    		return "ok";
        }
	}

	
}
