package com.social.friends.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	String firstName;
	String lastName;
	@Id
	String email;
	String phoneNumber;
	String password;
	
}