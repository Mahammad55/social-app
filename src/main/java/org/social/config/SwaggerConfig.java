package org.social.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myOpenApi() {
        Contact contact = new Contact();
        contact.setName("Mahammad");
        contact.setEmail("ilyazovmehememd@gmail.com");

        Info info = new Info()
                .title("Course ERP Api")
                .contact(contact)
                .version("1.0")
                .description("This project is for course erp API s");

        return new OpenAPI().info(info);
    }
}
