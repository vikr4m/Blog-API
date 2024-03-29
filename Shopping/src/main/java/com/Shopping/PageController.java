package com.Shopping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Shopping.model.User;
import com.Shopping.repo.UserRepo;


@Controller
public class PageController {
	
	@Autowired
	UserRepo repo;
	
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@PostMapping("signup")
	public User signup(@RequestBody User user) {
		repo.save(user);
		return user;
	}
	
	@PostMapping("/logincheck")
	public String logincheck() {
		return "";
	}
}
