package com.crud.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "personne")
public class Personne {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String nom ;
	
	private String prenom ;
	
	@ManyToOne
	@JoinColumn(name = "connexion_id")
	@JsonIgnore
	private Connexion connexion ;
	
    @OneToMany(mappedBy = "personne", cascade = CascadeType.ALL)
	private List<Adresse> adresses;
    
    private Boolean list ;
    
    private Boolean epingle ;
    
}
