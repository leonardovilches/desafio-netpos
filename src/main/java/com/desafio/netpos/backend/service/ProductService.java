package com.desafio.netpos.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.netpos.backend.entity.Product;
import com.desafio.netpos.backend.repository.ProductRepository;
import com.desafio.netpos.backend.request.ProductCreateRequest;
import com.desafio.netpos.backend.request.ProductUpdateRequest;
import com.desafio.netpos.backend.service.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product insert(Product obj) {
		obj.setId(null);
		return productRepository.save(obj);
	}
	
	public Product find(String id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrado"));
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product fromCreateRequest(ProductCreateRequest request) {
		Product product = new Product();
		product.setCode(request.getCode());
		product.setName(request.getName());
		product.setPrice(request.getPrice());
		product.setStock(request.getStock());
		return product;
	}

	public Product update(ProductUpdateRequest request, String id) {
		Product product = find(id);
		
		product.setName(request.getName());
		product.setPrice(request.getPrice() != null ? request.getPrice() : 0L);			
		return productRepository.save(product);
	}
	
	public void delete(String id) {
		find(id);
		productRepository.deleteById(id);			
	}

//	public void updateStock(@Valid ProductStockUpdate productStock, @Valid String productId) {
//		
//		
//	}

//	public Page<Product> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
//		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
//		
//		return productRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);	
//	}
}
