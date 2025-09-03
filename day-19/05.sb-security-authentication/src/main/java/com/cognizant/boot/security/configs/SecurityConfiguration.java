package com.cognizant.boot.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
  
  @Bean
  public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
	  
	  http.authorizeHttpRequests(request -> request.requestMatchers("/home", "/contact")
			  									   .permitAll()
			  									   .anyRequest()
			  									   .authenticated());
	  
	  http.csrf(csrf -> csrf.disable());
	  
	  http.httpBasic(Customizer.withDefaults());
	  
	  return http.build();
  }
}

