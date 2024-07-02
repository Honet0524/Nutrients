package com.project.Nutrients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NutrientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutrientsApplication.class, args);
	}

}
