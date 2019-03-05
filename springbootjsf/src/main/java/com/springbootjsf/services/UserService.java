package com.springbootjsf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.springbootjsf.model.User;
import com.springbootjsf.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;


	public User checkUser(String userName, String password) {
		
		User user = null;
		user = userRepository.findByUsernameAndPassword(userName, password);
		
		if (user != null) {
			return user;
		}

		return null;

	}
	
	public List<String> findAllPassword() {
		return userRepository.findAllPassword();
	}
	
	public User findByPassword(String password) {
		return userRepository.findByPassword(password);
	}

}
