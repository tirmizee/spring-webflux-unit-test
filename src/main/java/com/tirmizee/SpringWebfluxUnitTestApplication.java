package com.tirmizee;

import com.tirmizee.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebfluxUnitTestApplication {

	public static void main(String[] args) {
		var app = SpringApplication.run(SpringWebfluxUnitTestApplication.class, args);
		var userRepository = app.getBean(UserRepository.class);
		userRepository.getByUsername("tirmizee")
				.subscribe(System.out::println);
	}

}
