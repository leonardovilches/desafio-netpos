package com.desafio.netpos.backend.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateUserAccountRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Email(message = "Email inválido.")
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String fullName;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String password;
}
