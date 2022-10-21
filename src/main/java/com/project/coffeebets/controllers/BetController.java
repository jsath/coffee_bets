package com.project.coffeebets.controllers;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.coffeebets.models.Bet;
import com.project.coffeebets.models.Game;
import com.project.coffeebets.models.User;
import com.project.coffeebets.models.Wallet;
import com.project.coffeebets.services.BetService;
import com.project.coffeebets.services.GameService;
import com.project.coffeebets.services.UserService;
import com.project.coffeebets.services.WalletService;



@Controller
@RequestMapping("/bets")
public class BetController {
	
	public final UserService userServ; 
	public final BetService betServ; 
	public final GameService gameServ;
	public final WalletService walletServ; 
	public BetController(UserService userServ,BetService betServ,GameService gameServ, WalletService walletServ) {
		this.userServ = userServ;
		this.betServ = betServ;
		this.gameServ = gameServ;
		this.walletServ = walletServ;
	}
	
	
	@GetMapping("/leaderboard")
	public String leaderboard(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		Long id = (Long) session.getAttribute("user_id");
		model.addAttribute(userServ.getUserById(id));
		
		List <User> users = userServ.leaderboard();
		model.addAttribute("users", users);
		
		Double winnings = betServ.TotalProfit();
		Double wagered = betServ.TotalBet();
		model.addAttribute("winnings", winnings);
		model.addAttribute("wagered",wagered);
		return "leaderboard.jsp";
	}
	
	// Create 
	
	@GetMapping("/addbet/{id}")
	public String add(@ModelAttribute("bet") Bet bet, @PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Game game = gameServ.getGameByApiId(id);
		model.addAttribute("id", id);
		model.addAttribute(game);
		session.setAttribute("gameId", id);
		Long user_id = (Long) session.getAttribute("user_id");
		Wallet wallet = walletServ.getWalletByUserId(user_id);
		model.addAttribute(wallet);
		
		User user = userServ.getUserById(user_id);
		model.addAttribute(user);
		
		return "/bets/addBet.jsp";
	}
	
	
	@PostMapping("/addbet")
	public String add(@Valid @ModelAttribute("bet") Bet bet, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "redirect:/bets/addbet/" + session.getAttribute("gameId");
		}else {
			betServ.addBet(bet);
			Wallet updatedWallet = walletServ.getWalletById(bet.getUser().getWallet().getId());
			updatedWallet.setCoffeebeans(updatedWallet.getCoffeebeans() - bet.getAmount());
			walletServ.updateWallet(updatedWallet);
		
			return "redirect:/dashboard";
		}
	}
	
	
	@GetMapping("/activebets")
	public String activeBets(@ModelAttribute("game") Game game, HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long user_id = (Long) (session.getAttribute("user_id"));
		User user = userServ.getUserById(user_id);
		Wallet wallet = walletServ.getWalletByUserId(user_id);
		model.addAttribute(user);
		model.addAttribute(wallet);
		model.addAttribute("bets", betServ.getUserBets(user_id));
		return "bets/activebets.jsp";
	}
	
	

	@GetMapping("/mybets")
	public String allBets(HttpSession session, Model model) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long user_id = (Long) (session.getAttribute("user_id"));
		User user = userServ.getUserById(user_id);
		model.addAttribute(user);
		List<Bet> bets = betServ.getAllOrder(user_id);
		model.addAttribute("bets",bets);
		return "bets/mybets.jsp";
	}
	// Get All
	
	
	@PutMapping("/close/bet/{id}")
	public String close(@PathVariable("id") Long id) {
		Bet checkBet = betServ.getOne(id);
		Game checkGame = gameServ.getOne(checkBet.getGame().getId());
		Wallet updatedWallet = checkBet.getUser().getWallet();
		
		String userTeam = checkBet.getTeam();
		String gameWinner = checkGame.getWinner();

		if(userTeam.contains(gameWinner)) {
			
			//Updating wallet with payout if user bet on winner
			updatedWallet.setCoffeebeans(updatedWallet.getCoffeebeans() + checkBet.getPayout());
			walletServ.updateWallet(updatedWallet);
			
			//closing status of bet
			checkBet.setStatus(1);
			betServ.updateBet(checkBet);
			
			return "redirect:/bets/activebets";
		}else {
			
			checkBet.setStatus(1);
			betServ.updateBet(checkBet);
			return "redirect:/bets/activebets";
			
		}
		
	}
	
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Bet bet = betServ.getOne(id);
		User user = userServ.getUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("bet", bet);
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "view.jsp"; 
	}
	
	
	
	//update
	
	
	@GetMapping("/edit/{id}")
	public String viewEdit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Bet bet = betServ.getOne(id);
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("bet", bet);
		return "editbet.jsp"; 
	}
	
	
	@PutMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("bet") Bet bet, BindingResult result) {
		System.out.println(result);
		if(result.hasErrors()) {
			return "/bets/activebets.jsp";
		}
		betServ.updateBet(bet);
		return "redirect:/dashboard";
	}
	
	
	//Delete
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		betServ.delete(id);
		return "redirect:/dashboard";
	}
	
	// Get out 
	
		@GetMapping("/notice")
		public String notice() {
			return "notice.jsp";
		}

}
