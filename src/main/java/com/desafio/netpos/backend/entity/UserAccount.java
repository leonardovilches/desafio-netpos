package com.desafio.netpos.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "products")
@Entity
public class UserAccount implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(unique = true)
	private String email;
	private String fullName;
	private String password;
	
	@JsonIgnore
	@ManyToMany(mappedBy="users")
	private List<Product> products = new ArrayList<>();
	
	
	public UserAccount(String id, String email, String fullName, String password){
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}
	
	public UserAccount(String id, String email, String fullName){
		this.id = id;
		this.email = email;
		this.fullName = fullName;
	}
}
