package com.desafio.netpos.backend.request;

import com.desafio.netpos.backend.entity.Stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

	private String code;
	private String name;
	private Double price;
	private Stock stock;
}
