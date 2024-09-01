package com.lab.api.gateway;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;


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
								.circuitBreaker(
										config -> config.setName("usermanagementCircuitBreaker")  // Can have multiple CB for an API/MS. The name is used to configure the properties specifically/default
										.setFallbackUri("/support")  //[FALLBACK MECHANISM] Sends a custom response instead of runtime exception
										)
								.retry(
										retryConfig-> retryConfig.setRetries(3)  //along with 1st request 3 retries will be made
										.setMethods(HttpMethod.GET)
										.setBackoff(Duration.ofMillis(100),Duration.ofMillis(1000),2,true)
										//args[0]-> waits for 100 ms to initiate 1st retry
										//args[1]-> maximum backoff duration time between retries will not exceed (1 second) even after multiple retries.
										//args[2]-> multiplied by the specified factor example, after the first failure, the wait time will be 100 milliseconds, then 200 milliseconds (100 * 2), then 400 milliseconds (200 * 2), and so on, until it reaches the maximum of 1000 milliseconds.
										//args[3]-> tells GS to apply factor of previous or initial back off value
										)
								)
						.uri("lb://LAB-USER-MANAGEMENT")  //LB-> GATEWAY DOES CLIENT SIDE LOAD BALANCING BASED ON APP NAME IN EUREKA
						//change in code + call metadata method and pass the key value to set the timeout for specific path
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
	
	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(4)).build()).build());
	}
}
