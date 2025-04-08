package br.com.fiap.pb_flix_api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
   public CorsConfig() {
   }

   public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**").allowedOrigins(new String[]{"*"}).allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"}).allowedHeaders(new String[]{"*"});
   }
}
