package com.shopping.backend.services;

import com.shopping.backend.domain.User;
import com.shopping.backend.exception.EtAuthException;

public interface UserService {
	
	User validateUser(String email, String password) throws EtAuthException;
	
	User resgisterUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
