package com.project.cofeebets.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cofeebets.models.Wallet;



@Repository
public interface WalletRepository extends CrudRepository<Wallet, Long> {
	Optional<Wallet> findById(String name);
	Optional<Wallet> findByUserId(Long id);

}
