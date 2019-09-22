package com.summerland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.summerland.config.FileStorageProperties;
@EnableConfigurationProperties({FileStorageProperties.class})
@SpringBootApplication
public class SummerlandBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerlandBackendApplication.class, args);
	}

}
