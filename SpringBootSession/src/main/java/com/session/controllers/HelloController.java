package com.session.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.model.User;

@RestController
public class HelloController {

	@GetMapping("hello")
	public String sayHello(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "You have to login first";
		}
		User user = (User) session.getAttribute("user");
		return "Hello " + user.getUserName() + "! Welcome to the Application";

	}

}
