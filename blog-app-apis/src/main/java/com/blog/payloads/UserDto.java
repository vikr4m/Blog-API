package com.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int id;
	
	@NotEmpty
	@Size(min = 4,message="Username must be more than 3 characters")
	private String name;
	
	@Email(message = "Your email is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be between 3 to 10 characters.")
	private String password;
	
	@NotEmpty
	private String about;
	
}
