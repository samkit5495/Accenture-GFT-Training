package com.accenture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfiguration {

	@Bean
	public Date getDate(){
		return new Date(1,2,3);
	}

	@Primary
	@Bean
	public Date newDate(){
		return new Date(4,5,6);
	}
}
