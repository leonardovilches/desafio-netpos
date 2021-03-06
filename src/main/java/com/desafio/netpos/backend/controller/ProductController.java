package com.desafio.netpos.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.netpos.backend.entity.Product;
import com.desafio.netpos.backend.request.ProductCreateRequest;
import com.desafio.netpos.backend.request.ProductStockUpdate;
import com.desafio.netpos.backend.request.ProductUpdateRequest;
import com.desafio.netpos.backend.service.ProductService;
import com.desafio.netpos.backend.service.exceptions.ObjectNotFoundException;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/products")
@Log4j2
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(produces = "application/json; charset=UTF-8")
	public ResponseEntity<Product> insert(@Valid @RequestBody ProductCreateRequest request, @RequestHeader String userId) {
		log.info(">>>>> ProductController >> insert: START");
		
		Product product = productService.insert(request, userId);
		
		log.info(">>>>> ProductController >> insert: FINISH");
		
		return ResponseEntity.ok().body(product);
	}
	
	@PutMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Product> update(@Valid @RequestBody ProductUpdateRequest request, 
			@PathVariable String id, @RequestHeader String userId) {
		log.info(">>>>> ProductController >> update: START");
		
		Product product = productService.update(request, id, userId);
		
		log.info(">>>>> ProductController >> update: FINISH");
		return ResponseEntity.ok().body(product);
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Void> delete(@PathVariable String id, @RequestHeader String userId) {
		
		log.info(">>>>> ProductController >> delete: START");
			
		productService.delete(id, userId);
		
		log.info(">>>>> ProductController >> delete: FINISH");
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/{id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<Product> find(@PathVariable String id, @RequestHeader String userId) {
		Product obj = productService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<Product>> findAll(@RequestHeader String userId, 
			@RequestParam(required = false) String filter,
			@RequestParam(required = false, defaultValue = "code", value = "order") String order,
			@RequestParam(required = false, defaultValue = "ASC", value = "direction") String direction
			) throws ObjectNotFoundException {
		log.info(">>>>> ProductController >> findAll: START");
		
		List<Product> list = productService.findAll(userId, filter, order, direction);
		
		log.info(">>>>> ProductController >> findAll: FINISH");
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value="/{productId}/stock", produces = "application/json; charset=UTF-8")
	public ResponseEntity<ProductStockUpdate> stockUpdate(@Valid @RequestBody ProductStockUpdate productStock, 
				@PathVariable String productId, @RequestHeader String userId) {
		log.info(">>>>> ProductController >> stockUpdate: START");	
		
		productService.updateStock(productStock, productId, userId);
		
		log.info(">>>>> ProductController >> stockUpdate: FINISH");
		return ResponseEntity.noContent().build();
	}

}
