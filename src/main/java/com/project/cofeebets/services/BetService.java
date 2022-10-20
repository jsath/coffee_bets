package com.project.cofeebets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cofeebets.models.Bet;
import com.project.cofeebets.models.User;
import com.project.cofeebets.repositories.BetRepository;



@Service
public class BetService {
    
	public final BetRepository betRepo;
	
	public BetService(BetRepository betRepo) {
		this.betRepo = betRepo; 
	}
	
	
	public Bet getOne(Long id) {
		Optional<Bet> potentialBet = betRepo.findById(id); 
		return potentialBet.isPresent() ? potentialBet.get() : null; 
	}
	
	
	
	public List<Bet> getAll() {
		return (List<Bet>) betRepo.findAll();
	}
	
	public List<Bet> getUserBets(Long Id) {
		return (List<Bet>) betRepo.getUserBets(Id);
	}
	
	public List<Bet> getDashBets() {
		return (List<Bet>) betRepo.getdashBets();
	}
		

	public Bet addBet(Bet bet) {
		return betRepo.save(bet); 
	}
	
	public Bet updateBet(Bet bet) {
		return betRepo.save(bet); 
	}
	
	public void delete(Long id) {
		betRepo.deleteById(id);	
	}
	
	public Bet findBet(Long id) {
		Optional<Bet> potentialBet = betRepo.findById(id); 
		return potentialBet.isPresent() ? potentialBet.get() : null; 
	}
	
	
    public Integer getPayout(String team, Long apiId, Long user_id) {
		Integer sum = betRepo.findBetsBy(team, apiId, user_id);
		return sum;
    }


}