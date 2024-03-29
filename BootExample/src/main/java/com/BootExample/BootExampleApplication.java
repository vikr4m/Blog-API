package com.BootExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(BootExampleApplication.class, args);
		Alien a = context.getBean(Alien.class);
		a.show();
		
	}

}
