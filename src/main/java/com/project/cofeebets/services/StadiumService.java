package com.project.cofeebets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cofeebets.models.Game;
import com.project.cofeebets.models.Stadium;
import com.project.cofeebets.repositories.StadiumRepository;

@Service
public class StadiumService {
    
	public final StadiumRepository stadiumRepo;
	
	public StadiumService(StadiumRepository stadiumRepo) {
		this.stadiumRepo = stadiumRepo; 
	}
	
	
	public Stadium getOne(Long id) {
		Optional<Stadium> potentialStadium = stadiumRepo.findById(id); 
		return potentialStadium.isPresent() ? potentialStadium.get() : null; 
	}
	
	
	public List<Stadium> allStadiums() {
		return (List<Stadium>) stadiumRepo.findAll();
	}
		

	public Stadium addStadium(Stadium stadium) {
		return stadiumRepo.save(stadium); 
	}
	
	public Stadium updateStadium(Stadium stadium) {
		return stadiumRepo.save(stadium); 
	}
	
	public void delete(Long id) {
		stadiumRepo.deleteById(id);	
	}
	
	public Stadium findGame(Long id) {
		Optional<Stadium> potentialStadium = stadiumRepo.findById(id); 
		return potentialStadium.isPresent() ? potentialStadium.get() : null; 
	}


}