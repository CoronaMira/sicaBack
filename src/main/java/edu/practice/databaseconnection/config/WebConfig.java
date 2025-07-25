package edu.practice.databaseconnection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Aplica la configuración a todas las rutas que empiecen con /api/
                registry.addMapping("/api/**")
                        // Permite peticiones desde tu frontend de React
                        .allowedOrigins("http://localhost:3000")
                        // Permite los métodos HTTP necesarios
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Permite todas las cabeceras (incluyendo Content-Type y X-API-KEY)
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
