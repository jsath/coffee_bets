package com.project.cofeebets.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.cofeebets.models.Game;
import com.project.cofeebets.models.LoginUser;
import com.project.cofeebets.models.User;
import com.project.cofeebets.models.Wallet;
import com.project.cofeebets.services.BetService;
import com.project.cofeebets.services.UserService;
import com.project.cofeebets.services.WalletService;

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
		model.addAttribute("recentBets", betServ.getDashBets());
		model.addAttribute(user);
		return "dashboard.jsp";
		
	}
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		// Set userId to null and redirect to login/register page
		session.setAttribute("user_id", null);
	    return "redirect:/";
	}

}
