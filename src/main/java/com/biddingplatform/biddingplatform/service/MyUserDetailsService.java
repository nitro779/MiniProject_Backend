package com.biddingplatform.biddingplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biddingplatform.biddingplatform.dao.UsersDAO;
import com.biddingplatform.biddingplatform.models.User;
import com.biddingplatform.biddingplatform.utils.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UsersDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = userRepository.findUserByUsername(username);
    	User user = userDao.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user);
    }
}
