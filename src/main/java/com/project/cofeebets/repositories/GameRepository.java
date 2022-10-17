package com.project.cofeebets.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cofeebets.models.Game;



@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	Optional<Game> findById(String name);

}
