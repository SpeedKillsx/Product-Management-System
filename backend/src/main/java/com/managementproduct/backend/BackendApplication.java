package com.managementproduct.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;






@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0", description = "Documentation API"))
@CrossOrigin(origins = "*")
@SpringBootApplication(scanBasePackages = {"com.managementproduct.backend", "com.managementproduct.backend.Category", "com.managementproduct.backend.Product"}, exclude = {SecurityAutoConfiguration.class})
public class BackendApplication {

		public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	
}
