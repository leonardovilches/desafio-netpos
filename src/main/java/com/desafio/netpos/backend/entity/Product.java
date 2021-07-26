package com.desafio.netpos.backend.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(exclude = "users")
@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(unique = true)
	private String code;
	private String name;
	private Double price;

	private Stock stock;
	
	@JsonIgnore
	@ManyToMany()
	@JoinTable(name = "USER_PRODUCT",joinColumns = @JoinColumn(name = "product_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<UserAccount> users = new ArrayList<>();

	public Product(String id, String code, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
