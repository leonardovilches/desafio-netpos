package com.desafio.netpos.backend.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(unique = true)
	private String code;
	private String name;
	@Column(length = 1000)
	private Double price;

	private Stock stock;
	

	public Product(String id, String code, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
