package com.shopping.backend.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.backend.domain.User;
import com.shopping.backend.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
		String firstName = (String) userMap.get("firstName");
		String lastName = (String) userMap.get("lastName");
		String email = (String) userMap.get("email");
		String password = (String) userMap.get("password");
		User user = userService.resgisterUser(firstName, lastName, email, password);
		Map<String, String> map = new HashMap<>();
		map.put("message", "registered successfully");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	

}
