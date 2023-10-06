package com.crud.model;


import java.sql.Date;

import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	private String username ;
	
	private String password ; 
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateDeNaissance ;
	
	private String gmail ;
	
	  public void setPassword(String plainTextPassword) {
	        String hashedPassword = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	        this.password = hashedPassword;
	    }
	  
}
