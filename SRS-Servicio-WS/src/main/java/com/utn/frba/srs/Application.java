package com.utn.frba.srs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.utn.frba.srs.configuration.SwaggerConfiguration;

@SpringBootApplication
@ComponentScan({ "com.utn.frba.srs.*" })
@Import(SwaggerConfiguration.class)
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//
//	}

}
