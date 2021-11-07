package com.example.projetg4.controllers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetg4.models.User;
import com.example.projetg4.repositories.UserRepo;


@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	UserRepo rep ;
	

	@GetMapping("/")
	public String home() {
		return "hello" ;
	}
	

	  @GetMapping("/show")
	    public List<User> getAll(){
	        List<User> users = this.rep.findAll();
	        return users;
	    }
	
	
	  @PostMapping("/register")
	    public boolean update(@RequestBody User user){
		  try {
		    User u = new User(user.getEmail() , user.getPassword() , user.getFullname() , user.getGender() , user.getAdress() ) ; 
	        this.rep.save(u);
	        return true ; }
		  catch(Exception E){
			  return false ;
		  }
	    }
	  

	  @PostMapping("/login")
	    public boolean login(@RequestBody User user){
	        User users = this.rep.findByEmail(user.getEmail());
	        if (users != null && (users.getPassword().equals(user.getPassword()) )) {
	        	
	        	 return true  ;
	        }
	        else return false ; 
	    }
	  
	

	  
	
	  
	
}
