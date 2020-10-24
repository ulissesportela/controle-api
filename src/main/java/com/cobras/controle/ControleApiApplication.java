package com.cobras.controle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class ControleApiApplication {

	//public void addCorsMappings( CorsRegistry registry ) {
	//	registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
	//}
	
	public static void main(String[] args) {
		SpringApplication.run(ControleApiApplication.class, args);
	}

}
