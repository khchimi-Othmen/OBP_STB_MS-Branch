package tn.stb.branch.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringDocConfig {
    //    http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());
    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo").description("TP étude de cas").contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II").email("othmenkhchimi@esprit.tn").url("https://www.linkedin.com/in/KhchimiOthmen/");
        return contact;
    }
    /*@Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Product Management API")
                                .pathsToMatch("/product/**")
                                .pathsToExclude("**")
                                .build();

    }*/
}