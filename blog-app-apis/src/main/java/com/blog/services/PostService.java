package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {
	//create
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	public PostDto updatePost(PostDto postDto, Integer postId); 
	
	//delete
	public void deletePost(Integer postId);
	
	//get
	public PostDto getPostById(Integer postId);

	//get all
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get all by category
	public List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get all posts by user
	public List<PostDto> getPostsByUser(Integer userId);
	
	//search
	public List<PostDto> searchPost(String keyword);
	
}
