package com.example.consumer.config;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.WebClientHttpRoutingFilter;
import org.springframework.cloud.gateway.filter.WebClientWriteResponseFilter;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {
	
	@Bean
	public WebClientHttpRoutingFilter webClientHttpRoutingFilter(WebClient webClient, ObjectProvider<List<HttpHeadersFilter>> headersFilters) {
		return new WebClientHttpRoutingFilter(webClient, headersFilters);
	}
	
	@Bean
	public WebClientWriteResponseFilter webClientWriteResponseFilter() {
		return new WebClientWriteResponseFilter();
	}

}
