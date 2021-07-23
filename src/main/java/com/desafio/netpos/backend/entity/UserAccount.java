package com.desafio.netpos.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity
public class UserAccount implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Email(message = "Email inválido.")
	@Column(unique = true)
	private String email;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String fullName;
//	@JsonIgnore
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String password;
	
	
	public UserAccount(String id, String email, String fullName){
		this.id = id;
		this.email = email;
		this.fullName = fullName;
	}
}
