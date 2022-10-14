package com.example.CS3141R01Team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Cs3141R01Team2Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs3141R01Team2Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Cs3141R01Team2Application.class, args);
	}

}
