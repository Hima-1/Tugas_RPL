package com.kel5.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String baseDir = System.getProperty("user.dir");
        registry.addResourceHandler("/productsImages/**")
                .addResourceLocations("file:" + baseDir + "/productsImages/")
                .setCachePeriod(0);
        registry.addResourceHandler("/css/**", "/images/**", "/js/**", "/static/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/", "classpath:/static/js/", "classpath:/static/");
    }
}
