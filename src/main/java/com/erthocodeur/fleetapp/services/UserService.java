package com.erthocodeur.fleetapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.erthocodeur.fleetapp.models.User;
import com.erthocodeur.fleetapp.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired UserRepository userRepository;
	public void save(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		userRepository.save(user);
		
	}

}















