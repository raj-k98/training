package com.session.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.session.model.User;

@RestController
public class LoginController {
	
	@PostMapping("/login")
	public String login(@RequestBody User user, HttpServletRequest request) {
		
		String userName= user.getUserName();
		if(!(userName.equals("ramana"))) {
			return "invalid user name";
		}
		
		String password=user.getPassword();
		if(!(password.equals("ramana"))) {
			return "invalid password";
		}
		
		HttpSession session = request.getSession();
		if(session.isNew()) {
			session.setAttribute("user", user);
			return "Login success";
		}
		return "User Already logged in";
	}

}
