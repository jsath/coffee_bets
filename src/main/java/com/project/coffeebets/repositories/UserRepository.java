package com.project.coffeebets.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.coffeebets.models.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	
	
	
	

	 @Query(value = "select * from users join wallets on users.id = wallets.user_id ORDER BY coffeebeans desc limit 10", nativeQuery=true)
	 List<User> leaderboard();
	 
	 

	
}