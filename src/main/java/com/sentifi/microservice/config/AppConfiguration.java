package com.sentifi.microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

	@Bean
	@Lazy
	public RestTemplate initBeanRestTemplate() {
		return new RestTemplate();
	}

}
