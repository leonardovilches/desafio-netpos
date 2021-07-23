package com.desafio.netpos.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.netpos.backend.dto.UserAccountDTO;
import com.desafio.netpos.backend.entity.UserAccount;
import com.desafio.netpos.backend.repository.UserAccountRepository;
import com.desafio.netpos.backend.service.exceptions.ObjectNotFoundException;


@Service
public class UserAccountService {
	
	@Autowired
	UserAccountRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public UserAccount insert(UserAccount obj) {
		obj.setId(null);
		obj.setPassword(pe.encode(obj.getPassword()));
		obj = userRepository.save(obj);		
		return obj;
	}
	
	public UserAccount find(String id) throws ObjectNotFoundException {		
		Optional<UserAccount> obj = userRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Usuário não encontrado"));
	}
	
	public void delete(String id) {
		find(id);
		userRepository.deleteById(id);			
	}

	public List<UserAccount> findAll() {
		return userRepository.findAll();
	}
	
	public UserAccount fromDTO(UserAccountDTO objDto) {
		UserAccount user = new UserAccount(null, objDto.getEmail(), objDto.getFullName(), pe.encode(objDto.getPassword()));		
		return user;
	}
	
}
