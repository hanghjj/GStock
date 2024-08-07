package com.gp1.gstock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
            registry.addViewController("/{spring:\\w+")
                    .setViewName("forward:/");
            registry.addViewController("/**/{spring:\\w+")
                    .setViewName("forward:/");
            registry.addViewController("/{spring:\\w+/**{spring:?!(\\.js|||.css)$}")
                    .setViewName("forward:/");
    }
}
