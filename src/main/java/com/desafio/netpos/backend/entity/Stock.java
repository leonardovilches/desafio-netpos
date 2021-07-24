package com.desafio.netpos.backend.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;

	@Size(min = 0, max = 1000, message = "Não pode ser maior que 1000")
	private Integer quantity;

}
