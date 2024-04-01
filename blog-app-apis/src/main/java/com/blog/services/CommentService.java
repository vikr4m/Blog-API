package com.blog.services;

import com.blog.payloads.CommentDto;

public interface CommentService {
	//create
	public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
	
	//delete
	public void deleteComment(Integer commentId);
	
}
