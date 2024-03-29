package com.crud.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
	@PostMapping("adduser")
	public String addUser() {
		
	}
}
