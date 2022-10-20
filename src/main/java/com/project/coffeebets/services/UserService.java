package com.project.cofeebets.services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.project.cofeebets.models.LoginUser;
import com.project.cofeebets.models.User;
import com.project.cofeebets.repositories.UserRepository;
    

    
@Service
public class UserService {
    
	public final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo; 
	}
	
	public User getUser(String email) {
		Optional<User> potentialUser = userRepo.findByEmail(email);
		return potentialUser.isPresent() ? potentialUser.get() : null; 
	}
	
	public User getUserById(Long id) {
		Optional<User> potentialUser = userRepo.findById(id);
		return potentialUser.isPresent() ? potentialUser.get() : null; 
	}
	
	public User registerUser(User newUser) {
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser); 
	}
	
	
    
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	
        return null;
    }
    
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        if(result.hasErrors()) {
        	return null; 
        }
        User existingUser = getUser(newLoginObject.getEmail());
        if(existingUser == null) {
        	result.rejectValue("email", "Unknown", "Register first, email not found!");
        	return null;
        }
        if(!BCrypt.checkpw(newLoginObject.getPassword(), existingUser.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
            return null;
        }
        return existingUser; 
        

    }
}
