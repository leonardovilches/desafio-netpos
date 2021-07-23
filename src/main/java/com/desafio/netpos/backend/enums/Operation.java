package com.desafio.netpos.backend.enums;

public enum Operation {
	ADD,
	REMOVE,
	SET;
	
//	private int cod;
	private String description;

//	private Operation(int cod, String descricao) {
//		this.cod = cod;
//		this.descricao = descricao;
//	}
//
//	public int getCod() {
//		return cod;
//	}
//
	public String getDescription() {
		return description;
	}
//	
//	public static Operation toEnum(Integer cod) {
//		if (cod == null) {
//			return null;
//		}
//		
//		for(Operation x : Operation.values()) {
//			if(cod.equals(x.getCod())) {
//				return x;
//			}
//		}
//		
//		throw new IllegalArgumentException("Id Inválido: " + cod);
//	}
}
