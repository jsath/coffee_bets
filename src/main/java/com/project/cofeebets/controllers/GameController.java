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

import com.project.cofeebets.models.Game;
import com.project.cofeebets.models.User;
import com.project.cofeebets.services.GameService;
import com.project.cofeebets.services.UserService;

@Controller
@RequestMapping("/games")
public class GameController {
	
	public final UserService userServ; 
	public final GameService gameServ; 
	public GameController(UserService userServ,GameService gameServ) {
		this.userServ = userServ;
		this.gameServ = gameServ;
	}
	
	
	// Create 
	
	@GetMapping("/addgame")
	public String add(@ModelAttribute("game") Game game) {
		return "/games/addGame.jsp";
	}
	
	
	@PostMapping("/addgame")
	public String add(@Valid @ModelAttribute("game") Game game, BindingResult result,Long id) {
		
		if(result.hasErrors()) {
			return "/games/addgame.jsp";
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
	public String edit(@Valid @ModelAttribute("game") Game game, BindingResult result) {
		if(result.hasErrors()) {
			return "editgame.jsp";
		}
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
