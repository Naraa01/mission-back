package com.example.mission_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.mission_back.repository")
public class MissionBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MissionBackApplication.class, args);
	}

}
