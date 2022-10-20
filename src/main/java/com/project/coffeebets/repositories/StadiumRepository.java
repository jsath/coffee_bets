package com.project.coffeebets.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.coffeebets.models.Game;
import com.project.coffeebets.models.Stadium;



@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {
	Optional<Stadium> findById(String name);
	
}
