package com.lab.api.gateway.filters;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import reactor.core.publisher.Mono;

@Configuration
public class ResponseTraceFilter {

	private static final Logger logger = LoggerFactory.getLogger(ResponseTraceFilter.class);

	//just an another way to implement filter
	@Bean
	public GlobalFilter postGlobalFilter() {
		return (exchange, chain) -> {
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
				String trackingId = getRequestTrackingId(requestHeaders);
				logger.debug("Updated the correlation id to the outbound headers: {}", trackingId);
				exchange.getResponse().getHeaders().add("tracking-id", trackingId);
			}));
		};
	}

	private String getRequestTrackingId(HttpHeaders requestHeaders) {
		if (requestHeaders.get("tracking-id") != null) {
			List<String> requestHeaderList = requestHeaders.get("tracking-id");
			return requestHeaderList.stream().findFirst().get();
		} else {
			return null;
		}
	}
}
