package com.WeatherApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.WeatherApp.model.MyUser;
import com.WeatherApp.repository.UserRepository;

@Service
public class ManualUserDetailsService implements UserDetailsService{
	
	@Autowired
	 private UserRepository userRepository;
	
	public boolean isUser(String email) {
		Optional<MyUser> users = userRepository.findByEmail(email);
		if(users.isPresent()) return true;
		else return false;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<MyUser> myUser = userRepository.findByEmail(email);
		 
		 if(myUser.isEmpty()) throw new UsernameNotFoundException("User not found");
		 MyUser us = myUser.get();
		 
			List<GrantedAuthority> authorities = new ArrayList<>() ;
			SimpleGrantedAuthority autho = new SimpleGrantedAuthority("USER") ;
			authorities.add(autho) ;
			User secUser = new User(us.getEmail(), us.getPassword(),  authorities) ;
			return secUser ;
	}

}
