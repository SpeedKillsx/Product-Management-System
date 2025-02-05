package com.managementproduct.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.managementproduct.backend", "com.managementproduct.backend.Category", "com.managementproduct.backend.Product"}, exclude = {SecurityAutoConfiguration.class})
public class BackendApplication {

		public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	
}
