package com.social.friends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class EntryPoint that used to bootstrap and launch a application from a Java main.
 */
@SpringBootApplication
public class EntryPoint {
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(EntryPoint.class, args);
	}
}
