package com.lab.user.management.dto;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "code-owner") // to read an object from application.yml make sure variable names are matched
public record CodeOwner(String name, String email, List<String> contact) {

}
