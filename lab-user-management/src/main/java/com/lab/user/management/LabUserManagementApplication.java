package com.lab.user.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lab.user.management.dto.CodeOwner;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories("com.lab.user.management.repository")
@EnableConfigurationProperties(value = {CodeOwner.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Lab User",
				description = "Lab User microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Vinod G",
						email = "vinodgowda1998@gmail.com",
						url = ""
				)
		)
)
public class LabUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabUserManagementApplication.class, args);
	}

}
