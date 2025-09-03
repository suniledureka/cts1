package com.cognizant.boot.security.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
  @Autowired
  private DataSource dataSource;
  
  @Autowired
  private BCryptPasswordEncoder encoder;
  
  @Bean
  public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception {
	  
	  http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
	  
	  http.csrf(csrf -> csrf.disable());
	  
	  http.httpBasic(Customizer.withDefaults()); //Configures HTTP Basic authentication. 
	  
	  DefaultSecurityFilterChain filterChain = http.build();
	  
	  return filterChain;
  }
  
 
	@Bean
	public UserDetailsService generateUsers() {
		UserDetails user1 = User.withUsername("admin")
								//.password(encoder.encode("12345"))
								.password("12345")
								.passwordEncoder(pwd -> encoder.encode(pwd))
								.roles("ADMIN", "MANAGER")
								.build();
		
		var user2 =User.withUsername("sunil")	
				//.password(encoder.encode("password123#"))
				.password("password123#")
				.passwordEncoder(pwd -> encoder.encode(pwd))				
				.roles("MANAGER")
				.build();
		
		UserDetailsManager userDtlsMgr = new JdbcUserDetailsManager(dataSource);
		userDtlsMgr.createUser(user1);
		userDtlsMgr.createUser(user2);	
		
		return userDtlsMgr;
	} 
}

