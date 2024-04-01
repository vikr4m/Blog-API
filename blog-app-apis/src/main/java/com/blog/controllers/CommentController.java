package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.services.CommentService;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.CommentDto;

@RestController
@RequestMapping("/api/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	// create
	@PostMapping("/comment/user/{userId}/post/{postId}")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment,
			@PathVariable("userId") Integer userId, @PathVariable("postId") Integer postId) {
		CommentDto createCommment = this.commentService.createComment(comment, postId, userId);

		return new ResponseEntity<CommentDto>(createCommment, HttpStatus.CREATED);
	}

	// delete
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable("commentId") Integer commentId) {
		this.commentService.deleteComment(commentId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully", true), HttpStatus.OK);
	}

}
