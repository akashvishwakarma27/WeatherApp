package com.WeatherApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeatherApp.exception.UserException;
import com.WeatherApp.model.MyUser;
import com.WeatherApp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public MyUser createUser(MyUser myUser) throws UserException {
		return userRepository.save(myUser);
	}

	@Override
	public Optional<MyUser> findByEmail(String Email) {
			Optional<MyUser> users = userRepository.findByEmail(Email);
			 if(users.isEmpty()) throw new UserException("No user found");
			 return users;
		}

}
