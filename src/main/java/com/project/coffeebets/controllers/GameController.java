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
import com.project.coffeebets.models.Stadium;
import com.project.coffeebets.models.User;
import com.project.coffeebets.services.BetService;
import com.project.coffeebets.services.GameService;
import com.project.coffeebets.services.StadiumService;
import com.project.coffeebets.services.UserService;
import com.project.coffeebets.services.WalletService;

@Controller
@RequestMapping("/games")
public class GameController {
	
	public final UserService userServ; 
	public final GameService gameServ; 
	public final StadiumService stadiumServ; 
	public final BetService betServ; 
	public final WalletService walletServ;
	public GameController(UserService userServ,GameService gameServ, StadiumService stadiumServ, BetService betServ, WalletService walletServ) {
		this.userServ = userServ;
		this.gameServ = gameServ;
		this.stadiumServ = stadiumServ;
		this.betServ = betServ; 
		this.walletServ = walletServ; 
	}
	
	
	// Create 
	
	@GetMapping("/addgame")
	public String add(@ModelAttribute("game") Game game) {
		return "/games/addGame.jsp";
	}
	
	
	@PostMapping("/addgame/{apiId}/{stadiumId}/{home}/{away}")
	public String add(@PathVariable("apiId") Long apiId, @PathVariable("stadiumId") Long stadiumId, @PathVariable("home") String home,@PathVariable("away") String away, Game game) {
		game.setApiId(apiId);
		game.setStadium(stadiumServ.getOne(stadiumId));
		game.setHome(home);
		game.setAway(away);
		if(gameServ.getGameByApiId(game.getApiId()) != null ){
			return "redirect:/bets/addbet/" + game.getApiId();
		}
		else {
			gameServ.addGame(game);
			return "redirect:/bets/addbet/" + game.getApiId();
		}
	}
	
	@PostMapping("/addgame")
	public String add(@Valid @ModelAttribute("game") Game game, BindingResult result,Long id) {
		
		if(result.hasErrors()) {
			System.out.println(result);
			return "/games/addGame.jsp";
		}else {
			gameServ.addGame(game);
			return "redirect:/dashboard";
		}
	}
	
		
	
	// Get All 
	
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Game game = gameServ.getOne(id);
		User user = userServ.getUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("game", game);
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "view.jsp"; 
	}
	
	
	
	//update
	
	
	@GetMapping("/edit/{id}")
	public String viewEdit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Game game = gameServ.getOne(id);
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("game", game);
		return "editgame.jsp"; 
	}
	
	
	@PutMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("game") Game game, BindingResult result, HttpSession session) {
		System.out.println(result.getFieldErrors());
		if(result.hasErrors()) {
			return "/bets/activebets.jsp";
		}
		if(gameServ.getGameById(game.getId()).getWinner() != null) {
			return "redirect:/bets/activebets";
		}
		if(game.getWinner() == null) {
			return "redirect:/bets/activebets";
		}
		List<Bet> bets = gameServ.getOne(game.getId()).getBets() ;
		game.setBets(bets);
		gameServ.updateGame(game);
		return "redirect:/dashboard";
	}
	
	
	//Delete
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		gameServ.delete(id);
		return "redirect:/dashboard";
	}
	
	// Get out 
	
		@GetMapping("/notice")
		public String notice() {
			return "notice.jsp";
		}

}
