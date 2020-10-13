package com.biddingplatform.biddingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.UsersDAO;
import com.biddingplatform.biddingplatform.models.User;

@Service
public class UsersService{

    @Autowired
    private UsersDAO userRepository;

    public boolean insertUser(User user) {
        if(userRepository.findUserByUsername(user.getUsername())==null && userRepository.findUserByEmail(user.getEmail())==null){
            userRepository.saveUser(user);
            return true;
        };
        return false;
    }
    
    public int getUserIdByUserName(String username) {
    	return userRepository.findUserIdByUserName(username);
    }
    
	 public User getUsername(int uid) { 
		 return userRepository.getUserName(uid); 
	}
	 
	public int forgotPassword(String username) {
		return userRepository.forgotPassword(username);
	}
	 
}
