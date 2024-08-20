package com.lab.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	
	@Bean
	public RouteLocator labRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(
						p->p.path("/lab/user/**")  //WHEN MATCHES THE PATH PREDICATE RETURNS TRUE AND EXECUTES THE FILTERS
						.filters(
								f->f.rewritePath("/lab/(?<segment>.*)","/${segment}")  //SEGMENT IS THE BASE PATH OF MS
								.addResponseHeader("custom", "value")
								)
						.uri("lb://LAB-USER-MANAGEMENT")  //LB-> GATEWAY DOES CLIENT SIDE LOAD BALANCING BASED ON APP NAME IN EUREKA
						)
				.route(
						p->p.path("/lab/reports/**")
						.filters(
								f->f.rewritePath("/lab/(?<segment>.*)","/${segment}")
								//MORE FILTERS
								)
						.uri("lb://LAB-REPORTS")
						)
				.build();
		//NOTE: Disable discover locator to avoid default routing configuration. Java based configure is more flexible than yml based route configuration
	}

}
