package com.project.cofeebets.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.cofeebets.models.Game;
import com.project.cofeebets.models.Stadium;



@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Long> {
	Optional<Stadium> findById(String name);
	
}
