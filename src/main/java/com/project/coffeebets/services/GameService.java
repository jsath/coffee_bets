package com.project.coffeebets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.coffeebets.models.Game;
import com.project.coffeebets.models.User;
import com.project.coffeebets.repositories.GameRepository;

@Service
public class GameService {
    
	public final GameRepository gameRepo;
	
	public GameService(GameRepository gameRepo) {
		this.gameRepo = gameRepo; 
	}
	
	
	public Game getOne(Long id) {
		Optional<Game> potentialGame = gameRepo.findById(id); 
		return potentialGame.isPresent() ? potentialGame.get() : null; 
	}
	
	
	public List<Game> getAll() {
		return (List<Game>) gameRepo.findAll();
	}
	
	public Game getGameById(Long id) {
		Optional<Game> potentialGame = gameRepo.findById(id);
		return potentialGame.isPresent() ? potentialGame.get() : null; 
	}
	
	public Game getGameByApiId(Long id) {
		Optional<Game> potentialGame = gameRepo.findByApiId(id);
		return potentialGame.isPresent() ? potentialGame.get() : null; 
	}
		
		

	public Game addGame(Game game) {
		return gameRepo.save(game); 
	}
	
	public Game updateGame(Game game) {
		return gameRepo.save(game); 
	}
	
	public void delete(Long id) {
		gameRepo.deleteById(id);	
	}
	
	public Game findGame(Long id) {
		Optional<Game> potentialGame = gameRepo.findById(id); 
		return potentialGame.isPresent() ? potentialGame.get() : null; 
	}


}