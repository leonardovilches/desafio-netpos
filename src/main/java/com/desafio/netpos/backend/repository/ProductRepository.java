package com.desafio.netpos.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.netpos.backend.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
	
	@Query("SELECT product FROM Product product WHERE lower(product.name) like lower(concat('%', :filter,'%')) OR lower(product.code) LIKE lower(concat('%', :filter,'%')) ")
	List<Product> findByFilter(@Param("filter") String filter, Sort sort);
	
	@Query("SELECT product FROM Product product INNER JOIN product.users user "
			+ " WHERE lower(product.name) like lower(concat('%', :filter,'%')) OR lower(product.code) LIKE lower(concat('%', :filter,'%')) "
			+ "AND user.id = :userId  ")
	List<Product> findByUserIdAndFilter(@Param("userId") String userId, @Param("filter") String filter, Sort sort);
	
	@Query("SELECT product FROM Product product INNER JOIN product.users user "
			+ " WHERE user.id = :userId  ")
	List<Product> findAllByUserId(@Param("userId") String userId, Sort sort);
	
	@Query("SELECT product FROM Product product INNER JOIN product.users user "
			+ " WHERE user.id = :userId and product.id = :productId")
	Optional<Product> findByUserIdAndProductId(@Param("userId") String userId, @Param("productId") String productId);
}
