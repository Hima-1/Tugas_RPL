package com.kel5.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/productsImages/**")
                .addResourceLocations("file:///C:/Users/hp/Documents/GitHub/Tugas_RPL/productsImages/")
                .setCachePeriod(0);  // Disable caching
        registry.addResourceHandler("/css/**", "/images/**", "/js/**", "/static/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/", "classpath:/static/js/", "classpath:/static/");
    }
}
