package com.biddingplatform.biddingplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.biddingplatform.biddingplatform.dao.UsersDAO;
import com.biddingplatform.biddingplatform.models.User;
import com.biddingplatform.biddingplatform.service.UsersService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsersController {

    @Autowired
    private UsersService userService;
    
    @Autowired
    private UsersDAO dao;


    @GetMapping("/")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.ok("Hello");
    }

    @PostMapping("/users/register")
    public boolean registerUser(@RequestBody User user){
        return userService.insertUser(user);
    }
    
    @GetMapping("/users/login")
    public void loginUser(){
    	
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers(){
    	return dao.findAllUsers();
    }
    
    @GetMapping("/users/{uname}")
    public int getUserId(@PathVariable("uname") String username) {
    	return dao.findUserIdByUserName(username);
    }
    
	
	  @GetMapping("users/username/{uid}") 
	public User getUsername(@PathVariable("uid") int uid) { 
		  System.out.println(uid);
		  return userService.getUsername(uid);
	}
	  
	@GetMapping("/users/forgot/{username}")
	public int forgotPassword(@PathVariable("username") String username) {
		return userService.forgotPassword(username);
	}
}

