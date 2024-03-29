package com.BootJPA.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.BootJPA.dao.AlienRepo;
import com.BootJPA.model.Alien;

@RestController
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
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
	
	@PostMapping("/addalien")
	public Alien addalien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@GetMapping(path="/getaliens")
	@ResponseBody
	public List<Alien> getalien() {
		return repo.findAll();
	}
	
	@GetMapping("/getalien/{aid}")
	@ResponseBody
	public Optional<Alien> getalien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
//	@GetMapping("/getbytechalien")
//	public ModelAndView getbytechalien(@RequestParam int aid,@RequestParam String tech) {
//		ModelAndView mv = new ModelAndView("showalien.jsp");
//		List<Alien> alien = repo.findByTech(tech);
//		System.out.println(repo.findByTech(tech));
//		mv.addObject(alien);
//		return mv;
//	}
	
	@DeleteMapping("/deletealien/{aid}")
	public String deletealien(@PathVariable int aid) {
		Alien a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping(path="/updatealien")
	public Alien updatealien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
}
