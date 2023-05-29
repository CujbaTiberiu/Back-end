package com.day2.spring_bean.Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {

	@Bean
	public Test test() {
		return new Test("Gianni", "Via vai 2");
	}
}
