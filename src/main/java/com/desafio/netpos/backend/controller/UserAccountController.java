package com.desafio.netpos.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.netpos.backend.entity.UserAccount;
import com.desafio.netpos.backend.request.CreateUserAccountRequest;
import com.desafio.netpos.backend.service.UserAccountService;
import com.desafio.netpos.backend.service.exceptions.ObjectNotFoundException;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/users")
@Log4j2
public class UserAccountController {

	@Autowired
	private UserAccountService userService;
	
	@PostMapping(produces = "application/json; charset=UTF-8")
	public ResponseEntity<Object> insert(@Valid @RequestBody CreateUserAccountRequest request) {
		log.info(">>>>> UserAccountController >> insert: START");
		
		UserAccount user = userService.insert(request);

		log.info(">>>>> UserAccountController >> insert: FINISH");
		
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value="/{id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<UserAccount> find(@PathVariable String id) throws ObjectNotFoundException {
		log.info(">>>>> UserAccountController >> find{id}: START");
		
		UserAccount obj = userService.find(id);
		
		log.info(">>>>> UserAccountController >> find{id}: FINISH");
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<UserAccount>> findAll(@RequestParam(required = false) String name) throws ObjectNotFoundException {
		log.info(">>>>> UserAccountController >> findAll: START");
		
		List<UserAccount> list = userService.findAll(name);

		log.info(">>>>> UserAccountController >> findAll: FINISH");
		
		return ResponseEntity.ok().body(list);
	}	
}
