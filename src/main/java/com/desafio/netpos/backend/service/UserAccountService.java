package com.desafio.netpos.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.netpos.backend.dto.UserAccountDTO;
import com.desafio.netpos.backend.entity.UserAccount;
import com.desafio.netpos.backend.repository.UserAccountRepository;
import com.desafio.netpos.backend.request.CreateUserAccountRequest;
import com.desafio.netpos.backend.service.exceptions.ObjectNotFoundException;


@Service
public class UserAccountService {
	
	@Autowired
	UserAccountRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public UserAccount insert(CreateUserAccountRequest request) {
		UserAccount user = fromRequest(request);
		user.setId(null);
		return userRepository.save(user);
	}
	
	public UserAccount find(String id) throws ObjectNotFoundException {		
		Optional<UserAccount> user = userRepository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException(
				"Usuário não encontrado"));
	}
	
	public List<UserAccount> findAll(String name) {
		if(name != null) {
			return userRepository.findByName(name);			
		}else {
			return userRepository.findAll();
		}
	}
	
	public void delete(String id) {
		find(id);
		userRepository.deleteById(id);			
	}
	
	public UserAccount fromDTO(UserAccountDTO objDto) {
		UserAccount user = new UserAccount(null, objDto.getEmail(), objDto.getFullName(), pe.encode(objDto.getPassword()));		
		return user;
	}

	public UserAccount fromRequest(CreateUserAccountRequest request) {
		UserAccount userAccount = new UserAccount();
		userAccount.setEmail(request.getEmail());
		userAccount.setFullName(request.getFullName());
		userAccount.setPassword(pe.encode(request.getPassword()));
		return userAccount;
	}
	
}
