package com.houdaifa.stockmanagement.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.RequestHandledEvent;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()

                .info(new Info().title("Stock management api")
                        .description("this api used for an stock")
                        .version("1.0")
                        .contact(new Contact().name("Houdaifa R'bahi")
                                .email("rbahihoudaifa5@gmail.com")
                                .url("https://github.com/Houdaifa12"))

                );






    }
}
