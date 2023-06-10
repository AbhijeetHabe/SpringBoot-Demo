package com.springmvcvalidationdemo.pojo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	@Email(message = "invalid email-id format for username")
	@NotEmpty(message = "username can not be empty")
	private String username;
	
	//@Size(min = 7 , max = 15)
	@Pattern(regexp = "(?=.*[0-9])(?=.*[@#$%^&*])[A-Za-z0-9@#$%^&*]{7,15}" ,
	message = "invalid password , it must contain atleast 1 digit , 1 special symbol,"
			+ "with minimum length as 8 and max as 15")
	private String password;
	
	public User() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
