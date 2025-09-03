package com.cognizant.boot.security;

import com.cognizant.boot.security.configs.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private final AppConfig appConfig;

    Application(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
