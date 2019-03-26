package com.social.friends.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.friends.model.User;
import com.social.friends.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	public static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationService authService;
	
	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return authService.getAllUsers();
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User user) {
		return authService.saveUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		log.debug("LoginController:validateLogin:Username-" + user.getEmail());
		String result = authService.validateUser(user);

		if (result.equals("email & password exists")){
			log.debug("Welcome To SocialNetwork");
			return "Success";
		} else{
			return "Failed";
		}
	}
}