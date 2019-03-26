package com.social.friends.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.social.friends.model.User;
import com.social.friends.repository.UserRepo;
import com.social.friends.service.AuthenticationService;

@Component
public class AuthenticationServiceImpl implements AuthenticationService {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	public UserRepo userRepository;
	
	/** The b crypt password encoder. */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public String saveUser(User userData) {
		try{
			Optional<User> dbUserOptional = userRepository.findById(userData.getEmail());
			User dbUser = dbUserOptional.isPresent() ? dbUserOptional.get() : null;
			if (dbUser == null){
				String encodedPassword = bCryptPasswordEncoder.encode(userData.getPassword());
				userData.setPassword(encodedPassword);
				userRepository.save(userData);
				return "User saved successfully";
			} else{
				return "This mail is already registered!";
			}
		} catch (Exception e){
			log.error(e.getMessage(), e);
			throw e;
		}

	}

	@Override
	public String validateUser(User user) {
		try{
			Optional<User> dbUserOptional = userRepository.findById(user.getEmail());
			User userFromDb = dbUserOptional.isPresent() ? dbUserOptional.get() : null;
			if (userFromDb != null){
				if (userFromDb.getPassword().equals(user.getPassword())){
					log.info("email & password exists");
					return "email & password exists";
				} else log.info("password invalid");
				return "password invalid";
			} else{
				log.info("email Not exists");
				return "email Not exists";
			}
		} catch (Exception e){
			log.error(e.getMessage(), e);
			throw e;
		}
	}

}