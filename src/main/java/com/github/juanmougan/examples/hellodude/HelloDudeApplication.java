package com.github.juanmougan.examples.hellodude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.github.juanmougan")
public class HelloDudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloDudeApplication.class, args);
	}

}
