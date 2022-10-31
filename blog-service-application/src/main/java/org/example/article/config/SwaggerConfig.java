package org.example.article.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public SwaggerUiConfigProperties swaggerUiConfig(SwaggerUiConfigProperties configProperties) {
        configProperties.setDocExpansion("none");
        configProperties.setUseRootPath(true);
        return configProperties;
    }

    @Bean
    public OpenAPI openApi(@Value("@revision@") String version) {
        return new OpenAPI()
                .info(new Info().title("Article API")
                        .description("Article Service Documentation")
                        .version(version)
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
