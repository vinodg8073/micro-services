package com.lab.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.user.management.dto.UserDetails;
import com.lab.user.management.service.UserService;

@RestController
@RequestMapping(path = "/api/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUserDetails/{userId}")
	public ResponseEntity<UserDetails> getUserDetails(@PathVariable int userId){
		var userDetails = userService.getUserDetailsById(userId);
		if (userDetails == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userDetails);
		else
			return ResponseEntity.status(HttpStatus.OK).body(userDetails);
	}
}
