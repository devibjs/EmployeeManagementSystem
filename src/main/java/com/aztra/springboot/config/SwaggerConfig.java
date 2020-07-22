/**
 * 
 */
package com.aztra.springboot.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author 38609
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.aztra.springboot.controller"))
				.paths(regex("/employee.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Employee Management API").description("Employee management System")
				.termsOfServiceUrl("http://localhost:8080").license("License").licenseUrl("DeviS2@hexaware.com")
				.version("1.0").build();
	}

}
