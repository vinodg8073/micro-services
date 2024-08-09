package com.lab.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.user.management.dto.UserDetailsPageDTO;
import com.lab.user.management.service.IUserDetailsPageService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1", produces = { MediaType.APPLICATION_JSON_VALUE })

@Tag(name = "CRUD REST APIs for Lab user management", description = "CRUD REST APIs to CREATE, UPDATE, FETCH AND DELETE lab user details")

public class UserPageController {
	
	@Autowired
	private IUserDetailsPageService userDetailsPageService;
	
	@GetMapping("/getCompleteUserDetails/{userId}")
	@Operation(summary = "Fetch complete user details REST API", description = "REST API to fetch complete lab user details")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
			@ApiResponse(responseCode = "204", description = "HTTP Status NO CONTENT") })
	public ResponseEntity<UserDetailsPageDTO> getUserDetails(@PathVariable int userId) {
		var userDetails = userDetailsPageService.getCompleteUserDetails(userId);
		if (userDetails == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userDetails);
		else
			return ResponseEntity.status(HttpStatus.OK).body(userDetails);
	}
}
