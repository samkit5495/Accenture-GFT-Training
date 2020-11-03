package com.accenture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

	@Bean
	public Customer newCustomer(){
		return new Customer("samkit",7,newAccount());
	}
	
	@Bean
	public Account newAccount(){
		return new Account(7,8564);
	}
}
