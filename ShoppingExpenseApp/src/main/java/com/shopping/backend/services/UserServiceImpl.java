package com.shopping.backend.services;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.backend.domain.User;
import com.shopping.backend.exception.EtAuthException;
import com.shopping.backend.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User validateUser(String email, String password) throws EtAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User resgisterUser(String firstName, String lastName, String email, String password) throws EtAuthException {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if(email != null) {
			email.toLowerCase();
		}
		if(!pattern.matcher(email).matches()) {
			throw new EtAuthException("Invalid email format");
		}
		Integer count = userRepository.getCountByEmail(email);
		if (count > 0) {
			throw new EtAuthException("Email already in use");
		}
		Integer userId = userRepository.create(firstName, lastName, email, password);
		return userRepository.findById(userId);
	}

}
