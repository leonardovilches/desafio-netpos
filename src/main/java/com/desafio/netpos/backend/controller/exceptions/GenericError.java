package com.desafio.netpos.backend.controller.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericError implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String message;
}
