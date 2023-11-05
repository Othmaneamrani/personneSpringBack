package com.crud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crud.command.LoginCommand;
import com.crud.mapper.ILoginMapper;
import com.crud.model.Connexion;
import com.crud.model.Login;
import com.crud.model.Personne;
import com.crud.repository.ILoginRepository;
import com.crud.repository.IPersonneRepository;
import com.crud.representation.ConnexionRepresentation;
import com.crud.representation.LoginRepresentation;


@Service
public class LoginServiceImpl implements ILoginService {
	
	@Autowired
	private IPersonneRepository iPersonneRepository ;
	
	@Autowired
	private IPersonneService iPersonneService ;

	@Autowired
	private ILoginRepository iLoginRepository;
	
	@Autowired
	private ILoginMapper iLoginMapper;
	

	@Override
	public Page<LoginRepresentation> getAllLogins(int page, int size, String columnSort) {
		Sort sort = Sort.by(Sort.Order.asc(columnSort));
		PageRequest pageable = PageRequest.of(page-1 ,size,sort);
		Page<Login> loginPage = iLoginRepository.findAll(pageable);
		Page <LoginRepresentation> loginRepresentationPage = loginPage.map(login -> iLoginMapper.convertEntityToRepresentation(login));
		return loginRepresentationPage;
	}

	
	
	@Override
	public Login createLogin(LoginCommand loginCommand) {
		Login login = iLoginMapper.convertCommandToEntity(loginCommand);
		Connexion connexion = login.getConnexion();
		connexion.setLogin(login);
		iLoginRepository.save(login);
		return login ;
	}
	
	@Override
	public void supprimerLogin(int id ){
		Connexion connexion = iLoginRepository.findById(id).getConnexion();
		List<Personne> personnes = iPersonneRepository.findAllByConnexionId(connexion.getId());
		for (Personne personne : personnes) {
			iPersonneService.deletePersonne(personne.getId());
		}
		iLoginRepository.deleteById(id);
	}



	@Override
	public Login signUp(LoginCommand loginCommand) {
		  List <Login> logins = iLoginRepository.findAll();
	    	for(Login login : logins) {
	        if (login.getConnexion().getUsername().equals(loginCommand.getConnexionCommand().getUsernameCommand())) {
	        	login.setGmail("username");
	            return login;
	        }
	        if (login.getGmail().equals(loginCommand.getGmailCommand())) {
	        	login.setGmail("gmail");
	            return login;
	        }
	        if ( (!loginCommand.getConnexionCommand().getPasswordCommand().matches(".*\\d.*") || !loginCommand.getConnexionCommand().getPasswordCommand().matches(".*[!@#éè\\$%\\^&\\*\\(\\)_\\+\\-=\\[\\]\\{\\};:'\",<>\\./?\\\\|`~].*") ) || !loginCommand.getConnexionCommand().getPasswordCommand().matches(".*[A-Z].*") || loginCommand.getConnexionCommand().getPasswordCommand().length() < 6  || loginCommand.getConnexionCommand().getPasswordCommand().matches(".*\\s.*") ) {
	        	login.setGmail("mdp");
	        	return login;
	        }
	    	}
	    	Login login =  iLoginMapper.convertCommandToEntity(loginCommand);
			Connexion connexion = login.getConnexion();
			connexion.setLogin(login);
			iLoginRepository.save(login);
		return login;
	}

	

	@Override
	public List<LoginRepresentation> getList() {
		return iLoginMapper.convertListEntityToListRepresentation(iLoginRepository.findAll());
	}
	
	

}
	
	

