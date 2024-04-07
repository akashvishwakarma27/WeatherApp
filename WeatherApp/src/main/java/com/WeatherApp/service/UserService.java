package com.WeatherApp.service;

import java.util.Optional;

import com.WeatherApp.exception.UserException;
import com.WeatherApp.model.MyUser;

public interface UserService {
	MyUser createUser(MyUser myUser) throws UserException;
	Optional<MyUser> findByEmail(String Email);
}
