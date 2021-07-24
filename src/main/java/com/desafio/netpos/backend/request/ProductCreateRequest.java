package com.desafio.netpos.backend.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.desafio.netpos.backend.entity.Stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String code;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String name;
//	@NotEmpty(message = "Preenchimento obrigatório.")
	private Double price;
//	@NotEmpty(message = "Preenchimento obrigatório.")
	private Stock stock;
}
