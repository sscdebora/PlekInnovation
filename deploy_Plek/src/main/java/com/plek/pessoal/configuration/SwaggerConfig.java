package com.plek.pessoal.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;


import springfox.documentation.service.Response;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors
		.basePackage("com.plek.pessoal.controller"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(metadata())
		.useDefaultResponseMessages(false)
		.globalResponses(HttpMethod.GET, responseMessage())
		.globalResponses(HttpMethod.POST, responseMessage())
		.globalResponses(HttpMethod.PUT, responseMessage())
		.globalResponses(HttpMethod.DELETE, responseMessage());
			
	}
	
	public static ApiInfo metadata() {
		
		return new ApiInfoBuilder()
			.title("API - Plek")
			.description("Projeto Plek - Projeto Integrador")
			.version("1.0.0")
			.license("Apache License Version 2.0")
			.licenseUrl("https://github.com/FehGusto, https://github.com/rodrigues-re, https://github.com/sscdebora, https://github.com/Gabs1993")
			.contact(contact())
			.build();
				
	}
 
	private static Contact contact() {
		return new Contact("Felipe Augusto, Débora Cristina, Gabriel Conceicão dos Santos, Regina Rodrigues, Matheus Moreira", 
				"https://github.com/FehGustohttps://github.com/rodrigues-re, https://github.com/sscdebora, https://github.com/Gabs1993, https://github.com/smoreiramatheus",
				"felipe.santos.ofic@gmail.com, gabrielcsantos1993@gmail.com, rodrigues.re95@gmail.com, deboracristinasantos5@gmail.com, ");
	
	}
	
	private static List<Response> responseMessage() {
		return new ArrayList<Response>() {
		private static final long serialVersionUID = 1L;
		
		{
			
				add(new ResponseBuilder().code("200")
				.description("Sucesso!").build());
				add(new ResponseBuilder().code("201")
				.description("Criado!").build());
				add(new ResponseBuilder().code("400")
				.description("Erro na requisição!").build());
				add(new ResponseBuilder().code("401")
				.description("Não Autorizado!").build());
				add(new ResponseBuilder().code("403")
				.description("Proibido!").build());
				add(new ResponseBuilder().code("404")
				.description("Não Encontrado!").build());
				add(new ResponseBuilder().code("500")
						.description("Erro!").build());
		
		}
		
		};
		
	}

}
