package com.management.microservices.product_service.Confing;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Openapiconfig {


    @Bean
    public OpenAPI productserviceAPI(){
        return new OpenAPI()
                .info(new Info().title("Product Services API")
                        .description("REST API for Product Services")
                        .version("/api/v1")
                        .license(new License().name("Apache")))
                .externalDocs(new ExternalDocumentation().description("Refer this to more Info")
                        .url("https://springdoc.org/"));
    }
}
