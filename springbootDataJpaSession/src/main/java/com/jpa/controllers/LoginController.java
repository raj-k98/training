package com.jpa.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.LoginCredentials;
import com.jpa.entity.User;
import com.jpa.exceptions.InvalidUserException;
import com.jpa.repository.UserRepository;

@RestController
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("login")
	public String login(@RequestBody LoginCredentials credentials, HttpServletRequest request) {

		User user = null;
		Optional<User> opt = userRepository.findById(credentials.getUsername());
		if (opt.isPresent())
			user = opt.get();
		else
			throw new InvalidUserException("User with name " + credentials.getUsername() + " does not exist");

		if (!user.getPassword().equals(credentials.getPassword()))
			throw new InvalidUserException("Invalid password");

		HttpSession session = request.getSession();

		session.setAttribute("name", user.getUsername());

		return "Login Success";
	}

	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		if (session == null) {
			throw new InvalidUserException("User not logged in");
		}
		session.invalidate();
		return "User successfully loggedout";

	}
}
