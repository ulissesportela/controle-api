package com.cobras.controle.config;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.AlternateTypeRules;

import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	@Bean
	public Docket productApi() {
		Docket docket= new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cobras.controle.api.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metaData())
				.globalResponseMessage(RequestMethod.PUT, mensagemGlobal())
		        .globalResponseMessage(RequestMethod.GET, mensagemGlobal())
		        .globalResponseMessage(RequestMethod.DELETE, mensagemGlobal())
		        .globalResponseMessage(RequestMethod.GET, mensagemGlobal());
		return docket;
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Controle App").description("\"Controle App\"")
				.version("1.0.0").license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"").build();
	}

	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("Controle App").version("1.0").license("(C) Copyright Test")
				.description("The API provides a platform to query build test swagger api");

		return builder.build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	private List<ResponseMessage> mensagemGlobal()
	{
	    return new ArrayList<ResponseMessage>() {{
	        add(new ResponseMessageBuilder()
	            .code(500)
	            .message("Erro Interno do Servidor")
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(403)
	            .message("Usuario Não possui autorização para o Acesso")
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(404)
	            .message("Página não existe")
	            .build());
	        add(new ResponseMessageBuilder()
	            .code(401)
	            .message("Requer autenticação para o acesso")
	            .build());
	    }};
	}

}