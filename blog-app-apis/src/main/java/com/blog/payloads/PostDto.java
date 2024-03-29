package com.blog.payloads;

import java.util.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	private String postId;
	private String title;
	private String content;
	private String imageName;
	private Date addDate;
	private UserDto user;
	private CategoryDto category;
	
}
