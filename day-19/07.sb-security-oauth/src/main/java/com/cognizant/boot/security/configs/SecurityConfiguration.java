package com.cognizant.boot.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
   httpSecurity.authorizeHttpRequests(request -> request.anyRequest()
		   												.authenticated());
   
   httpSecurity.oauth2Login(Customizer.withDefaults());  //Configures authentication support using an OAuth 2.0 and/or OpenID Connect 1.0Provider. 

   return httpSecurity.build();
 }
}
