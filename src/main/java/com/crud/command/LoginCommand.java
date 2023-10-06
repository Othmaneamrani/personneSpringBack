package com.crud.command;

import java.sql.Date;

import org.mindrot.jbcrypt.BCrypt;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class LoginCommand {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommand;
	
	private String usernameCommand ;
	
	private String passwordCommand ; 
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateDeNaissanceCommand ;
	
	private String gmailCommand ;
	
	
    public void setPasswordCommand(String plainTextPassword) {
        String hashedPassword = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
        this.passwordCommand = hashedPassword;
    }

    public boolean checkPasswordCommand(String plainTextPassword) {
        return BCrypt.checkpw(plainTextPassword, this.passwordCommand);
    }
}
