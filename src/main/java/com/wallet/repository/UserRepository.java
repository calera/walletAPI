package com.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wallet.entity.Usr;

public interface UserRepository extends JpaRepository<Usr, Long>{
	
	Optional<Usr> findByEmailEquals(String email);

}
