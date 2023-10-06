package com.crud.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "adresse")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String rue;

	private String numeroMaison;

	@ManyToOne
	@JoinColumn(name = "personne_id")
	@JsonIgnore
	private Personne personne;
}
