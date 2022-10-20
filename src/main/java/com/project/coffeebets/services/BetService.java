package com.project.coffeebets.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.coffeebets.models.Bet;
import com.project.coffeebets.models.User;
import com.project.coffeebets.repositories.BetRepository;



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
	
	
	
	public Integer userProfit(Long id) {
		Integer profit = betRepo.userProfit(id);
		return profit; 
	}
	
	
	public Integer userTotalBet(Long id) {
		Integer userBet = betRepo.userTotalBet(id);
		return userBet; 
	}
	
	public Integer TotalBet() {
		Integer totalBet = betRepo.totalBet();
		return totalBet; 
	}
	
	public Integer TotalProfit() {
		Integer totalProfit = betRepo.totalProfit();
		return totalProfit; 
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