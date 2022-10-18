package com.project.cofeebets.controllers;

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

import com.project.cofeebets.models.Bet;
import com.project.cofeebets.models.Game;
import com.project.cofeebets.models.User;
import com.project.cofeebets.services.BetService;
import com.project.cofeebets.services.GameService;
import com.project.cofeebets.services.UserService;



@Controller
@RequestMapping("/bets")
public class BetController {
	
	public final UserService userServ; 
	public final BetService betServ; 
	public final GameService gameServ;
	public BetController(UserService userServ,BetService betServ,GameService gameServ) {
		this.userServ = userServ;
		this.betServ = betServ;
		this.gameServ = gameServ;
	}
	
	
	// Create 
	
	@GetMapping("/addbet/{id}")
	public String add(@ModelAttribute("bet") Bet bet, @PathVariable("id") Long id, Model model) {
		Game game = gameServ.getGameByApiId(id);
		model.addAttribute("id", id);
		model.addAttribute(game);
		return "/bets/addBet.jsp";
	}
	
	
	@PostMapping("/addbet")
	public String add(@Valid @ModelAttribute("bet") Bet bet, BindingResult result,Long id) {
		if(result.hasErrors()) {
			return "/bets/addbet.jsp";
		}else {
			betServ.addBet(bet);
			return "redirect:/dashboard";
		}
	}
	
		
	
	// Get All 
	
	
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
		if(result.hasErrors()) {
			return "editbet.jsp";
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
