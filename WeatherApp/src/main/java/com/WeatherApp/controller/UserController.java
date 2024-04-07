package com.WeatherApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WeatherApp.exception.UserException;
import com.WeatherApp.model.MyUser;
import com.WeatherApp.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @Autowired
	private PasswordEncoder  passwordEncoder;
	
	 @GetMapping("/signin")
		public ResponseEntity<String> logInUserHandler(Authentication auth) throws UserException{	 
			MyUser user= userService.findByEmail(auth.getName()).get();
			 return new ResponseEntity<>(user.getEmail()+" Logged In Successfully", HttpStatus.ACCEPTED);
	 }
   
   @PostMapping("/register")
   private ResponseEntity<MyUser> createUser(@Valid @RequestBody MyUser myUser){
   	myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
	   MyUser use = userService.createUser(myUser);
	   return new ResponseEntity<MyUser>(use, HttpStatus.CREATED);
  } 
}
