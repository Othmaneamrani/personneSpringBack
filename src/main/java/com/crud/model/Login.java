package com.crud.model;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "login")
public class Login {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
	private Connexion connexion ;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateDeNaissance ;
	
	private String gmail ;
	  
}
