package com.crud.model;




import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	private String username;
	
	private String password;
	
	@OneToMany(mappedBy = "connexion", cascade = CascadeType.ALL )
	private List<Personne> personnes;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "login_id")
	Login login ;
	
	
    public void setPassword(String password) {
    	String salt = BCrypt.gensalt();

        String hashedPassword = BCrypt.hashpw(password, salt);

        this.password = hashedPassword;
    }
	
}


