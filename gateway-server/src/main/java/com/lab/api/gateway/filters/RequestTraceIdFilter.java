package com.lab.api.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Order(1)//when multiple filter to be executed
@Component
public class RequestTraceIdFilter implements GlobalFilter {

	private static final Logger logger = LoggerFactory.getLogger(RequestTraceIdFilter.class);
	//To generate a trace id for each request
	//Since the gateway is built with spring reactive not on servelet model Mono<Void>  (single value)/Flux<T> (multiple values) , params
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String requestId = generateRequestId();
        exchange = exchange.mutate().request(exchange.getRequest().mutate().header("tracking-id", requestId).build()).build();
        logger.debug("request-id generated in RequestTraceIdFilter : {}", requestId);
        
        return chain.filter(exchange);
	}
	
    private String generateRequestId() {
        return java.util.UUID.randomUUID().toString();
    }
}
