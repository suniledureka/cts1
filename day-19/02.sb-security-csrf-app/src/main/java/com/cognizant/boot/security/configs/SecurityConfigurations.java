package com.cognizant.boot.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfigurations {
	
	@Bean
	public SecurityFilterChain customSecurityConfigurations(HttpSecurity http) throws Exception {
		System.out.println("inside security configurations");
		
		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		
		http.csrf(csrf -> csrf.disable());
		
		http.httpBasic(Customizer.withDefaults()); // configures HTTP Basic authentication.
		
		SecurityFilterChain securityFilterChain = http.build();
		
		return securityFilterChain;
	}
	
	/*--- global configuration for CORS ----*/
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*")
						.allowedOrigins("http://localhost:3000");
			}
		};
	}	
}
