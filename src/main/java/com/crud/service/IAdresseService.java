package com.crud.service;


import org.springframework.data.domain.Page;

import com.crud.command.AdresseCommand;
import com.crud.model.Adresse;
import com.crud.representation.AdresseRepresentation;


public interface IAdresseService {

//		public List<AdresseRepresentation> getAllAdresses();

	 	public Page<AdresseRepresentation> getAllAdresses(int page,int size, String columnSort);
	 
		public AdresseRepresentation getAdresseById(int id);

		public Adresse createAdresse(AdresseCommand adresseCommand );
		
		public Adresse patchAdresse(AdresseCommand adresseCommand);

		public Adresse updateAdresse(AdresseCommand adresseCommand);

		public void deleteAdresse(int id);

}
