package com.utn.frba.srs;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.utn.frba.srs.shared.infraestructure.SwaggerConfiguration;

@SpringBootApplication
@ComponentScan({ "com.utn.frba.srs.*" })
@Import(SwaggerConfiguration.class)
@EnableScheduling
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		TimeZone.setDefault(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
		
	}


}
