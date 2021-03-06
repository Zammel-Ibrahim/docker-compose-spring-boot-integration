package com.example.springdockercompose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootDockerComposeApplication {

	@RequestMapping("/")
    public String home() {
        return "docker Compose integration with a spring-boot application";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDockerComposeApplication.class, args);
	}
}
