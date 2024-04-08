package com.WeatherApp.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "Name should not be Empty!!")
    private String name;

    @NotEmpty(message = "Email should not be Empty!!")
    @Email(message = "Email should be formatted!!")
    private String email;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


	public MyUser(Integer userId, @NotEmpty(message = "Name should not be Empty!!") String name,
			@NotEmpty(message = "Email should not be Empty!!") @Email(message = "Email should be formatted!!") String email,
			String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
    
    
}
