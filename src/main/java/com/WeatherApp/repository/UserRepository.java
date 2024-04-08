package com.WeatherApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WeatherApp.model.MyUser;

public interface UserRepository extends JpaRepository<MyUser, Integer> {
	Optional<MyUser> findByEmail(String Email);
}