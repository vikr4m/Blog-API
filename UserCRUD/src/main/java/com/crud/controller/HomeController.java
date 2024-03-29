package com.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add.jsp";
	}
	
	@GetMapping("/update")
	public String updte() {
		return "update.jsp";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "delete.jsp";
	}
	
	@GetMapping("/fetch")
	public String fetch() {
		return "fetch.jsp";
	}
}
