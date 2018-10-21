package com.glovoapp.backender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class SourcesPlaceholderConfiguration {

    private SourcesPlaceholderConfiguration() {}

    @Bean
    public static PropertySourcesPlaceholderConfigurer sourcesPlaceholderProperties() {
        PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        placeholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        return placeholderConfigurer;
    }

}
