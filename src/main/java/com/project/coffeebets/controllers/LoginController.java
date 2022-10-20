package com.project.coffeebets.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.coffeebets.models.Game;
import com.project.coffeebets.models.LoginUser;
import com.project.coffeebets.models.User;
import com.project.coffeebets.models.Wallet;
import com.project.coffeebets.services.BetService;
import com.project.coffeebets.services.UserService;
import com.project.coffeebets.services.WalletService;

@Controller
public class LoginController {
	
	public final UserService userServ; 
	public final WalletService walletServ;
	public final BetService betServ; 
	public LoginController(UserService userServ, WalletService walletServ, BetService betServ) {
		this.userServ = userServ;
		this.walletServ = walletServ; 
		this.betServ = betServ;
	}
	

	
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}

	@GetMapping("/patstest")
	public String test() {
		return "creators.jsp";
	}

	
	@GetMapping("/login")
	public String login(@ModelAttribute User user, @ModelAttribute LoginUser loginUser) {
		return "/loginReg/login.jsp";
	}
	
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("user", new User());
			return "/loginReg/login.jsp";
		}
		
		User foundUser = userServ.login(loginUser, result);
		if(foundUser == null) {
			model.addAttribute("user", new User());
			return "/loginReg/login.jsp";	
		}
		
		session.setAttribute("user_id", foundUser.getId());

		
		return "redirect:/dashboard"; 
	}
	
	
	@GetMapping("/register")
	public String register(@ModelAttribute User user, @ModelAttribute LoginUser loginUser) {
		return "/loginReg/registration.jsp";
	}
	
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		
		if(userServ.getUser(user.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email already registered");
		}
		
		if(!user.getPassword().equals(user.getConfirm())) {
			result.rejectValue("password", "Match", "Passwords don't match!");
			
		}
		if(result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			
			return "/loginReg/registration.jsp";
		}
		User createdUser = userServ.registerUser(user);
		session.setAttribute("user_id", createdUser.getId());
		Wallet newWallet = new Wallet(); 
		newWallet.setUser(createdUser);
		walletServ.addWallet(newWallet);
		return "redirect:/dashboard";

	}
	
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session, @ModelAttribute("game") Game game){
		if(session.getAttribute("user_id") == null) {
			return "redirect:/login";
		}
		Long id = (Long) session.getAttribute("user_id");
		User user = userServ.getUserById(id);
		Integer coffeeBet = betServ.TotalBet();
		Integer coffeeProfit = betServ.TotalProfit();
		model.addAttribute("recentBets", betServ.getDashBets());
		model.addAttribute(user);
		model.addAttribute(coffeeProfit);
		model.addAttribute(coffeeBet);
		return "dashboard.jsp";
		
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		// Set userId to null and redirect to login/register page
		session.setAttribute("user_id", null);
	    return "redirect:/";
	}
	
	@GetMapping("user/stats/{id}")
	public String statistics(@PathVariable("id") Long id, Model model, HttpSession session){
		Integer winnings = betServ.userProfit(id);
		Integer totalBet = betServ.userTotalBet(id);
		model.addAttribute("winnings", winnings);
		model.addAttribute("totalBet", totalBet);
		Long user_id = (Long) session.getAttribute("user_id");
		User user = userServ.getUserById(user_id);
		model.addAttribute(user);
		return "/loginReg/stats.jsp";
		
	}

}
