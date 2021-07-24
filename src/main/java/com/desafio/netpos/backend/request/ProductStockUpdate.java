package com.desafio.netpos.backend.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.desafio.netpos.backend.enums.Operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductStockUpdate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Preenchimento obrigatório.")
	private Operation operation;
	@NotNull(message = "Preenchimento obrigatório.")
	private Integer quantity;

}
