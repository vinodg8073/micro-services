package com.lab.reports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.lab.reports.repository")
public class LabReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabReportsApplication.class, args);
		
//		Report r = new Report(0, 0, 0);
//		System.out.println(r.getCreatedDate());	
	}
}
