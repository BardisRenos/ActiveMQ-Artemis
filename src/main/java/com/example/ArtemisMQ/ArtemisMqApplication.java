package com.example.ArtemisMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ArtemisMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtemisMqApplication.class, args);
	}

}
