package com.project.coffeebets.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.coffeebets.models.Game;
import com.project.coffeebets.models.Stadium;



@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
	Optional<Game> findById(String name);
	Optional<Game> findByApiId(Long apiId);
	List<Game> findAllByStadium(Game game);
	Optional<Game> findByStadiumNotContains(Game game);
	
}
