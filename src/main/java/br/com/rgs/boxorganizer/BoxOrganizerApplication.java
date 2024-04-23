package br.com.rgs.boxorganizer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info=@Info(version = "${system.version}", title = "${spring.application.name}"))
@SpringBootApplication
public class BoxOrganizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxOrganizerApplication.class, args);
	}

}
