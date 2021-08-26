package com.diversius.acciona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AccionaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccionaApplication.class, args);
	}

}
