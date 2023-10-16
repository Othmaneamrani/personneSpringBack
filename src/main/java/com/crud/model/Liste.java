package com.crud.model;

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
@Entity(name="liste")
public class Liste {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id ;
	 
	@ManyToOne
	@JoinColumn(name="personne_id")
	private Personne personne ;
	
}
