package com.desafio.netpos.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.desafio.netpos.backend.entity.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String fullName;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Email(message = "Email inválido.")
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String password;
	
	public UserAccountDTO(UserAccount obj) {
		id = obj.getId();
		fullName = obj.getFullName();
		email = obj.getEmail();
	}

}
