package com.desafio.netpos.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.netpos.backend.entity.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String>{

	@Query(value = "select u from UserAccount u where u.fullName like %:name% ORDER BY u.fullName")
	List<UserAccount> findByName(@Param("name") String name);
	
	UserAccount findByEmail(@Param("email") String email);
}
