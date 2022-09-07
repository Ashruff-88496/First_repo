package com.zensar.tp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ModelBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.mappers.ModelMapperImpl;

@SpringBootApplication
@EnableSwagger2

public class TpUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpUserManagementApplication.class, args);
		
		}
	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
	
	   }
