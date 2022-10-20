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

import com.project.coffeebets.models.Stadium;
import com.project.coffeebets.models.User;
import com.project.coffeebets.services.GameService;
import com.project.coffeebets.services.StadiumService;
import com.project.coffeebets.services.UserService;

@Controller
@RequestMapping("/stadiums")
public class StadiumController {
	
	public final GameService gameServ; 
	public final StadiumService stadiumServ; 
	public final UserService userServ;
	public StadiumController(GameService gameServ,StadiumService stadiumServ, UserService userServ) {
		this.gameServ = gameServ;
		this.stadiumServ = stadiumServ;
		this.userServ = userServ;
	}
	
	
	// Create 
	
	@GetMapping("/addstadium")
	public String add(@ModelAttribute("stadium") Stadium stadium) {
		return "/stadiums/addStadium.jsp";
	}
	
	
	@PostMapping("/addstadium")
	public String add(@Valid @ModelAttribute("stadium") Stadium stadium, BindingResult result,Long id) {
		
		if(result.hasErrors()) {
			System.out.println(stadium.getCapacity());
			return "/stadiums/addStadium.jsp";
		}else {
			stadiumServ.addStadium(stadium);
			return "redirect:/dashboard";
		}
	}
	
	// Get One
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model, HttpSession session) {
//		if(session.getAttribute("user_id") == null) {
//			return "redirect:/";
//		}
		Stadium stadium = stadiumServ.getOne(id);
		model.addAttribute("stadium", stadium);
		return "/stadiums/stadium.jsp"; 
	}
	
	// Get All 
	
	@GetMapping("/all")
	public String newNinja(@ModelAttribute("stadium") Stadium stadium, Model model, HttpSession session) {
		Long id = (Long) session.getAttribute("user_id");
		User user = userServ.getUserById(id);
		List<Stadium> allStadiums = stadiumServ.allStadiums();
		model.addAttribute("stadiums", allStadiums);
		model.addAttribute(user);
		return "/stadiums/stadiums.jsp";
	}
	
	//update
	
	@GetMapping("/edit/{id}")
	public String viewEdit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Stadium stadium = stadiumServ.getOne(id);
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		model.addAttribute("stadium", stadium);
		return "editstadium.jsp"; 
	}
	
	
	@PutMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("stadium") Stadium stadium, BindingResult result) {
		if(result.hasErrors()) {
			return "editstadium.jsp";
		}
		stadiumServ.updateStadium(stadium);
		return "redirect:/dashboard";
	}
	
	
	//Delete
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		stadiumServ.delete(id);
		return "redirect:/dashboard";
	}
	
	// Get out 
	
		@GetMapping("/notice")
		public String notice() {
			return "notice.jsp";
		}

}

