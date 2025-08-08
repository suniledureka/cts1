package com.cognizant.boot.beans.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cognizant.boot.utils.SecurityUtility;

@Configuration
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}

	//@Bean
	//@Bean("security")
	//@Bean(name = "security")
	//@Bean(value = "security")
	//@Bean(value = {"security", "encoder"})
	@Bean(value = {"security", "encoder"}, initMethod = "myInit", destroyMethod = "destroy")
	//@Scope(value = "singleton")
	@Scope(value = "prototype")
	public SecurityUtility securityGenerator() {
		return new SecurityUtility();
	}
}
