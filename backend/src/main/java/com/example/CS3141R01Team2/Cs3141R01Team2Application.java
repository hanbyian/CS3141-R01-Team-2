package com.example.CS3141R01Team2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author wmisip
 * @author eljones
 * @author
 *
 * Main Application Class to begin the backend
 */
@SpringBootApplication
public class Cs3141R01Team2Application extends SpringBootServletInitializer {

	/**
	 * Override method from SpringBootServletInitializer to configure the application
	 * for runtime
	 *
	 * @param application takes in the application for building
	 * @return returns the Spring Application Builder with the applicaiton
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Cs3141R01Team2Application.class);
	}

	/**
	 * Main method for running the application
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Cs3141R01Team2Application.class, args);
	}

}
