package com.shopping.backend.repositories;

import com.shopping.backend.domain.User;
import com.shopping.backend.exception.EtAuthException;

public interface UserRepository {
	
	Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
	
	User findByEmailAndPassword(String email, String password) throws EtAuthException;
	
	Integer getCountByEmail(String email);
	
	User findById(Integer userId);
	

}
