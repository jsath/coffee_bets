package com.project.coffeebets.controllers;

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

import com.project.coffeebets.models.Game;
import com.project.coffeebets.models.User;
import com.project.coffeebets.models.Wallet;
import com.project.coffeebets.services.UserService;
import com.project.coffeebets.services.WalletService;

@Controller
@RequestMapping("/wallets")
public class WalletController {
	
	public final UserService userServ; 
	public final WalletService walletServ; 
	public WalletController(UserService userServ,WalletService walletServ) {
		this.userServ = userServ;
		this.walletServ = walletServ;
	}
	
	
	// Create 	
		
	
	// Get All 
	
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Wallet wallet = walletServ.getOne(id);
		User user = userServ.getUserById((Long) session.getAttribute("user_id"));
		model.addAttribute("wallet", wallet);
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "view.jsp"; 
	}
	
	
	
	//update
	
	
	@GetMapping("/edit/{id}")
	public String viewEdit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Wallet wallet = walletServ.getOne(id);
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("wallet", wallet);
		return "editwallet.jsp"; 
	}
	
	
	@PutMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("wallet") Wallet wallet, BindingResult result) {
		if(result.hasErrors()) {
			return "editwallet.jsp";
		}
		walletServ.updateWallet(wallet);
		return "redirect:/dashboard";
	}
	
	
	//Delete
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		walletServ.delete(id);
		return "redirect:/dashboard";
	}
	
	// Get out 
	
		@GetMapping("/notice")
		public String notice() {
			return "notice.jsp";
		}

}