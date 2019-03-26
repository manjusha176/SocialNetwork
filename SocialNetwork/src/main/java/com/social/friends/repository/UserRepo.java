package com.social.friends.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.social.friends.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{
	
}