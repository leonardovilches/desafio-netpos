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
import org.springframework.web.bind.annotation.RestController;

import com.desafio.netpos.backend.entity.UserAccount;
import com.desafio.netpos.backend.service.UserAccountService;
import com.desafio.netpos.backend.service.exceptions.ObjectNotFoundException;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/users")
@Log4j2
public class UserAccountController {

	@Autowired
	private UserAccountService userService;
	
	@PostMapping
	public ResponseEntity<Object> insert(@Valid @RequestBody UserAccount user) {
		log.info(">>>>> UserAccountController >> insert: START");
		
		user = userService.insert(user);
		
//		URI uri = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(user.getId()).toUri();
		
		log.info(">>>>> UserAccountController >> insert: FINISH");
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserAccount> find(@PathVariable String id) throws ObjectNotFoundException {
		log.info(">>>>> UserAccountController >> find{id}: START");
		
		UserAccount obj = userService.find(id);
		
		log.info(">>>>> UserAccountController >> find{id}: FINISH");
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<UserAccount>> findAll() throws ObjectNotFoundException {
		log.info(">>>>> UserAccountController >> findAll: START");
		
		List<UserAccount> list = userService.findAll();
//		List<UserAccountDTO> listDto = list.stream().map(obj -> new UserAccountDTO(obj)).collect(Collectors.toList());
		
		log.info(">>>>> UserAccountController >> findAll: FINISH");
		
		return ResponseEntity.ok().body(list);
	}
	
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete(@PathVariable String id) {
//		userService.delete(id);
//		return ResponseEntity.noContent().build();
//	}
	
//	@PutMapping(value = "/account/{id}")
//	public ResponseEntity<Void> update(@Valid @RequestBody UserAccountDTO objDto, @PathVariable String id) {
//		UserAccount obj = userService.basicDataFromDTO(objDto);
//		obj.setId(id);
//		obj = userService.updateBasicData(obj);
//		return ResponseEntity.noContent().build();
//	}
	
}
