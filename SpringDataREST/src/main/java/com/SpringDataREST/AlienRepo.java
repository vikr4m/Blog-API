package com.SpringDataREST;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.SpringDataREST.model.Alien;

@RepositoryRestResource(collectionResourceRel = "aliens",path="aliens")
public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
}
