package com.Incentro.MicroservicesUsers.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

   @Bean
   public OpenAPI customOpenApi() 
   {
	   return new OpenAPI()
			   .info(new Info().title("API Documentation").version("1.0.0"));
   }
}
