package userapi.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Klasse für Swagger Dokumentation
 *
 * @author MDzan
 */
@Configuration
public class OpenApiConfig{

    @Bean
    public OpenAPI userOpenApiConfig() {
        return new OpenAPI().info(new Info()
                .title("User API")
                .description("REST-API zur Verwaltung von Benutzern")
                .version("v1"));
    }
}
