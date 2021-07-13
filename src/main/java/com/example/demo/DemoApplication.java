package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@Component
@Profile("!dev")
class CronComponent implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) {
		System.out.println(getClass());
	}
}

@Profile("dev")
@RestController
class SimpleRestController {

	SimpleRestController() {
		System.out.println(getClass());
	}

	@GetMapping("/hello")
	String hello() {
		return "Hello, world!";
	}
}