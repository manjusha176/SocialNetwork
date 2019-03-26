package com.social.friends.service;

import java.util.List;

import com.social.friends.model.User;

public interface AuthenticationService{

	List<User> getAllUsers();
	String saveUser(User userData);
	String validateUser(User user);
}