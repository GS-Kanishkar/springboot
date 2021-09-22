package com.jpa.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerController {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jpa"))
				.paths(PathSelectors.any())
		  		.build().apiInfo(apiEndPointInfo());
		
		
	}

	private ApiInfo apiEndPointInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder().title("Spring boot project rest api")
				.description("Consumer api")
				.contact(new Contact("kani", null, null))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("0.0.1-SNAPSHOT")
				.build();
	}
}