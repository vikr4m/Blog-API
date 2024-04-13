package com.blog.services;

import java.util.List;

import com.blog.payloads.UserDto;

public interface UserService {
	
	//register users
	UserDto registerNewUser(UserDto user);
	
	//create
	UserDto createUser(UserDto user);
	
	//update
	UserDto updateUser(UserDto user, Integer userId);
	
	//get user
	UserDto getUserById(Integer userId);
	
	//get all users
	List<UserDto> getAllUsers();
	
	//delete
	void deleteUser(Integer userId);
}
