package com.lab.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallBackController {

	@RequestMapping("/support")
	public Mono<String> support(){
		return Mono.just("Please contact the administrator or support team.");
	}
}
