package com.project.cofeebets.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cofeebets.models.Bet;



@Repository
public interface BetRepository extends CrudRepository<Bet, Long> {
	Optional<Bet> findById(int id);

}
