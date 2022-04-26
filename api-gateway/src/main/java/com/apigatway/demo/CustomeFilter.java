package com.apigatway.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomeFilter implements GlobalFilter {

	Logger logger = LoggerFactory.getLogger(CustomeFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		ServerHttpRequest request = exchange.getRequest();

		/*
		 * if (request.getHeaders().getFirst("Auth").equals("abc")) {
		 * logger.info("Header is : " + request.getHeaders().getFirst("Auth")); return
		 * chain.filter(exchange).then(Mono.fromRunnable(() -> {
		 * 
		 * ServerHttpResponse response = exchange.getResponse();
		 * 
		 * logger.info("Post Filter Response status : " + response.getStatusCode());
		 * 
		 * })); } else return null;
		 */
		logger.info("Inside API Gateway");
		return chain.filter(exchange);

	}

}
