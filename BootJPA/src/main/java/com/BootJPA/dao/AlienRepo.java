package com.BootJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BootJPA.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	//function to fetch by any column(should start with 'findBy' followed by the column name in db)
	List<Alien> findByTech(String tech);
	
	//custom query h2ql
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String Tech);
}
