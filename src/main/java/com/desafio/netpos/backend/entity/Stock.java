package com.desafio.netpos.backend.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Preenchimento obrigatório.")
	@Max(1000)
	@Min(0)
	private int quantity;

}
