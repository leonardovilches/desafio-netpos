package com.desafio.netpos.backend.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.netpos.backend.entity.Product;
import com.desafio.netpos.backend.entity.UserAccount;
import com.desafio.netpos.backend.repository.ProductRepository;
import com.desafio.netpos.backend.repository.UserAccountRepository;

@Service
public class DBService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UserAccountRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void instantiateTestDatabase() {
		UserAccount user1 = new UserAccount(null, "leo@gmail.com", "leonardo", pe.encode("1234"));
		UserAccount user2 = new UserAccount(null, "cayo@gmail.com", "cayo", pe.encode("1234"));
		UserAccount user3 = new UserAccount(null, "vinicius@gmail", "vinicius", pe.encode("1234"));
		
		Product p1 = new Product(null, "KB1", "Kibon 1", 5.0);
		Product p2 = new Product(null, "KB2", "Kibon 2", 6.0);
		Product p3 = new Product(null, "KB3", "Kibon 3", 7.0);
		
		Product p4 = new Product(null, "BOLO1", "Bolo 1", 10.0);
		Product p5 = new Product(null, "BOLO2", "Bolo 2", 15.0);
		Product p6 = new Product(null, "BOLO3", "Bolo 3", 20.0);
		
		user1.getProducts().addAll(Arrays.asList(p1, p2));
		user2.getProducts().addAll(Arrays.asList(p3, p4));
		user3.getProducts().addAll(Arrays.asList(p5, p6));
		
		p1.getUsers().addAll(Arrays.asList(user1));
		p2.getUsers().addAll(Arrays.asList(user1));
		p3.getUsers().addAll(Arrays.asList(user2));
		p4.getUsers().addAll(Arrays.asList(user2));	
		p5.getUsers().addAll(Arrays.asList(user3));
		p6.getUsers().addAll(Arrays.asList(user3));	
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));
	}
}
