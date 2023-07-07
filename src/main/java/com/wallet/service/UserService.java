package com.wallet.service;

import java.util.Optional;

import com.wallet.entity.Usr;

public interface UserService {

	Usr save(Usr u);

	Optional<Usr> findByEmail(String email);

}
