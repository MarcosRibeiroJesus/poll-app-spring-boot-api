package com.mrj.polls.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mrj.polls.config.property.PollAppProperty;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private PollAppProperty pollAppProperty;

    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //TODO inserir origem a partir do PollAppProperty => pollAppProperty.getOriginPermitida()
                .allowedOrigins("*")
                .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
                .maxAge(MAX_AGE_SECS);
    }
}