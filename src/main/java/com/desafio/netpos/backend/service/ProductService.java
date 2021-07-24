package com.desafio.netpos.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.desafio.netpos.backend.entity.Product;
import com.desafio.netpos.backend.entity.Stock;
import com.desafio.netpos.backend.repository.ProductRepository;
import com.desafio.netpos.backend.request.ProductCreateRequest;
import com.desafio.netpos.backend.request.ProductStockUpdate;
import com.desafio.netpos.backend.request.ProductUpdateRequest;
import com.desafio.netpos.backend.service.exceptions.ObjectNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product insert(Product product) {
		product.setId(null);
		if(product.getStock() == null) {
			product.setStock(new Stock(0));
		}
		return productRepository.save(product);
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
		product.setPrice(request.getPrice());			
		return productRepository.save(product);
	}
	
	public void delete(String id) {
		find(id);
		productRepository.deleteById(id);			
	}

	public Product find(String id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrado"));
	}
	
	public List<Product> findAll(String filter, String order, String direction) {
		Sort sort = Sort.by(
			    direction.equals("ASC") ? Sort.Order.asc(order) : Sort.Order.desc(order));
		if(filter != null) {
			return productRepository.findByFilter(filter, sort);			
		}else {
			return productRepository.findAll(sort);		
		}
	}
	
	public void updateStock(ProductStockUpdate productStock, String productId) {
		Product product = find(productId);
		Stock stock = product.getStock();
		switch (productStock.getOperation()) {
		case ADD:
			stock.setQuantity(stock.getQuantity() + productStock.getQuantity());
			break;
		case REMOVE:
			stock.setQuantity(stock.getQuantity() - productStock.getQuantity());
			break;
		default:
			stock.setQuantity(productStock.getQuantity());
			break;
		}
		product.setStock(stock);
		productRepository.save(product);
		
	}
}
