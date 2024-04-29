package com.lab.user.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.lab.user.management.repository")
public class LabUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabUserManagementApplication.class, args);
	}

}
