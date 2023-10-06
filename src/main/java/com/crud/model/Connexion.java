package com.crud.model;



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
@Entity(name = "connexion")

public class Connexion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String username ;
	
	private String password ; 
	
	
}
