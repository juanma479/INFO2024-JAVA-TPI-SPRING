package com.info.tpi.spring.gestion_recetas;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API de Gestión de Recetas de Cocina",
				description = "Esta es la documentacion de la API REST para el TPI de Spring" +
						" del curso de Java del Informatorio 2024. ",
				version = "v1",
				contact = @Contact(
						name = "Juan Manuel González",
						email = "juanmamk9@gmail.com",
						url = "https://github.com/juanma479"
				)
		)
)
public class GestionRecetasApplication{


	public static void main(String[] args) {
		SpringApplication.run(GestionRecetasApplication.class, args);
	}


}
